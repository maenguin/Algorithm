package algospot;

import java.util.Scanner;

//문제 출처 : https://algospot.com/judge/problem/read/PI
//노션 링크 : https://delirious-sock-4dc.notion.site/PI-80708652dc114c49bbc37730bc380d78
//알고 리즘 : DP
public class PI_원주율외우기 {

    private static String pi;
    private static int[] cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (C-- > 0) {
            pi = sc.next();
            cache = new int[pi.length()];
            sb.append(memorize(0)).append('\n');
        }
        System.out.println(sb);
    }

    private static int memorize(int index) {
        if (index >= pi.length()) return 0;
        if (cache[index] != 0) return cache[index];
        int min = (int) 2e9;
        for (int i = 3; i <= 5; i++) {
            if (index + i <= pi.length()) {
                min = Math.min(min, memorize(index + i) + measureLevelOfDifficulty(index, index + i));
            }
        }
        return cache[index] = min;
    }

    private static int measureLevelOfDifficulty(int startInclusive, int endExclusive) {
        boolean isAllSame = true;
        boolean isMonotonicRise = true;
        boolean isMonotonicDecline = true;
        char preChar = pi.charAt(startInclusive);
        for (int i = startInclusive + 1; i < endExclusive; i++) {
            if (preChar != pi.charAt(i)) {
                isAllSame = false;
            }
            if (preChar != pi.charAt(i) - 1) {
                isMonotonicRise = false;
            }
            if (preChar != pi.charAt(i) + 1) {
                isMonotonicDecline = false;
            }
            preChar = pi.charAt(i);
        }
        boolean isAlternative = true;
        char first = pi.charAt(startInclusive);
        char second = pi.charAt(startInclusive + 1);
        boolean isArithmeticSequence = true;
        int gap = pi.charAt(startInclusive + 1) - pi.charAt(startInclusive);
        for (int i = startInclusive + 2; i < endExclusive; i++) {
            if ((i - startInclusive) % 2 == 0 && pi.charAt(i) != first) {
                isAlternative = false;
            }
            if ((i - startInclusive) % 2 == 1 && pi.charAt(i) != second) {
                isAlternative = false;
            }
            if (pi.charAt(i) - pi.charAt(i - 1) != gap) {
                isArithmeticSequence = false;
            }
        }

        if (isAllSame) {
            return 1;
        } else if (isMonotonicRise | isMonotonicDecline) {
            return 2;
        } else if (isAlternative) {
            return 4;
        } else if (isArithmeticSequence) {
            return 5;
        } else {
            return 10;
        }
    }

}
