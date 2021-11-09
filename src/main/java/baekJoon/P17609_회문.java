package baekJoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//문제 출처 : https://www.acmicpc.net/problem/17609
//문제 유형 : 문자열
//알고리즘 : 투 포인터
public class P17609_회문 {

    //회문 예시 : ‘abba’ ‘kayak’, ‘reviver’, ‘madam’
    //유사 회문 : 문자 하나 삭제하면 회문이 되는 문자열  (ex) ‘summuus’)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            String s = scanner.next();
            System.out.println(checkPalindrome(s));
        }
    }

    private static int checkPalindrome(String s) {
        if (isPalindrome(s)) {
            return 0;
        }
        if (maybePalindrome(s)) {
            return 1;
        }
        return 2;
    }

    //이렇게 풀면 안됨
    public static boolean maybePalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        boolean canSkip = true;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                continue;
            }
            if (canSkip) {
                canSkip = false;
                if (s.charAt(i + 1) == s.charAt(j)) {
                    i++;
                    continue;
                }
                if (s.charAt(i) == s.charAt(j - 1)) {
                    j--;
                    continue;
                }
            }
            return false;
        }
        return true;
    }

    //다를떄 왼쪽 오른쪽 한번씩 옆으로 스킵해서 같은지 확인하고
    //하나라도 같은 경우가 있고 그 이후로도 계속 같으면 유사회문
    public static boolean maybePalindrome2(String s, int left, int right, boolean canSkip) {
        if (left > right) {
            return true;
        }
        if (s.charAt(left) == s.charAt(right)) {
            return maybePalindrome2(s, left + 1, right - 1, canSkip);
        } else if (canSkip) {
            return maybePalindrome2(s, left + 1, right, false) || maybePalindrome2(s, left, right - 1, false);
        } else {
            return false;
        }
    }

    private static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
