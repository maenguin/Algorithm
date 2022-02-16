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
    private static int lastRGB;

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
        int[] i0 = dpWithDFS(N - 1, 0);
        if (i0[1] == 0) {
            ANSWER = Math.min(ANSWER, i0[0] + RGBS[0][1]);
            ANSWER = Math.min(ANSWER, i0[0] + RGBS[0][2]);
        } else if (i0[1] == 1) {
            ANSWER = Math.min(ANSWER, i0[0] + RGBS[0][2]);
        } else if (i0[1] == 2) {
            ANSWER = Math.min(ANSWER, i0[0] + RGBS[0][1]);
        }

        int[] i1 = dpWithDFS(N - 1, 1);
        if (i1[1] == 1) {
            ANSWER = Math.min(ANSWER, i1[0] + RGBS[0][0]);
            ANSWER = Math.min(ANSWER, i1[0] + RGBS[0][2]);
        } else if (i1[1] == 0) {
            ANSWER = Math.min(ANSWER, i1[0] + RGBS[0][2]);
        } else if (i1[1] == 2) {
            ANSWER = Math.min(ANSWER, i1[0] + RGBS[0][0]);
        }
        int[] i2 = dpWithDFS(N - 1, 2);
        if (i2[1] == 2) {
            ANSWER = Math.min(ANSWER, i2[0] + RGBS[0][0]);
            ANSWER = Math.min(ANSWER, i2[0] + RGBS[0][1]);
        } else if (i2[1] == 0) {
            ANSWER = Math.min(ANSWER, i2[0] + RGBS[0][1]);
        } else if (i2[1] == 1) {
            ANSWER = Math.min(ANSWER, i2[0] + RGBS[0][0]);
        }
        System.out.println(ANSWER);
    }

    private static int[] dpWithDFS(int n, int rgb) {
        if (n == 1) {
            return new int[]{RGBS[n][rgb], rgb};
        }
        if (DP[n][rgb] != 0) return new int[]{DP[n][rgb], rgb} ;
        int[] a = dpWithDFS(n - 1, (rgb + 1) % 3);
        int[] b = dpWithDFS(n - 1, (rgb + 2) % 3);
        DP[n][rgb] = RGBS[n][rgb] + Math.min(a[0], b[0]);
        return new int[]{DP[n][rgb] , a[0] < b[0] ? a[1] : b[1]};
    }


}
