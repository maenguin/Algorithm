package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/7562
public class P7562_나이트의이동 {

    /*
    [문제설명]
    체스판 위에 한 나이트가 놓여져 있다.
    나이트가 한 번에 이동할 수 있는 칸은 아래 그림에 나와있다.
    나이트가 이동하려고 하는 칸이 주어진다.
    나이트는 몇 번 움직이면 이 칸으로 이동할 수 있을까?

    [시간제한]
    1 초

    [입력]
    입력의 첫째 줄에는 테스트 케이스의 개수가 주어진다.

    각 테스트 케이스는 세 줄로 이루어져 있다.
    첫째 줄에는 체스판의 한 변의 길이 l(4 ≤ l ≤ 300)이 주어진다.
    체스판의 크기는 l × l이다.
    체스판의 각 칸은 두 수의 쌍 {0, ..., l-1} × {0, ..., l-1}로 나타낼 수 있다.
    둘째 줄과 셋째 줄에는 나이트가 현재 있는 칸, 나이트가 이동하려고 하는 칸이 주어진다.

    [출력]
    각 테스트 케이스마다 나이트가 최소 몇 번만에 이동할 수 있는지 출력한다.
     */



    //BFS 최단거리 알고리즘 사용 map을 거리로 사용
    static int[] dx = {-2,-1,1, 2, 2, 1,-1,-2};
    static int[] dy = { 1, 2,2, 1,-1,-2,-2,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int l = sc.nextInt();
            int sx = sc.nextInt();
            int sy = sc.nextInt();
            int ex = sc.nextInt();
            int ey = sc.nextInt();
            int[][] map = new int[l][l];


            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(sx, sy));
            map[sx][sy] = 1;

            while (!queue.isEmpty()) {
                Point pt = queue.poll();

                for (int k = 0; k < dx.length; k++) {
                    int nx = pt.x + dx[k];
                    int ny = pt.y + dy[k];

                    if (0 <= nx && nx < l && 0 <= ny && ny < l) {
                        if (map[nx][ny] == 0){
                            queue.offer(new Point(nx, ny));
                            map[nx][ny] = map[pt.x][pt.y] + 1;
                            if (pt.x == ex && pt.y == ey) {
                                break;
                            }
                        }

                    }
                }
            }

            System.out.println(map[ex][ey]-1);
        }
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