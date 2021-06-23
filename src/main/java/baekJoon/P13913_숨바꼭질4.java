package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/13913
public class P13913_숨바꼭질4 {

    /*
    [문제설명]
    수빈이는 동생과 숨바꼭질을 하고 있다.
    수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
    수빈이는 걷거나 순간이동을 할 수 있다.
    만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
    순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

    수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

    [시간제한]
    2 초

    [입력]
    첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

    [출력]
    수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
    둘째 줄에 어떻게 이동해야 하는지 공백으로 구분해 출력한다.
     */

    //숨바꼭질1에서 역추적이 추가된 문제
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int MAX = 200000;
        int[] dist = new int[MAX];
        int[] prev = new int[MAX];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        dist[n] = 1;

        while (!queue.isEmpty()) {
            Integer x = queue.poll();

            if (x == k) {
                break;
            }

            if (x - 1 >= 0 && dist[x-1] == 0) {
                queue.offer(x - 1);
                dist[x-1] = dist[x] + 1;
                prev[x-1] = x;
            }
            if (x * 2 < MAX && dist[x*2] == 0) {
                queue.offer(x*2);
                dist[x*2] = dist[x] + 1;
                prev[x*2] = x;
            }
            if (x + 1 < MAX && dist[x + 1] == 0) {
                queue.offer(x + 1);
                dist[x + 1] = dist[x] + 1;
                prev[x + 1] = x;
            }
        }
        System.out.println(dist[k]-1);

//        StringBuilder sb = new StringBuilder();
//        sb.append(k);
//        int i = k;
//        while (i != n) {
//            int pre = prev[i];
//            sb.insert(0, pre + " ");
//            i = pre;
//        }
//        System.out.println(sb);

        print(n, k, prev);
    }

    //역추적 출력 방법1
    private static void print(int n, int k, int[] from) {
        if (n != k) {
            print(n, from[k],from);
        }
        System.out.print(k + " ");
    }
    //역추적 출력 방법2
    private static void print2(int n, int k, int[] from) {
        Stack<Integer> ans = new Stack<>();
        for (int i=k; i!=n; i=from[i]) {
            ans.push(i);
        }
        ans.push(n);
        while (!ans.isEmpty()) {
            System.out.print(ans.pop() + " ");
        }
    }

}