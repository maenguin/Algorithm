package baekJoon;

import java.util.*;

//문제 출처 : https://www.acmicpc.net/problem/15681
//문제 유형 : Tree DP
//알고리즘 : 서브트리
public class P15681_트리와쿼리 {

    //간선에 가중치와 방향성이 없는 임의의 루트 있는 트리가 주어졌을 때
    //정점 U를 루트로 하는 서브트리에 속한 정점의 수를 출력한다.

    private static ArrayList<Integer>[] adjList;
    private static int[] size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //정점의 수
        int R = sc.nextInt(); //루트의 번호
        int Q = sc.nextInt(); //쿼리의 수
        adjList = new ArrayList[N + 1];
        size = new int[N + 1];

        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            adjList[from].add(to);
            adjList[to].add(from);
        }

        countSubTreeNodes(R, -1);

        while (Q-- > 0) {
            int q = sc.nextInt();
            System.out.println(size[q]);
        }
    }

    private static int countSubTreeNodes(int current, int parent) {
        size[current] = 1;
        for (int node : adjList[current]) {
            if (node != parent) {
                size[current] += countSubTreeNodes(node, current);
            }
        }
        return size[current];
    }

}
