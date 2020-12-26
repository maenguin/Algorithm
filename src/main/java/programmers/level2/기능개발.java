package programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//수학 계산이 들어갈 수 록 코드가 짧아지는 마법
public class 기능개발 {

    public int[] solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Job> jobQueue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            jobQueue.add(new Job(progresses[i], speeds[i]));
        }

        int doneCnt = 0;
        while (!jobQueue.isEmpty()) {

            for (Job job : jobQueue)
                job.DoJob();

            while (!jobQueue.isEmpty() && jobQueue.peek().isDone()){
                jobQueue.poll();
                doneCnt++;
            }

            if (doneCnt > 0){
                answer.add(doneCnt);
                doneCnt = 0;
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    //doJob을 지우고 day추가 성능을 개선한 버전
    public int[] solution2(int[] progresses, int[] speeds) {

        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Job> jobQueue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            jobQueue.add(new Job(progresses[i], speeds[i]));
        }

        int doneCnt = 0;
        int day = 0;
        while (!jobQueue.isEmpty()) {
            day++;
            while (!jobQueue.isEmpty() && jobQueue.peek().isDoneWhen(day)){
                jobQueue.poll();
                doneCnt++;
            }

            if (doneCnt > 0){
                answer.add(doneCnt);
                doneCnt = 0;
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    //day를 없애고 getRemainDay추가 성능개선 버전
    public int[] solution3(int[] progresses, int[] speeds) {

        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Job> jobQueue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            jobQueue.add(new Job(progresses[i], speeds[i]));
        }

        int doneCnt = 0;
        int remainDay = jobQueue.peek().getRemainDay();
        for (Job job : jobQueue) {

            if (remainDay < job.getRemainDay()){
                answer.add(doneCnt);
                doneCnt = 0;
                remainDay = job.getRemainDay();
            }

            doneCnt++;
        }
        answer.add(doneCnt);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    static class Job {

        int progress;
        int speed;

        public Job(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }

        public void DoJob() {
            if (progress < 100)
                progress += speed;
        }

        public boolean isDone() {
            return progress >= 100;
        }

        public boolean isDoneWhen(int day) {
            return progress + day*speed >= 100;
        }

        public int getRemainDay() {
            return (int) Math.ceil((100 - progress)/(double)speed);
        }
    }
}

