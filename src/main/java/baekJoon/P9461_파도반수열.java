package baekJoon;

import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/9461
//문제 유형 : DP, 수학
public class P9461_파도반수열 {

    //d[n] = d[n-1] + d[n-5] or d[n-2] + d[n-3]
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long[] dp = new long[101];
        dp[1] = dp[2] = dp[3] = 1;
        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            sb.append(dp[sc.nextInt()]).append("\n");
        }
        System.out.println(sb);
    }

}
