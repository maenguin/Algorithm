package baekJoon;

import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/11062
//노션 링크 : https://delirious-sock-4dc.notion.site/3ad25916e3784adebfd2b03de2cb49fd
//문제 유형 : 게임이론
public class P11062_카드게임 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] cards = new int[n];
            for (int i = 0; i < n; i++) {
                cards[i] = scanner.nextInt();
            }
            int result = doA(cards, 0, n - 1, 0);
            System.out.println(result);
        }
    }

    private static int doA(int[] cards, int left, int right, int score) {
        if (left > right) {
            return score;
        }
        int leftResult = doB(cards, left + 1, right, score + cards[left]);
        int rightResult = doB(cards, left, right - 1, score + cards[right]);
        return Math.max(leftResult, rightResult);
    }

    private static int doB(int[] cards, int left, int right, int score) {
        if (left > right) {
            return score;
        }
        int leftResult = doA(cards, left + 1, right, score);
        int rightResult = doA(cards, left, right - 1, score);
        return Math.min(leftResult, rightResult);
    }

}
