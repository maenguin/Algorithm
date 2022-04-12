
package baekJoon;


import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/1912
//노션 링크 : https://delirious-sock-4dc.notion.site/2565-89d506822efe431d967ed0d3e5e79a79
//알고 리즘 : DP
public class P1912_연속합 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = sc.nextInt();
        }
        maxContinuousSum(seq);
    }

    private static void maxContinuousSum(int[] seq) {
        int[] dp = new int[seq.length];
        int maxSum = dp[0] = seq[0];
        for (int i = 1; i < seq.length; i++) {
            dp[i] = Math.max(dp[i - 1] + seq[i], seq[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        System.out.println(maxSum);
    }

}
