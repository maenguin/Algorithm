package baekJoon;

import java.util.ArrayList;
import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/1068
//노션 링크 :
//알고 리즘 : 트리
public class P1068_트리 {

    private static int[] leafCount;
    private static ArrayList<Integer>[] adjList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        leafCount = new int[n];
        adjList = new ArrayList[n];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        int root = 0;
        int[] nodes = new int[n];
        for (int i = 0; i < n; i++) {
            int from = nodes[i] = sc.nextInt();
            if (from == -1) {
                root = i;
                continue;
            }
            adjList[from].add(i);
        }
        int removeNode = sc.nextInt();
        if (removeNode == root) {
            System.out.println(0);
            return;
        }
        int totalLeafNodes = countLeafNodes(root);
        int removeNodeParent = nodes[removeNode];
        if (leafCount[removeNodeParent] == 1) {
            System.out.println(totalLeafNodes - leafCount[removeNode] + 1);
        } else {
            System.out.println(totalLeafNodes - leafCount[removeNode]);
        }
    }

    private static int countLeafNodes(int current) {
        if (adjList[current].size() == 0) {
            leafCount[current] = 1;
        }
        for (int node : adjList[current]) {
            leafCount[current] += countLeafNodes(node);
        }
        return leafCount[current];
    }

}
