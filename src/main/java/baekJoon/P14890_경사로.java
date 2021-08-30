
package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/14890
//코드 플러스 - 코딩 테스트 준비 - 기초 - 시뮬레이션과 구현
public class P14890_경사로 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int answer = 0;
        //가로 검사
        for (int i = 0; i < n; i++) {
            if (check(map[i], l)) {
                answer++;
            }
        }

        //세로 검사
        for (int j = 0; j < n; j++) {
            int[] road = new int[n];
            for (int i = 0; i < n; i++) {
                road[i] = map[i][j];
            }
            if (check(road, l)) {
                answer++;
            }
        }

        System.out.println(answer);

    }

    public static boolean check(int[] road, int l) {
        boolean[] slope = new boolean[road.length];
        for (int i = 0; i < road.length - 1; i++) {
            int cur = road[i];
            int next = road[i + 1];

            //높이차가 있는 경우
            if (cur != next) {

                //낮은 칸과 높은 칸의 높이 차이가 1이 아닌 경우
                if (Math.abs(cur - next) != 1) return false;

                //다음 길 따라 경사로를 놔야되는 경우
                if (cur > next) {
                    //경사로를 놓다가 범위를 벗어나는 경우
                    if (i + l + 1 > road.length) return false;

                    for (int k = 0; k < l; k++) {
                        //낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우
                        if (road[i + k + 1] != next) return false;
                        //경사로를 놓은 곳에 또 경사로를 놓는 경우
                        if (slope[i + k + 1]) return false;
                        slope[i + k + 1] = true;
                    }
                }
                //이전 길 따라 경사로를 놔야되는 경우
                else {
                    //경사로를 놓다가 범위를 벗어나는 경우
                    if (i - l + 1 < 0) return false;

                    for (int k = 0; k < l; k++) {
                        //낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우
                        if (road[i - k] != cur) return false;
                        //경사로를 놓은 곳에 또 경사로를 놓는 경우
                        if (slope[i - k]) return false;
                        slope[i - k] = true;
                    }

                }


            }
        }
        return true;
    }


}
