
package baekJoon;

import java.util.Arrays;
import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/17144
//노션 링크 :
//알고 리즘 : 시뮬레이션, 구현
public class P17144_미세먼지안녕 {

    private static int R;
    private static int C;
    private static int T;
    private static int[][] room;
    private static int[] dr = {0, -1, 0, 1};
    private static int[] dc = {-1, 0, 1, 0};
    private static int airCleanerR;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        T = sc.nextInt();
        room = new int[R][C];
        airCleanerR = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                room[i][j] = sc.nextInt();
                if (room[i][j] == -1 && airCleanerR == 0) {
                    airCleanerR = i;
                }
            }
        }

        while (T-- > 0) {
            spread();
            circulate();
        }
        System.out.println(Arrays.stream(room).flatMapToInt(Arrays::stream).sum() + 2);
    }

    private static void spread() {
        int[][] temp = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (room[i][j] <= 0) continue;
                int spreadAmount = 0;
                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if (!(0 <= nr && nr < R && 0 <= nc && nc < C) || room[nr][nc] == -1) continue;
                    temp[nr][nc] += room[i][j] / 5;
                    spreadAmount += room[i][j] / 5;
                }
                room[i][j] -= spreadAmount;
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                room[i][j] += temp[i][j];
            }
        }
    }

    private static void circulate() {
        //반시계방향 회전
        int x1 = 0;
        int y1 = 0;
        int x2 = airCleanerR;
        int y2 = C - 1;
        int temp = room[x1][y1];
        for (int i = y1; i < y2; i++) {
            room[x1][i] = room[x1][i + 1];
        }
        for (int i = x1; i < x2; i++) {
            room[i][y2] = room[i + 1][y2];
        }
        for (int i = y2; i > y1; i--) {
            room[x2][i] = room[x2][i - 1];
        }
        for (int i = x2 - 1; i > x1 + 1; i--) {
            room[i][y1] = room[i - 1][y1];
        }
        room[x1 + 1][0] = temp;
        room[airCleanerR][1] = 0;
        //시계방향 회전
        x1 = airCleanerR + 1;
        y1 = 0;
        x2 = R - 1;
        y2 = C - 1;
        for (int i = x1 + 1; i < x2; i++) {
            room[i][y1] = room[i + 1][y1];
        }
        for (int i = y1; i < y2; i++) {
            room[x2][i] = room[x2][i + 1];
        }
        for (int i = x2; i > x1; i--) {
            room[i][y2] = room[i - 1][y2];
        }
        for (int i = y2; i > y1; i--) {
            room[x1][i] = room[x1][i - 1];
        }
        room[airCleanerR + 1][1] = 0;
    }


}
