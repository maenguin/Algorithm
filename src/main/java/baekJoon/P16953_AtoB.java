
package baekJoon;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/16953
//노션 링크 : https://delirious-sock-4dc.notion.site/16953-A-B-769832b7f59f4612a5e5de86651bf3c5
//알고 리즘 : 그래프 이론, 그래프 탐색, BFS, 그리디
public class P16953_AtoB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        solution2Greedy(a, b);
    }

    static void solution1BFS(int a, int b) {
        Queue<long[]> queue = new LinkedList<>();
        queue.offer(new long[]{a, 0});
        while (!queue.isEmpty()) {
            long[] curNode = queue.poll();
            long num = curNode[0];
            long dis = curNode[1];
            if (num > b) continue;
            if (num == b) {
                System.out.println(dis + 1);
                return;
            }
            queue.offer(new long[]{ num * 2, dis + 1});
            queue.offer(new long[]{ num * 10 + 1, dis + 1});
        }
        System.out.println(-1);
    }

    static void solution2Greedy(int a, int b) {
        int count = 1;
        while (a < b) {
            if ((b - 1) % 10 == 0) {
                b /= 10;
                count++;
            } else if (b % 2 == 0) {
                b = b >> 1;
                count++;
            } else {
                break;
            }
        }
        System.out.println(a == b ? count : -1);
    }

}
