package baekJoon;

import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/11062
//노션 링크 : https://delirious-sock-4dc.notion.site/3-70d1cbadbfaf40d0bb8081d0dc75a808
//문제 유형 : 게임이론, 다이나믹 프로그래밍
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
            Result result = doA(cards, 0, n - 1, 0, 0);
            System.out.println(result.scoreA);
        }
    }

    private static Result doA(int[] cards, int left, int right, int scoreA, int scoreB) {
        if (left > right) {
            return new Result(false, scoreA, scoreA);
        }
        boolean canWin = false;
        Result leftResult = doB(cards, left + 1, right, scoreA + cards[left], scoreB);
        Result rightResult = doB(cards, left, right - 1, scoreA + cards[right], scoreB);
        canWin = !leftResult.win || !rightResult.win;
        if (leftResult.scoreA > rightResult.scoreA) {
            return new Result(canWin, leftResult.scoreA, leftResult.scoreB);
        }
        return new Result(canWin, rightResult.scoreA, rightResult.scoreB);
    }

    private static Result doB(int[] cards, int left, int right, int scoreA, int scoreB) {
        if (left > right) {
            return new Result(false, scoreA, scoreB);
        }
        boolean canWin = false;
        Result leftResult = doA(cards, left + 1, right, scoreA, scoreB + cards[left]);
        Result rightResult = doA(cards, left, right - 1, scoreA, scoreB + cards[right]);
        canWin = !leftResult.win || !rightResult.win;
        if (leftResult.scoreB > rightResult.scoreB) {
            return new Result(canWin, leftResult.scoreA, leftResult.scoreB);
        }
        return new Result(canWin, rightResult.scoreA, rightResult.scoreB);
    }

    private static class Result {
        boolean win;
        int scoreA;
        int scoreB;

        public Result(boolean win, int scoreA, int scoreB) {
            this.win = win;
            this.scoreA = scoreA;
            this.scoreB = scoreB;
        }
    }

}
