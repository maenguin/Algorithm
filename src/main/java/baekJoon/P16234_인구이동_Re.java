package baekJoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/16234
//문제 유형 : 그래프 탐색
//알고리즘 : 시뮬레이션, 구현, 그래프 이론
public class P16234_인구이동_Re {


    private static int n;
    private static int l;
    private static int r;
    private static int[][] map;
    private static int[][] unions;
    private static int union;
    private static int[] popSum;
    private static int countryCount;
    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        l = scanner.nextInt();
        r = scanner.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        int answer = 0;
        while (true) {
            unions = new int[n][n];
            popSum = new int[2501]; //union이 1부터 시작하고 최대 50x50개가 올 수 있다.
            union = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (unions[i][j] != 0) continue;
                    countryCount = 0;
                    union++;
                    dfs(i, j);
                    popSum[union] = popSum[union] / countryCount;
                }
            }
            movePop();
            if (union == Math.pow(n, 2)) break;
            answer++;
        }
        System.out.println(answer);
    }

    private static void dfs(int x, int y) {
        unions[x][y] = union;
        popSum[union] += map[x][y];
        countryCount++;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < n && 0 <= ny && ny < n && unions[nx][ny] == 0) {
                int diff = Math.abs(map[x][y] - map[nx][ny]);
                if (l <= diff && diff <= r) {
                    dfs(nx, ny);
                }
            }
        }
    }

    private static void movePop() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = popSum[unions[i][j]];
            }
        }
    }


}
