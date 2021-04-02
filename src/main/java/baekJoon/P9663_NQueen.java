package baekJoon;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

//https://www.acmicpc.net/problem/9663
public class P9663_NQueen {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] board = new int[n][n];
        boolean[] visited = new boolean[n];

        int answer = nQueen(board, visited, 0);

        System.out.println(answer);
    }

    public static int nQueen(int[][] board,boolean[] visited, int depth ) {
        if (depth == board.length) {
            for (int[] ints : board) {
                System.out.println(Arrays.toString(ints));
            }
            System.out.println();
            return 1;
        }

        int cnt = 0;
        for (int i = 0; i < board.length; i++) {
            if (!visited[i] && isValid(board, i, depth)) {
                board[i][depth] = 1;
                //선택된 퀸열을 제외하기 위함
                visited[i] = true;
                cnt += nQueen(board, visited, depth+1);
                board[i][depth] = 0;
                visited[i] = false;
            }
        }
        return cnt;
    }

    private static boolean isValid(int[][] board, int x, int y) {

        for (int i = 1; i <= y; i++) {

            //왼쪽 수평, 왼쪽 위 대각, 왼쪽 아래 대각에 퀸이 있는지 검사사
           if (board[x][y - i] == 1 || (x+i < board.length &&  board[x + i][y - i] == 1) || (x-i >= 0 && board[x - i][y - i] == 1)) {
                return false;
            }
        }
        return true;
    }




}
