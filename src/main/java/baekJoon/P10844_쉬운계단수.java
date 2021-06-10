

package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/10844
public class P10844_쉬운계단수 {

    /*
    [문제설명]
    45656이란 수를 보자.
    이 수는 인접한 모든 자리수의 차이가 1이 난다. 이런 수를 계단 수라고 한다.
    세준이는 수의 길이가 N인 계단 수가 몇 개 있는지 궁금해졌다.
    N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구하는 프로그램을 작성하시오. (0으로 시작하는 수는 없다.)

    [시간제한]
    2 초

    [입력]
    첫째 줄에 N이 주어진다.
    N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.

    [출력]
    첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mod = 1000000000;

        //d[i] : 길이가 i인 계단수, 마지막 숫자는 j
        int[][] d = new int[n+1][10];

        for (int i = 1; i <= 9; i++) {
            d[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            d[i][0] = d[i-1][1] % mod;
            for (int j = 1; j <= 8; j++) {
                d[i][j] = (d[i-1][j-1] + d[i-1][j+1])% mod;
            }
            d[i][9] = d[i-1][8] % mod;
        }

        long ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans += d[n][i];
            ans = ans % mod;
        }
        System.out.println(ans);
    }



}