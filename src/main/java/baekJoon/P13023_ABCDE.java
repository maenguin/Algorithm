
package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/13023
public class P13023_ABCDE {

    /*
    [문제설명]
    BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.
    오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.

    A는 B와 친구다.
    B는 C와 친구다.
    C는 D와 친구다.
    D는 E와 친구다.
    위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.

    [시간제한]
    2 초

    [입력]
    첫째 줄에 사람의 수 N (5 ≤ N ≤ 2000)과 친구 관계의 수 M (1 ≤ M ≤ 2000)이 주어진다.
    둘째 줄부터 M개의 줄에는 정수 a와 b가 주어지며, a와 b가 친구라는 뜻이다. (0 ≤ a, b ≤ N-1, a ≠ b) 같은 친구 관계가 두 번 이상 주어지는 경우는 없다.

    [출력]
    문제의 조건에 맞는 A, B, C, D, E가 존재하면 1을 없으면 0을 출력한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        //인접행렬 : 임의의 두 정점 사이의 간선 유무 확인에 용이 O(1)
        int[][] adjMatrix = new int[n][n];
        //인접리스트 : 한 정점과 연결된 모든 간선 확인에 용이 O(차수)
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        //간선리스트
        ArrayList<Edge> edgeList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            adjMatrix[from][to] = 1;
            adjMatrix[to][from] = 1;

            adjList[from].add(to);
            adjList[to].add(from);

            edgeList.add(new Edge(from,to));
            edgeList.add(new Edge(to,from));
        }

        m *= 2; //간선리스트가 2m개라서
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                int A = edgeList.get(i).from;
                int B = edgeList.get(i).to;
                int C = edgeList.get(j).from;
                int D = edgeList.get(j).to;

                //먼저 A-B C-D 가 있는지 확인한다.
                //그러기 위해선 A B C D가 각각 서로 다 다른 수 여야 한다.
                if (A == B || A == C || A == D || B == C || B == D || C == D) {
                    continue;
                }
                //그 다음 B-C가 있는지 확인
                if (adjMatrix[B][C] == 0){
                    continue;
                }
                //그 다음 D에 연결되어있는 정점중에 A B C D가 아닌게 있는지 확인
                for (int E : adjList[D]) {
                    if (A == E || B == E || C == E || D == E) {
                        continue;
                    }
                    System.out.println(1);
                    System.exit(0);
                }
            }
        }
        System.out.println(0);

    }



    static class Edge {
        private int from;
        private int to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}
