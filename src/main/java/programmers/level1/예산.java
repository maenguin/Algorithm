package programmers.level1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 예산 {

    public int solution(int[] d, int budget) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i : d) {
            priorityQueue.offer(i);
        }
        int answer = 0;

        while (!priorityQueue.isEmpty() && (budget -= priorityQueue.poll()) >= 0) {
            answer++;
        }
        return answer;
    }

    //우선순위 큐는 균등한 속도였지만
    //배열 정렬은 속도의 폭이 컸다.
    public int solution2(int[] d, int budget) {

        int answer = 0;
        int i = 0;

        Arrays.sort(d);

        while (i < d.length && (budget -= d[i++]) >= 0) {
            answer++;
        }

        return answer;
    }

}
