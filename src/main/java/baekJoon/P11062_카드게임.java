package baekJoon;

import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/11062
//노션 링크 : https://delirious-sock-4dc.notion.site/3ad25916e3784adebfd2b03de2cb49fd
//문제 유형 : 게임이론
public class P11062_카드게임 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] cards = new int[n];
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                cards[i] = scanner.nextInt();
            }
            sb.append(doA(cards, dp, 0, n - 1)).append("\n");
        }
        System.out.println(sb);
    }

    private static int doA(int[] cards, int[][] dp, int left, int right) {
        if (left > right) {
            return 0;
        }
        if (dp[left][right] != 0) return dp[left][right];
        int leftResult = cards[left] + doB(cards, dp, left + 1, right);
        int rightResult = cards[right] + doB(cards, dp, left, right - 1);
        return dp[left][right] = Math.max(leftResult, rightResult);
    }

    private static int doB(int[] cards, int[][] dp, int left, int right) {
        if (left > right) {
            return 0;
        }
        if (dp[left][right] != 0) return dp[left][right];
        int leftResult = doA(cards, dp, left + 1, right);
        int rightResult = doA(cards, dp, left, right - 1);
        return dp[left][right] = Math.min(leftResult, rightResult);
    }

}
