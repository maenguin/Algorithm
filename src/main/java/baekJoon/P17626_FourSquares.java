package baekJoon;

import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/17626
//노션 링크 : https://delirious-sock-4dc.notion.site/17626-FourSquares-df3c97281c6a43c9a6a00e89e27de4d8
//문제 유형 : DP
public class P17626_FourSquares {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        int pow = 1;
        for (int i = 1; i <= n; i++) {
            if (i == pow * pow) {
                dp[i] = 1;
                pow++;
                continue;
            }
            int min = (int) 1e9;
            for (int j = 1; j * j <= i ; j++) {
                min = Math.min(min, dp[j * j] + dp[i - j * j]);
            }
            dp[i] = min;
        }
        System.out.println(dp[n]);
    }

}
