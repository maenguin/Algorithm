package baekJoon;

import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/9657
//노션 링크 : https://delirious-sock-4dc.notion.site/3-70d1cbadbfaf40d0bb8081d0dc75a808
//문제 유형 : 게임이론, 다이나믹 프로그래밍
public class P9657_돌게임3 {

    //d[i] : 돌이 i개 있을때 선공이 이기면 1, 후공이 이기면 2
    static int[] d = new int[1001];
    static int[] stones = new int[]{1, 3, 4};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        d[1] = 1;
        d[2] = 2;
        d[3] = 1;
        d[4] = 1;
        boolean result = doA(n);
        System.out.println(result ? "SK" : "CY");
    }

    private static boolean doA(int n) {
        //메모라이제이션
        if (d[n] != 0) return d[n] == 1;
        //더이상 가져갈 돌이 없다.
        if (n == 0) return false;
        boolean canWin = false;
        //doB를 해서 나온 결과(b가 이기면 true 아니면 false)를 해서 하나라도 false가 나오면 canWin을 true로 바꾼다.
        for (int stone : stones) {
            if (n - stone >= 0) {
                canWin |= !doB(n - stone);
            }
        }
        d[n] = canWin ? 1 : 2;
        return canWin;
    }

    private static boolean doB(int n) {
        if (d[n] != 0) return d[n] == 1;
        if (n == 0) return false;
        boolean canWin = false;
        for (int stone : stones) {
            if (n - stone >= 0) {
                canWin |= !doB(n - stone);
            }
        }
        d[n] = canWin ? 1 : 2;
        return canWin;
    }

    private static boolean doGame(int n) {
        if (d[n] != 0) return d[n] == 1;
        if (n == 0) return false;
        boolean canWin = false;
        for (int stone : stones) {
            if (n - stone >= 0) {
                canWin |= !doGame(n - stone);
            }
        }
        d[n] = canWin ? 1 : 2;
        return canWin;
    }

}
