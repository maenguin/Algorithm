package baekJoon;

import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/1072
//노션 링크 : https://delirious-sock-4dc.notion.site/cd5ddc16920549aba706f968e43880b1
//문제 유형 : 그래프 탐색, 그래프 이론
//풀이 방법 : DFS
public class P1072_게임 {

    private static long X;
    private static long Y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        X = sc.nextInt();
        Y = sc.nextInt();
        int Z = calculateWinRate(0);
        if (Z >= 99) {
            System.out.println(-1);
            return;
        }
        System.out.println(lowerBound(Z + 1));
    }

    private static int calculateWinRate(int value) {
        return (int)(((Y + value) * 100) / (X + value));
    }

    private static int lowerBound(int target) {
        int left = 0;
        int right = (int) X;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (calculateWinRate(mid) >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
