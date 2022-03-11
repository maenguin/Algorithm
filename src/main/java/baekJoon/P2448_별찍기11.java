package baekJoon;

import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/2448
//노션 링크 : https://delirious-sock-4dc.notion.site/2448-11-adb84b3f7ee04f2096ef45059f2caa50
//문제 유형 : 분할 정복
public class P2448_별찍기11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = (int)(Math.log(n / 3) / Math.log(2));
        char[][] sketchBook = new char[n][6 * n / 3 - 1];
        int startY = 2;
        for (int i = 0; i < k; i++) {
            startY += 3 * (int)Math.pow(2, i);
        }
        markStars(sketchBook, 0, startY, k);
        drawStars(sketchBook);
    }

    private static void markStars(char[][] sketchBook, int x, int y, int k) {
        if (k == 0) {
            markStar(sketchBook, x, y);
            return;
        }
        int pow = 3 * (int)Math.pow(2, k - 1);
        markStars(sketchBook, x, y, k - 1);
        markStars(sketchBook, x + pow, y - pow, k - 1);
        markStars(sketchBook, x + pow, y + pow, k - 1);
    }

    private static int[][] dxys = {{0, 0}, {1, -1}, {1, 1}, {2, -2}, {2, -1}, {2, 0}, {2, 1}, {2, 2}};
    private static void markStar(char[][] sketchBook, int x, int y) {
        for (int[] dxy : dxys) {
            sketchBook[x + dxy[0]][y + dxy[1]] = '*';
        }
    }

    private static void drawStars(char[][] sketchBook) {
        StringBuilder sb = new StringBuilder();
        for (char[] chars : sketchBook) {
            for (char c : chars) {
                sb.append(c == '*' ? '*' : ' ');
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
