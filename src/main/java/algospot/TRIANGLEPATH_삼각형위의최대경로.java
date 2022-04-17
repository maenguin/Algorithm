package algospot;

import java.util.Scanner;

//문제 출처 : https://algospot.com/judge/problem/read/TRIANGLEPATH
//노션 링크 : https://delirious-sock-4dc.notion.site/50a667e0e23c401db4382e282a45f4b3
//알고 리즘 : DP
public class TRIANGLEPATH_삼각형위의최대경로 {

    private static int[][] triangle;
    private static int n;
    private static int[][] cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        while (c-- > 0) {
            n = sc.nextInt();
            triangle = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    triangle[i][j] = sc.nextInt();
                }
            }
            cache = new int[n][n];
//            System.out.println(topDown(0, 0));
            System.out.println(bottomUp());
        }
    }

    private static int topDown(int r, int c) {
        if (r == n - 1) return triangle[r][c];
        if (cache[r][c] != 0) return cache[r][c];
        return cache[r][c] = Math.max(topDown(r + 1, c), topDown(r + 1, c + 1)) + triangle[r][c];
    }

    private static int bottomUp() {
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] += Math.max(triangle[i + 1][j],triangle[i + 1][j + 1]);
            }
        }
        return triangle[0][0];
    }

}
