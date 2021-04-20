

package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/1748
public class P1748_수이어쓰기1 {

    /*
    [문제설명]
    1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.
    1234567891011121314151617181920212223...
    이렇게 만들어진 새로운 수는 몇 자리 수일까? 이 수의 자릿수를 구하는 프로그램을 작성하시오.

    [시간제한]
    0.15 초

    [입력]
    첫째 줄에 N(1 ≤ N ≤ 100,000,000)이 주어진다.

    [출력]
    첫째 줄에 새로운 수의 자릿수를 출력한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solution(n);
    }

    //1자리수가 9개 2자리수가 90개...임을 이용
    //O(logN)
    public static void solution(int n) {

        int ans = 0;
        int length = Integer.toString(n).length();

        for (int i = 1; i < length; i++) {
            ans += i * 9 * Math.pow(10,i-1);
        }
        ans += (n - Math.pow(10, length - 1) + 1) * length;
        System.out.println(ans);
    }

    //n = 120일때
    //start = 1, end = 9/start = 10, end = 99/start = 100, end = 900
    public static void solution2(int n) {
        long ans = 0;
        for (int start = 1, len = 1; start <= n; start *= 10, len++) {
            int end = start * 10 - 1;
            if (end > n) {
                end = n;
            }
            ans += (long) (end - start + 1) * len;
        }
        System.out.println(ans);
    }



}
