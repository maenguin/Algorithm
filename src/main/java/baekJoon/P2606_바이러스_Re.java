package baekJoon;

import java.util.ArrayList;
import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/2606
//노션 링크 : https://delirious-sock-4dc.notion.site/2606-08de6a6221d044158ae813f73b03d270
//문제 유형 : 그래프 탐색, 그래프 이론
public class P2606_바이러스_Re {

    private static int answer = 0;
    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int computerCount = sc.nextInt();
        int pairCount = sc.nextInt();
        adjList = new ArrayList[computerCount + 1];
        for (int i = 1; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < pairCount; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            adjList[from].add(to);
            adjList[to].add(from);
        }
        visited = new boolean[adjList.length];
        visited[1] = true;
        dfs(1);
        System.out.println(answer);
    }

    private static void dfs(int vertex) {
        for (int v : adjList[vertex]) {
            if (visited[v]) continue;
            visited[v] = true;
            answer++;
            dfs(v);
        }
    }

}
