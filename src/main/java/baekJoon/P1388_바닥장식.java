
package baekJoon;

import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/1388
//노션 링크 :
//알고 리즘 :
public class P1388_바닥장식 {

    private static String[] floor = new String[50];
    private static boolean[][] visited = new boolean[50][50];
    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            floor[i] = sc.next();
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) continue;
                answer++;
                dfs(i, j);
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;
        char curPattern = floor[r].charAt(c);
        if (curPattern == '-' && c + 1 < m && floor[r].charAt(c + 1) == curPattern) {
            dfs(r, c + 1);
        }
        if (curPattern == '|' && r + 1 < n && floor[r + 1].charAt(c) == curPattern) {
            dfs(r + 1, c);
        }
    }

}
