
package baekJoon;

import java.util.ArrayList;
import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/1949
//노션 링크 : https://delirious-sock-4dc.notion.site/1949-d60d97097d054f568162e12d609a8fa4
//알고 리즘 : 트리 DP
public class P1949_우수마을 {

    private static ArrayList<Integer>[] adjList;
    private static int[] weights;
    private static int[][] cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        adjList = new ArrayList[n + 1];
        for (int i = 1; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        weights = new int[n + 1];
        for (int i = 1; i < weights.length; i++) {
            weights[i] = sc.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            adjList[from].add(to);
            adjList[to].add(from);
        }
        cache = new int[n + 1][2];
        System.out.println(memorize(1, 0, 0));
    }

    private static int memorize(int current, int parent, int skip) {
        if (cache[current][skip] != 0) return cache[current][skip];
        int sum = 0;
        if (skip == 1) {
            for (Integer vertex : adjList[current]) {
                if (vertex == parent) continue;
                sum += memorize(vertex, current, 0);
            }
        } else {
            int case1 = weights[current];
            int case2 = 0;
            for (Integer vertex : adjList[current]) {
                if (vertex == parent) continue;
                case1 += memorize(vertex, current, 1);
                case2 += memorize(vertex, current, 0);
            }
            sum = Math.max(case1, case2);
        }
        sum = sum == 0 && skip == 0 ? weights[current] : sum;
        return cache[current][skip] = sum;
    }

}
