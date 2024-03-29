package baekJoon;

import java.util.ArrayList;
import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/20437
//문제 유형 : 문자열
//알고리즘 : 투포인터
public class P20437_문자열게임2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            solution2(scanner.next(), scanner.nextInt());
        }
    }

    private static void solution(String w, int k) {
        int[] charCounts = new int['z' - 'a' + 1];
        for (char c : w.toCharArray()) {
            charCounts[c - 'a']++;
        }

        int firstGame = Integer.MAX_VALUE;
        int secondGame = -1;

        for (int i = 0; i < w.length(); i++) {
            if (charCounts[w.charAt(i) - 'a'] < k) continue;

            int matchCount = 0;
            for (int j = i; j < w.length(); j++) {
                if (w.charAt(i) == w.charAt(j)) {
                    matchCount++;
                }
                if (matchCount == k) {
                    firstGame = Math.min(firstGame, j - i + 1);
                    secondGame = Math.max(secondGame, j - i + 1);
                    break;
                }
            }
        }

        System.out.println(firstGame == Integer.MAX_VALUE ? -1 : firstGame + " " + secondGame);
    }

    private static void solution2(String w, int k) {
        int firstGame = Integer.MAX_VALUE;
        int secondGame = -1;
        ArrayList<Integer>[] charPositions = new ArrayList[26];
        for (int i = 0; i < charPositions.length; i++)
            charPositions[i] = new ArrayList<>();
        for (int i = 0; i < w.length(); i++)
            charPositions[w.charAt(i) - 'a'].add(i);
        for (int i = 0; i < charPositions.length; i++) {
            if (charPositions[i].size() < k) continue;
            for (int j = 0; j + k - 1 < charPositions[i].size(); j++) {
                int diff = charPositions[i].get(j + k - 1) - charPositions[i].get(j) + 1;
                firstGame = Math.min(firstGame, diff);
                secondGame = Math.max(secondGame, diff);
            }
        }
        System.out.println(firstGame == Integer.MAX_VALUE ? -1 : firstGame + " " + secondGame);
    }
}
