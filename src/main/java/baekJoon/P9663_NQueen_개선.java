package baekJoon;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

//문제 출처 : https://www.acmicpc.net/problem/9663
//문제 유형 : 브루트 포스, 백트래킹
public class P9663_NQueen_개선 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] queenRow = IntStream.range(0, n).map(o -> -1).toArray();
        int answer = nQueen(queenRow, n, 0);
        System.out.println(answer);
    }

    private static int nQueen(int[] queenRow, int n, int depth) {
        if (depth == n) return 1;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (!validatePosition(queenRow, i, depth)) continue;
            queenRow[depth] = i;
            result += nQueen(queenRow, n, depth + 1);
            queenRow[depth] = -1;
        }
        return result;
    }

    private static boolean validatePosition(int[] queenRow, int x, int y) {
        for (int i = 0; i <= y; i++) {
            if (queenRow[i] == x || queenRow[y - i] == x + i || queenRow[y - i] == x - i) {
                return false;
            }
        }
        return true;
    }
}
