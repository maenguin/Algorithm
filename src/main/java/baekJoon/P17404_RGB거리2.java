package baekJoon;

import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/17404
//노션 링크 : https://delirious-sock-4dc.notion.site/RGB-2-55498943a89d45a1b5de9980e20ab5b7
//문제 유형 : DP
public class P17404_RGB거리2 {

    private static int N;
    private static int[][] RGBS;
    private static int ANSWER = (int) 1e9;
    private static int[][] DP;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        RGBS = new int[N][3];
        for (int i = 0; i < N; i++) {
            RGBS[i][0] = sc.nextInt();
            RGBS[i][1] = sc.nextInt();
            RGBS[i][2] = sc.nextInt();
        }
        DP = new int[N][3];

        for (int i = 0; i < 3; i++) {
            DP[0][i] = RGBS[0][i];
            DP[0][(i + 1)%3] = (int) 1e9;
            DP[0][(i + 2)%3] = (int) 1e9;
            for (int j = 1; j < N; j++) {
                DP[j][0] = RGBS[j][0] + Math.min(DP[j - 1][1], DP[j - 1][2]);
                DP[j][1] = RGBS[j][1] + Math.min(DP[j - 1][0], DP[j - 1][2]);
                DP[j][2] = RGBS[j][2] + Math.min(DP[j - 1][0], DP[j - 1][1]);
            }
            for (int j = 0; j < 3; j++) {
                if (i == j) continue;
                ANSWER = Math.min(ANSWER, DP[N - 1][j]);
            }
        }
        System.out.println(ANSWER);
    }

}
