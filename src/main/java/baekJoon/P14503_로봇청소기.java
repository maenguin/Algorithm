
package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/14503
public class P14503_로봇청소기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int answer = 0;
        int curDir = d;
        int x = r;
        int y = c;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        while (true) {
            if (map[x][y] == 0) {
                answer++;
                map[x][y] = -1; //청소 안됨 -> 청소됨
            }

            //네 방향 모두 청소가 이미 되어있거나 벽인 경우
            if (map[x + 1][y] != 0 && map[x - 1][y] != 0 && map[x][y + 1] != 0 && map[x][y - 1] != 0) {

                //뒤가 벽인 경우 종료
                if (map[x - dx[curDir]][y - dy[curDir]] == 1) {
                    break;
                } else {
                    //방향을 유지한채 후진
                    x -= dx[curDir];
                    y -= dy[curDir];
                }
            } else {
                int leftD = (curDir + 3)%4;
                int nx = x + dx[leftD];
                int ny = y + dy[leftD];
                //왼쪽 방향에 아직 청소하지 않은 공간이 존재
                if (map[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                    curDir = leftD;
                } else {
                    curDir = leftD;
                }
            }

        }
        System.out.println(answer);

    }

}
