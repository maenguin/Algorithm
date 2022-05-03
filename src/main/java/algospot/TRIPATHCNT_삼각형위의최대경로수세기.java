package algospot;

import java.util.Scanner;

//문제 출처 : https://algospot.com/judge/problem/read/TRIPATHCNT
//노션 링크 : https://delirious-sock-4dc.notion.site/TRIPATHCNT-dd29c8ebefb14995a272d9cfd12b470a
//알고 리즘 : DP
public class TRIPATHCNT_삼각형위의최대경로수세기 {

    private static int[][] triangle;
    private static int n;
    private static int[][] cache;
    private static int[][] countCache;

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
            countCache = new int[n][n];
            System.out.println(triPathCnt(0, 0));
        }
    }

    private static int triPathCnt(int r, int c) {
        if (r == n - 1) return 1;
        if (countCache[r][c] != 0) return countCache[r][c];
        int path1 = trianglePath(r + 1, c);
        int path2 = trianglePath(r + 1, c + 1);
        int cnt = 0;
        if (path1 > path2) cnt += triPathCnt(r + 1, c);
        else if (path1 < path2) cnt += triPathCnt(r + 1, c + 1);
        else cnt += triPathCnt(r + 1, c) + triPathCnt(r + 1, c + 1);
        return countCache[r][c] = cnt;
    }

    private static int trianglePath(int r, int c) {
        if (r == n - 1) return triangle[r][c];
        if (cache[r][c] != 0) return cache[r][c];
        return cache[r][c] = Math.max(trianglePath(r + 1, c), trianglePath(r + 1, c + 1)) + triangle[r][c];
    }

}
