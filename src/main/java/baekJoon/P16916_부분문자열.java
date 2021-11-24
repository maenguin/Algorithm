package baekJoon;

import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/16916
//문제 유형 : 문자열
//알고리즘 : 투포인터
public class P16916_부분문자열 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String p = scanner.next();
        bruteForce(s, p);
    }

    private static void bruteForce(String s, String p) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != p.charAt(0)) continue;
            boolean matched = true;
            for (int j = 0; j < p.length(); j++) {
                if (i + j >= s.length() || s.charAt(i + j) != p.charAt(j)) {
                    matched = false;
                    break;
                }
            }
            if (matched) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
}
