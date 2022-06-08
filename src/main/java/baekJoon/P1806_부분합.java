
package baekJoon;

import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/1806
//노션 링크 : https://delirious-sock-4dc.notion.site/1806-1b662126adc240df806e3f8a3196fd0c
//알고 리즘 : 투 포인터
public class P1806_부분합 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int answer = (int) 2e9;
        int sum = 0;
        for (int i = 0, j = 0; true; ) {
            if (sum >= s) sum -= a[i++];
            else if (j == n) break;
            else sum += a[j++];
            if (sum >= s) answer = Math.min(answer, j - i);
        }
        System.out.println(answer == (int) 2e9 ? 0 : answer);
    }

}
