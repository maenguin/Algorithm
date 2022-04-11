
package baekJoon;


import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/2565
//노션 링크 : https://delirious-sock-4dc.notion.site/2565-89d506822efe431d967ed0d3e5e79a79
//알고 리즘 : DP
//풀이 방법 : LIS
public class P2565_전깃줄 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[501];
        for (int i = 0; i < n; i++) {
            a[sc.nextInt()] = sc.nextInt();
        }
        int lis = LIS(a);
        System.out.println(n - lis);
    }

    private static int LIS(int[] a) {
        int result = 0;
        int[] dp = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) continue;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i]++;
            result = Math.max(result, dp[i]);
        }
        return result;
    }

}
