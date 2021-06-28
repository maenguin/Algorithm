

package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/1261
public class P1261_알고스팟 {

    /*
    [문제설명]
    알고스팟 운영진이 모두 미로에 갇혔다.
    미로는 N*M 크기이며, 총 1*1크기의 방으로 이루어져 있다.
    미로는 빈 방 또는 벽으로 이루어져 있고, 빈 방은 자유롭게 다닐 수 있지만, 벽은 부수지 않으면 이동할 수 없다.

    알고스팟 운영진은 여러명이지만, 항상 모두 같은 방에 있어야 한다.
    즉, 여러 명이 다른 방에 있을 수는 없다.
    어떤 방에서 이동할 수 있는 방은 상하좌우로 인접한 빈 방이다.
    즉, 현재 운영진이 (x, y)에 있을 때, 이동할 수 있는 방은 (x+1, y), (x, y+1), (x-1, y), (x, y-1) 이다.
    단, 미로의 밖으로 이동 할 수는 없다.

    벽은 평소에는 이동할 수 없지만, 알고스팟의 무기 AOJ를 이용해 벽을 부수어 버릴 수 있다.
    벽을 부수면, 빈 방과 동일한 방으로 변한다.

    만약 이 문제가 알고스팟에 있다면, 운영진들은 궁극의 무기 sudo를 이용해 벽을 한 번에 다 없애버릴 수 있지만,
    안타깝게도 이 문제는 Baekjoon Online Judge에 수록되어 있기 때문에, sudo를 사용할 수 없다.

    현재 (1, 1)에 있는 알고스팟 운영진이 (N, M)으로 이동하려면 벽을 최소 몇 개 부수어야 하는지 구하는 프로그램을 작성하시오.

    위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다.
    칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

    [시간제한]
    1 초 (추가 시간 없음)

    [입력]
    첫째 줄에 미로의 크기를 나타내는 가로 크기 M, 세로 크기 N (1 ≤ N, M ≤ 100)이 주어진다.
    다음 N개의 줄에는 미로의 상태를 나타내는 숫자 0과 1이 주어진다. 0은 빈 방을 의미하고, 1은 벽을 의미한다.
    (1, 1)과 (N, M)은 항상 뚫려있다.

    [출력]
    첫째 줄에 알고스팟 운영진이 (N, M)으로 이동하기 위해 벽을 최소 몇 개 부수어야 하는지 출력한다.
     */


    //BFS에서 가중치의 의미를 되새겨 보자
    //단순히 0->0으로 이동한다고 해서 가중치가 1인것은 아니다
    //이 문제는 부수는 벽의 최소 개수를 구해야 하는 문제이다. 그러므로 가중치는 벽이 있는 방으로 가는것을 의미한다.
    //즉 빈방으로 가는건 가중치가 0이고 벽이 있는 방으로 가는건 가중치가 1이다.

    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] chars = sc.next().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = chars[j] - '0';
            }
        }

        int[][] dist = new int[n][m];
        for (int[] ints : dist) {
            Arrays.fill(ints,-1);
        }
        LinkedList<Point> deque = new LinkedList<>();

        deque.offer(new Point(0, 0));
        dist[0][0] = 0;

        while (!deque.isEmpty()) {
            Point pt = deque.poll();
            for (int k = 0; k < 4; k++) {
                int nx = pt.x + dx[k];
                int ny = pt.y + dy[k];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (map[nx][ny] == 0 && dist[nx][ny] == -1) {
                        deque.addFirst(new Point(nx, ny));
                        dist[nx][ny] = dist[pt.x][pt.y];
                    }
                    if (map[nx][ny] == 1 && dist[nx][ny] == -1) {
                        deque.addLast(new Point(nx, ny));
                        dist[nx][ny] = dist[pt.x][pt.y] + 1;
                    }
                }
            }
        }

        for (int[] ints : dist) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println(dist[n-1][m-1]);
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