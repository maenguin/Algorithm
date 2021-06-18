package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/11724
public class P11724_연결요소 {

    /*
    [문제설명]
    방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

    [시간제한]
    3 초

    [입력]
    첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2)
    둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v)
    같은 간선은 한 번만 주어진다.

    [출력]
    첫째 줄에 연결 요소의 개수를 출력한다.

    * 연결요소?
    나누어진 각각의 그래프
    연결 요소에 속한 모든 정점을 연결하는 경로가 있어야한다.
    즉 dfs나 bfs를 통한 탐색을 이용하면 연결요소의 개수를 구할 수 있다.

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer>[] adjList = new ArrayList[n + 1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            adjList[from].add(to);
            adjList[to].add(from);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int ans = 0;


        for (int i = 1; i < n + 1; i++) {

            if (visited[i]) continue;
            ans++;
            queue.offer(i);
            visited[i] = true;
            while (!queue.isEmpty()){
                int x = queue.poll();
                for (int v : adjList[x]) {
                    if (!visited[v]) {
                        queue.offer(v);
                        visited[v] = true;
                    }
                }
            }
        }

        System.out.println(ans);
    }


}