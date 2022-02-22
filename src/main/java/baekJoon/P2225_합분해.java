package baekJoon;

import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/2225
//노션 링크 : https://delirious-sock-4dc.notion.site/2225-56310ec0b348478f9805902cf21bef34
//문제 유형 : DP, 수학
public class P2225_합분해 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int MOD = (int) 1e9;
        int[][] dp = new int[K + 1][N + 1];
        dp[0][0] = 1;
        for (int k = 1; k <= K; k++) {
            for (int n = 0; n <= N; n++) {
                for (int i = 0; i <= n; i++) {
                    dp[k][n] += dp[k-1][i];
                    dp[k][n] %= MOD;
                }
            }
        }
        System.out.println(dp[K][N]);
    }

}
