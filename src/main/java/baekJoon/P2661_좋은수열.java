package baekJoon;

import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/2661
//노션 링크 : https://delirious-sock-4dc.notion.site/2661-f848fcdb2d684247a71af586247365e4
//문제 유형 : 그리디
public class P2661_좋은수열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        backTracking(n, "1", 1);
    }

    private static void backTracking(int n, String progression, int depth) {
        if (depth == n) {
            System.out.println(progression);
            System.exit(0);
        }
        for (int i = 1; i <= 3; i++) {
            if (isOk(progression, i)) {
                backTracking(n, progression + i, depth + 1);
            }
        }
    }

    private static boolean isOk(String progression, int num) {
        progression += num;
        int len = progression.length();
        for (int a = len - 2, b = len - 1; a >= 0 ; a -= 2, b -= 1) {
            if (progression.substring(a, b).equals(progression.substring(b))) return false;
        }
        return true;
    }

}
