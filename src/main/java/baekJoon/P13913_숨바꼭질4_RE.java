package baekJoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

//문제 출처 : https://www.acmicpc.net/problem/13913
//문제 유형 : 그래프 탐색
//알고리즘 : BFS, 그래프 이론,
public class P13913_숨바꼭질4_RE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int max = 150000;
        int[] distance = new int[max];
        int[] prevPos = new int[max];
        Queue<Integer> queue = new LinkedList<>();
        distance[n] = 1;
        queue.offer(n);
        while (!queue.isEmpty()) {
            Integer x = queue.poll();
            if (x == k) break;
            if (x - 1 >= 0 && distance[x - 1] == 0) {
                queue.offer(x - 1);
                distance[x - 1] += distance[x] + 1;
                prevPos[x - 1] = x;
            }
            if (x + 1 < max && distance[x + 1] == 0) {
                queue.offer(x + 1);
                distance[x + 1] += distance[x] + 1;
                prevPos[x + 1] = x;
            }
            if (x * 2 < max && distance[x * 2] == 0) {
                queue.offer(x * 2);
                distance[x * 2] += distance[x] + 1;
                prevPos[x * 2] = x;
            }
        }
        System.out.println(distance[k] - 1);
        printPath2(prevPos, n, k);
    }

    private static void printPath(int[] prevPos, int n, int k) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(k));
        int pos = k;
        while (pos != n) {
            pos = prevPos[pos];
            stringBuilder.insert(0, pos + " ");
        }
        System.out.println(stringBuilder);
    }

    private static void printPath2(int[] prevPos, int n, int k) {
        if (n != k) {
            printPath2(prevPos, n, prevPos[k]);
        }
        System.out.print(k + " ");
    }

}
