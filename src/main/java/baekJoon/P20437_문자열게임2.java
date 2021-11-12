package baekJoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/20437
//문제 유형 : 문자열
//알고리즘 : 슬라이딩 윈도우
public class P20437_문자열게임2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            solution(scanner.next(), scanner.nextInt());
        }
    }

    private static void solution(String w, int k) {
        int result = -1;
        for (int i = k; i <= w.length(); i++) {
            result = getMinimumStringLength(w, k, i);
            if (result != -1) break;
        }
        if (result == -1) {
            System.out.println("-1");
            return;
        }
        String s = result + " ";

        for (int i = w.length() - 1; i >= 0; i--) {
            result = getMaximumStringLength(w, k, i);
            if (result != -1) break;
        }
        if (result == -1) {
            System.out.println("-1");
            return;
        }
        System.out.println(s+result);
    }

    private static int getMinimumStringLength(String w, int k, int windowSize) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        for (int end = 0; end < w.length(); end++) {
            char endC = w.charAt(end);
            map.put(endC, map.getOrDefault(endC, 0) + 1);
            if (end >= windowSize - 1) {
                for (Integer value : map.values()) {
                    if (value == k) {
                        return windowSize;
                    }
                }
                char startC = w.charAt(start);
                map.put(startC, map.getOrDefault(startC, 0) - 1);
                start++;
            }

        }
        return -1;
    }

    private static int getMaximumStringLength(String w, int k, int windowSize) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        for (int end = 0; end < w.length(); end++) {
            char endC = w.charAt(end);
            map.put(endC, map.getOrDefault(endC, 0) + 1);
            if (end >= windowSize - 1) {
                for (Character key : map.keySet()) {
                    if (map.get(key) == k && key == endC && w.charAt(start) == endC) {
                        System.out.println(w.substring(start, end+1));
                        return windowSize;
                    }
                }
                char startC = w.charAt(start);
                map.put(startC, map.getOrDefault(startC, 0) - 1);
                start++;
            }

        }
        return -1;
    }

}
