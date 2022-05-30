
package baekJoon;

import java.util.Arrays;
import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/1520
//노션 링크 : https://delirious-sock-4dc.notion.site/1520-64bb7a0e440d4c9c96d18ff0b860411e
//알고 리즘 : 그래프 탐색, DP
public class P1520_내리막길 {

    private static int m;
    private static int n;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] cache;
    private static int[] dr = {0, -1, 0, 1};
    private static int[] dc = {-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        map = new int[m][n];
        visited = new boolean[m][n];
        cache = new int[m][n];
        for (int[] ints : cache) {
            Arrays.fill(ints, -1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        System.out.println(climbDown(m - 1, n - 1));
    }

    private static int climbDown(int r, int c) {
        if (r == 0 && c == 0) {
            return 1;
        }
        if (cache[r][c] != -1) return cache[r][c];
        int path = 0;
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (!(0 <= nr && nr < m && 0 <= nc && nc < n)) continue;
            if (!visited[nr][nc] && map[nr][nc] > map[r][c]) {
                visited[r][c] = true;
                path += climbDown(nr, nc);
                visited[r][c] = false;
            }
        }
        return cache[r][c] = path;
    }

}
