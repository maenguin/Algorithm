package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/3085
public class P3085_사탕게임 {

    /*
    [문제설명]
    상근이는 어렸을 적에 "봄보니 (Bomboni)" 게임을 즐겨했다.
    가장 처음에 N×N크기에 사탕을 채워 놓는다. 사탕의 색은 모두 같지 않을 수도 있다.
    상근이는 사탕의 색이 다른 인접한 두 칸을 고른다. 그 다음 고른 칸에 들어있는 사탕을 서로 교환한다.
    이제, 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)을 고른 다음 그 사탕을 모두 먹는다.
    사탕이 채워진 상태가 주어졌을 때, 상근이가 먹을 수 있는 사탕의 최대 개수를 구하는 프로그램을 작성하시오.

    [시간제한]
    1 초

    [입력]
    첫째 줄에 보드의 크기 N이 주어진다. (3 ≤ N ≤ 50)
    다음 N개 줄에는 보드에 채워져 있는 사탕의 색상이 주어진다. 빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y로 주어진다.
    사탕의 색이 다른 인접한 두 칸이 존재하는 입력만 주어진다.

    [출력]
    첫째 줄에 상근이가 먹을 수 있는 사탕의 최대 개수를 출력한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] candies = new char[n][n];
        for (int i = 0; i < n; i++) {
            candies[i] = sc.next().toCharArray();
        }
        solution(candies);
    }

    //좌우와 상하의 사탕을 선택 -> 스왑 -> check -> 스왑
    //사탕을 교환하는 경우의 수 대략 2*N^2 & 연속된 사탕 check하는 시간 복잡도 O(N^2) => O(N^4)
    public static void solution(char[][] candies) {

        int max = 0;
        int n = candies.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n){
                    swap(candies, i, j, i, j +1);
                    max = Math.max(max, check(candies, i, i, j, j + 1));
                    swap(candies, i, j, i, j +1);
                }
                if (i + 1 < n) {
                    swap(candies, i, j, i + 1, j);
                    max = Math.max(max, check(candies, i, i + 1, j, j));
                    swap(candies, i, j, i + 1, j);
                }
            }
        }
        System.out.println(max);
    }

    public static void swap(char[][] candies, int ax, int ay, int bx, int by) {
        char temp = candies[ax][ay];
        candies[ax][ay] = candies[bx][by];
        candies[bx][by] = temp;
    }

    //모든 사탕에 대해 연속된 사탕을 검사 O(N^2)
    public static int check(char[][] candies){

        int max = 0;
        int n = candies.length;

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                cnt = candies[i][j] == candies[i][j-1] ? cnt + 1 : 1;
                max = Math.max(max, cnt);
            }

            cnt = 1;
            for (int j = 1; j < n; j++) {
                cnt = candies[j][i] == candies[j-1][i] ? cnt + 1 : 1;
                max = Math.max(max, cnt);
            }
        }

        return max;
    }

    //연속된 사탕을 체크하는 경우 교환한 열과 행에 해당하는 3개의 라인만 비교하면 된다.
    //단 이경우에는 인접한 사탕이 같은 경우에도 check를 수행해야한다.
    //O(N^2) => O(N)
    public static int check(char[][] candies, int startRow, int endRow, int startCol, int endCol){

        int max = 0;
        int n = candies.length;

        for (int i = startRow; i <= endRow; i++) {
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                cnt = candies[i][j] == candies[i][j - 1] ? cnt + 1 : 1;
                max = Math.max(max, cnt);
            }
        }

        for (int i = startCol; i <= endCol; i++) {
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                cnt = candies[j][i] == candies[j - 1][i] ? cnt + 1 : 1;
                max = Math.max(max, cnt);
            }
        }

        return max;
    }
}