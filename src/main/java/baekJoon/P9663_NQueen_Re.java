package baekJoon;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/9663
//문제 유형 : 브루트 포스, 백트래킹
public class P9663_NQueen_Re {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] board = new int[n][n];
        boolean[] visitedRow = new boolean[n];
        int answer = nQueen(board, visitedRow, 0);
        System.out.println(answer);
    }

    private static int nQueen(int[][] board, boolean[] visitedRow, int depth) {
        int n = board.length;
        if (depth == n) {
            return 1;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (visitedRow[i] || !validatePosition(board, i, depth)) {
                continue;
            }
            visitedRow[i] = true;
            board[i][depth] = 1;
            result += nQueen(board, visitedRow, depth + 1);
            board[i][depth] = 0;
            visitedRow[i] = false;
        }
        return result;
    }

    private static boolean validatePosition(int[][] board, int x, int y) {
        for (int i = 1; i <= y; i++) {
            if (board[x][y - i] == 1) {
                return false;
            }
            if (x - i >= 0 && board[x - i][y - i] == 1) {
                return false;
            }
            if (x + i < board.length && board[x + i][y - i] == 1) {
                return false;
            }
        }
        return true;
    }
}
