package algospot;

import java.util.Scanner;

//문제 출처 : https://algospot.com/judge/problem/read/JUMPGAME
//노션 링크 : https://delirious-sock-4dc.notion.site/50a667e0e23c401db4382e282a45f4b3
//알고 리즘 : DP
public class JUMPGAME_외발뛰기 {

    private static int[][] grid = new int[100][100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        while (C-- > 0) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            boolean result = solutionDP(n, new boolean[n][n], 0, 0);
            System.out.println(result ? "YES" : "NO");
        }
    }

    //solution DFS
    private static final int[][] DRC = {{0, 1}, {1, 0}};
    private static boolean solutionDFS(int n, boolean[][] visited, int r, int c) {
        if (r == n - 1 && c == n - 1) return true;
        visited[r][c] = true;
        for (int[] drc : DRC) {
            int nr = r + grid[r][c] * drc[0];
            int nc = c + grid[r][c] * drc[1];
            if (0 <= nr && nr < n && 0 <= nc && nc < n && !visited[nr][nc]) {
                if (solutionDFS(n, visited, nr, nc)) return true;
            }
        }
        return false;
    }

    //solution DP
    private static boolean solutionDP(int n, boolean[][] visited, int r, int c) {
        if (r >= n || c >= n || visited[r][c]) return false;
        if (r == n - 1 && c == n - 1) return true;
        visited[r][c] = true;
        int jump = grid[r][c];
        return solutionDP(n, visited, r + jump, c) || solutionDP(n, visited, r, c + jump);
    }

}

