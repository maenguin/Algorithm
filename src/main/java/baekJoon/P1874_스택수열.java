
package baekJoon;

import java.util.Scanner;
import java.util.Stack;

//문제 출처 : https://www.acmicpc.net/problem/1874
//노션 링크 :
//알고 리즘 : 스택
public class P1874_스택수열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        StringBuilder answer = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        for (int i = 0; i < n; i++) {
            int wantNum = a[i];
            while (num <= wantNum) {
                stack.push(num++);
                answer.append('+').append('\n');
            }
            if (!stack.isEmpty() && stack.pop() == wantNum) {
                answer.append('-').append('\n');
            } else {
                answer.setLength(0);
                answer.append("NO");
                break;
            }
        }
        System.out.println(answer);
    }

}
