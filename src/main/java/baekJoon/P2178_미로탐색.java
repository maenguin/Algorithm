

package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/2178
public class P2178_미로탐색 {

    /*
    [문제설명]
    N×M크기의 배열로 표현되는 미로가 있다.

    1	0	1	1	1	1
    1	0	1	0	1	0
    1	0	1	0	1	1
    1	1	1	0	1	1
    미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
    이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
    한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

    위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

    [시간제한]
    1 초

    [입력]
    첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

    [출력]
    첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
     */


    //가중치가 1 인 최단경로 -> BFS
    //distance 배열을 이용해 0,0부터 i,j까지의 거리를 기록

    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] chars = sc.next().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = chars[j] - '0';
            }
        }

        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];
        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(0, 0));
        visited[0][0] = true;
        distance[0][0] = 1;

        while (!queue.isEmpty()) {
            Point pt = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = pt.x + dx[k];
                int ny = pt.y + dy[k];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]){
                        queue.offer(new Point(nx, ny));
                        visited[nx][ny] = true;
                        distance[nx][ny] = distance[pt.x][pt.y] + 1;
                    }

                }
            }
        }
        System.out.println(distance[n-1][m-1]);
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