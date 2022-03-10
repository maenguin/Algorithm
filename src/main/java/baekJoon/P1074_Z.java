package baekJoon;

import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/1074
//노션 링크 : https://delirious-sock-4dc.notion.site/1074-Z-d93d19a0085f44ed9afdee9a85d4f703
//문제 유형 : 분할 정복
public class P1074_Z {

    private static int N;
    private static int c;
    private static int r;
    private static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        divideAndConquer(N, 0, 0, 0);
        System.out.println(answer);
    }

    private static void divideAndConquer(int n, int x, int y, int num) {
        if (!isInRange(x, y, (int)Math.pow(2, n))) {
            return;
        }
        if (n == 0) {
            answer = num;
            return;
        }
        int pow = (int)Math.pow(2, n - 1);
        int pow2 = pow * pow;
        divideAndConquer(n - 1, x, y, num);
        divideAndConquer(n - 1, x, y + pow, num + pow2);
        divideAndConquer(n - 1, x + pow, y, num + pow2 * 2);
        divideAndConquer(n - 1, x + pow, y + pow, num + pow2 * 3);
    }

    private static boolean isInRange(int x, int y, int pow) {
        return x <= r && r < x + pow && y <= c && c < y + pow;
    }

}
