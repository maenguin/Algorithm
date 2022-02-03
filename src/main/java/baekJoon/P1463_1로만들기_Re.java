package baekJoon;

import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/1463
//노션 링크 : https://delirious-sock-4dc.notion.site/1-2032c002fada4524a13f7f591b503be5
//문제 유형 : DP
//풀이 방법 : DFS
public class P1463_1로만들기_Re {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //dp[i] : 정수 i를 1로 만드는 연산 횟수의 최솟값
        int[] dp = new int[n + 1];
        System.out.println(dfs(dp, n));
    }

    //dp[n] = min(dp[n/3], dp[n/2], dp[n-1]) + 1
    private static int dfs(int[] dp, int n) {
        if (n == 1) {
            return 0;
        }
        if (dp[n] != 0) return dp[n];
        int min = (int) 1e9;
        if (n % 3 == 0) {
            min = Math.min(min, dfs(dp, n / 3));
        }
        if (n % 2 == 0) {
            min = Math.min(min, dfs(dp, n / 2));
        }
        min = Math.min(min, dfs(dp, n - 1));
        return dp[n] = min + 1;
    }


}
