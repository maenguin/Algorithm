package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/7576
public class P7576_토마토 {


    //BFS로 최단거리를 구하는 형태로 접근
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        boolean[][] visited = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }


        while (!queue.isEmpty()) {
            Point pt = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = pt.x + dx[k];
                int ny = pt.y + dy[k];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (map[nx][ny] == 0 ){
                        queue.offer(new Point(nx, ny));
                        map[nx][ny] = map[pt.x][pt.y] + 1;
                    }

                }
            }
        }

        boolean allDone = true;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    allDone = false;
                    break;
                }
                ans = Math.max(ans, map[i][j]);
            }
        }
        for (int[] ints : map) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println(allDone ? ans -1 : -1);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}