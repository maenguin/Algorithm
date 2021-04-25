package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/1260
public class P1260_DFS와BFS {

    /*
    [문제설명]
    그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
    단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
    정점 번호는 1번부터 N번까지이다.

    [시간제한]
    2 초

    [입력]
    첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
    다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
    어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

    [출력]
    첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
     */

    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vCnt = sc.nextInt();
        int eCnt = sc.nextInt();
        int start = sc.nextInt();

        adjList = new ArrayList[vCnt + 1];
        for (int i = 1; i <= vCnt; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < eCnt; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            adjList[from].add(to);
            adjList[to].add(from);
        }
        for (int i = 1; i <= vCnt; i++) {
            Collections.sort(adjList[i]);
        }
        visited = new boolean[vCnt + 1];
        dfs(start);
        visited = new boolean[vCnt + 1];
        System.out.println();
        bfs(start);
    }

    static void dfs(int x) {
        visited[x] = true;
        System.out.print(x+" ");
        for (int v : adjList[x]) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            System.out.print(x+" ");

            for (int v : adjList[x]) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
    }


}