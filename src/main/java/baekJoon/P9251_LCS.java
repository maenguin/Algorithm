
package baekJoon;


import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/9251
//노션 링크 : https://delirious-sock-4dc.notion.site/9251-LCS-3eaba139877d4ab690556cd39a8384b6
//알고 리즘 : DP
public class P9251_LCS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        longestCommonSubsequence2(a, b);
    }

    private static void longestCommonSubstring(String a, String b) {
        int result = 0;
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        System.out.println(result);
    }

    private static void longestCommonSubsequence(String a, String b) {
        int result = 0;
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        System.out.println(result);
    }

    private static void longestCommonSubsequence2(String a, String b) {
        int result = 0;
        int[] dp = new int[b.length()];
        for (int i = 0; i < a.length(); i++) {
            int max = 0;
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    int temp = max + 1;
                    max = Math.max(max, dp[j]);
                    dp[j] = temp;
                    result = Math.max(result, dp[j]);
                } else {
                    max = Math.max(max, dp[j]);
                }
            }
        }
        System.out.println(result);
    }

}
