
package baekJoon;

import java.util.Arrays;
import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/3273
//노션 링크 : https://delirious-sock-4dc.notion.site/dd6b8715902a40e7a5ca220be6354320
//알고 리즘 : 투포인터
public class P3273_두수의합 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        solution(n, a, x);
    }

    private static void solution(int n, int[] a, int x) {
        Arrays.sort(a);
        int answer = 0;
        for (int i = 0, j = n - 1; i < j; ) {
            int sum = a[i] + a[j];
            if (sum < x) {
                i++;
            } else if (sum > x) {
                j--;
            } else {
                answer++;
                i++;
            }
        }
        System.out.println(answer);
    }

}
