package baekJoon;

import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/1149
//노션 링크 : https://delirious-sock-4dc.notion.site/RGB-1-15d906fcb172459291ecd7cd0785b1e4
//문제 유형 : DP
//풀이 방법 : DFS
public class P1149_RGB거리 {

    private static int N;
    private static int[][] RGBS;
    private static int ANSWER = (int) 1e9;
    private static int[][] DP;

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        RGBS = new int[N][3];
        for (int i = 0; i < N; i++) {
            RGBS[i][0] = sc.nextInt();
            RGBS[i][1] = sc.nextInt();
            RGBS[i][2] = sc.nextInt();
        }
        DP = new int[N][3];
        int i0 = dpWithDFS(N - 1, 0);
        int i1 = dpWithDFS(N - 1, 1);
        int i2 = dpWithDFS(N - 1, 2);
        ANSWER = Math.min(i0, i1);
        ANSWER = Math.min(ANSWER, i2);
        System.out.println(ANSWER);
    }

    private static int dpWithDFS(int n, int rgb) {
        if (n == 0) {
            return RGBS[n][rgb];
        }
        if (DP[n][rgb] != 0) return DP[n][rgb];
        int a = dpWithDFS(n - 1, (rgb + 1) % 3);
        int b = dpWithDFS(n - 1, (rgb + 2) % 3);
        return DP[n][rgb] = RGBS[n][rgb] + Math.min(a, b);
    }

    ////////////////////////////////////////////////////////

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
        DP[0][0] = RGBS[0][0];
        DP[0][1] = RGBS[0][1];
        DP[0][2] = RGBS[0][2];
        for (int i = 1; i < N; i++) {
            DP[i][0] = RGBS[i][0] + Math.min(DP[i - 1][1], DP[i - 1][2]);
            DP[i][1] = RGBS[i][1] + Math.min(DP[i - 1][0], DP[i - 1][2]);
            DP[i][2] = RGBS[i][2] + Math.min(DP[i - 1][0], DP[i - 1][1]);
        }
        ANSWER = Math.min(DP[N-1][0], DP[N-1][1]);
        ANSWER = Math.min(ANSWER, DP[N-1][2]);
        System.out.println(ANSWER);
    }


}
