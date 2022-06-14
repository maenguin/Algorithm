
package baekJoon;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/17298
//노션 링크 : https://delirious-sock-4dc.notion.site/17298-b6e9c93163a14770ab5076ae387f00c1
//알고 리즘 : 스택
public class P17298_오큰수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && a[i] > a[stack.peek()]) {
                answer[stack.pop()] = a[i];
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : answer) sb.append(i).append(" ");
        System.out.println(sb);
    }

}
