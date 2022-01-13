package programmers.level3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

//문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42627
//문제 유형 : 자료구조
//알고리즘 : 힙
public class Q42627_디스크컨트롤러 {

    public int solution(int[][] jobs) {
        LinkedList<Job> readyQueue = new LinkedList<>();
        PriorityQueue<Job> runnableQueue = new PriorityQueue<>();
        for (int[] ints : jobs) {
            readyQueue.offer(new Job(ints[0], ints[1]));
        }
        readyQueue.sort(Comparator.comparingInt((Job o) -> o.requestTime));
        int end = 0;
        int sum = 0;
        while (!readyQueue.isEmpty() || !runnableQueue.isEmpty()) {
            while (!readyQueue.isEmpty() && readyQueue.peek().requestTime <= end) {
                runnableQueue.offer(readyQueue.poll());
            }
            if (runnableQueue.isEmpty()) {
                end = readyQueue.peek().requestTime;
                continue;
            }
            Job job = runnableQueue.poll();
            end += job.operationTime;
            sum += end - job.requestTime;
        }
        return sum / jobs.length;
    }

    static class Job implements Comparable<Job> {

        private final int requestTime;
        private final int operationTime;

        public Job(int requestTime, int operationTime) {
            this.requestTime = requestTime;
            this.operationTime = operationTime;
        }

        @Override
        public int compareTo(Job o) {
            return Integer.compare(this.operationTime, o.operationTime);
        }
    }

    public int solution2(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt((int[] o) -> o[0]));
        PriorityQueue<int[]> runnableQueue = new PriorityQueue<>(Comparator.comparingInt((int[] o) -> o[1]));
        int end = 0;
        int sum = 0;
        int index = 0;
        while (index < jobs.length || !runnableQueue.isEmpty()) {
            while (index < jobs.length && jobs[index][0] <= end) {
                runnableQueue.offer(jobs[index]);
                index++;
            }
            if (runnableQueue.isEmpty()) {
                end = jobs[index][0];
                continue;
            }
            int[] job = runnableQueue.poll();
            end += job[1];
            sum += end - job[0];
        }
        return sum / jobs.length;
    }
}




