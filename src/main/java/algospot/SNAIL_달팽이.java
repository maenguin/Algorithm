package algospot;

import java.util.Arrays;
import java.util.Scanner;

//문제 출처 : https://algospot.com/judge/problem/read/SNAIL
//노션 링크 : https://delirious-sock-4dc.notion.site/SNAIL-ff711bb542a94af984b6d574f757396d
//알고 리즘 : DP
public class SNAIL_달팽이 {

    private static int n;
    private static int m;
    private static double[][] cache = new double[1000][2000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        while (c-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            for (double[] doubles : cache) {
                Arrays.fill(doubles, -1);
            }
            System.out.println(snail2(0, 0));
        }
    }

    //달팽이가 day일 동안 climbed미터를 기어올라 왔다고 할 때,
    //m일 전까지 n미터를 기어올라갈 수 있는 경우의 수
    private static int snail(int day, int climbed) {
        if (day == m) return climbed >= n ? 1 : 0;
        return snail(day + 1, climbed + 1) + snail(day + 1, climbed + 2);
    }

    //달팽이가 day일 동안 climbed미터를 기어올라 왔다고 할 때,
    //m일 전까지 n미터를 기어올라갈 수 있는 확률
    private static double snail2(int day, int climbed) {
        if (day == m) return climbed >= n ? 1 : 0;
        if (cache[day][climbed] != -1) return cache[day][climbed];
        return cache[day][climbed] = 0.25 * snail2(day + 1, climbed + 1) + 0.75 * snail2(day + 1, climbed + 2);
    }

}
