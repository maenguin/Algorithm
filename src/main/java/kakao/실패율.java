package kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 실패율 {

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int totalChallengerCnt = stages.length;

        for (int i = 0; i < stages.length; i++) {
            if (stages[i] -1 < N)
                answer[stages[i] -1]++;
        }

        List<Stage> stageList = new ArrayList<>();
        for (int i = 0; i < answer.length; i++) {
            int notClearCnt = answer[i];
            double failureLate = notClearCnt/(double)totalChallengerCnt;
            totalChallengerCnt -= notClearCnt;
            stageList.add(new Stage(i+1,failureLate));
        }

        Collections.sort(stageList);
        return stageList.stream().mapToInt(s -> s.no).toArray();
    }

    static class Stage implements Comparable<Stage>{


        int no;
        double failureLate;

        public Stage(int no, double failureLate) {
            this.no = no;
            this.failureLate = failureLate;
        }

        @Override
        public int compareTo(Stage o) {
            return this.failureLate > o.failureLate ? -1 : (this.failureLate < o.failureLate ? 1 : Integer.compare(this.no, o.no));
        }

        @Override
        public String toString() {
            return "[ "+ no + " " + failureLate + " ]";
        }
    }


}
