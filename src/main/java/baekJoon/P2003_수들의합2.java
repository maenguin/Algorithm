
package baekJoon;

import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/2003
//노션 링크 :
//알고 리즘 : 구간합
public class P2003_수들의합2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            a[i] = sc.nextInt();
        }
        prefixSum(a, m);
    }

    private static void prefixSum(int[] a, int m) {
        for (int i = 1; i < a.length; i++) {
            a[i] = a[i] + a[i - 1];
        }
        int answer = 0;
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[j] - a[i - 1] == m) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

}
