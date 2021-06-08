package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/11727
public class P11727_2xn타일링2 {

    /*
    [문제설명]
    2×n 직사각형을 1×2, 2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
    아래 그림은 2×17 직사각형을 채운 한가지 예이다.

    1, 2, 3
    1, 3, 2
    2, 1, 3
    2, 3, 1
    3, 1, 2
    3, 2, 1

    [시간제한]
    1 초

    [입력]
    첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)

    [출력]
    첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
     */

    //d[i] : 2xi 크기의 직사각형을 채우는 방법의 수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n+1];

        d[0] = 1;
        d[1] = 1;

        for (int i = 2; i <= n; i++) {
            d[i] = (2*d[i-2] + d[i-1])%10007;
        }
        System.out.println(d[n]);
    }


}