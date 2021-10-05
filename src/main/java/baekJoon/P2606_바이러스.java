package baekJoon;

import java.util.*;

//문제 유형 : 그래프 탐색
//알고리즘 : BFS, 연결요소
public class P2606_바이러스 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int computerCount = scanner.nextInt();
        int pairSize = scanner.nextInt();

        ArrayList<Integer>[] adjList = new ArrayList[computerCount + 1];
        for (int i = 1; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < pairSize; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            adjList[from].add(to);
            adjList[to].add(from);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adjList.length];

        int answer = 0;
        queue.offer(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            Integer curVertex = queue.poll();
            for (Integer adjVertex : adjList[curVertex]) {
                if (!visited[adjVertex]) {
                    answer++;
                    queue.offer(adjVertex);
                    visited[adjVertex] = true;
                }
            }
        }
        System.out.println(answer);
    }
}
