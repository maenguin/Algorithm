

package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/11052
public class P11052_카드구매하기 {

    /*
    [문제설명]
    링크참조

    [시간제한]
    1 초

    [메모리 제한]
    256 MB

    [입력]
    첫째 줄에 민규가 구매하려고 하는 카드의 개수 N이 주어진다. (1 ≤ N ≤ 1,000)
    둘째 줄에는 Pi가 P1부터 PN까지 순서대로 주어진다. (1 ≤ Pi ≤ 10,000)

    [출력]
    첫째 줄에 민규가 카드 N개를 갖기 위해 지불해야 하는 금액의 최댓값을 출력한다.

     */

    //d[i] = 카드 i를 구매하는 최대 비용
    //d[i] = d[i] = Math.max(d[i], d[i-j] + p[j]); j는 1~n
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n+1];
        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
        }
        int[] d = new int[n + 1];
        //System.out.println(go(n,p,0,0));

        d[0] = 0;
        d[1] = p[1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                d[i] = Math.max(d[i], d[i-j] + p[j]);
            }
        }
        System.out.println(d[n]);
    }

    //시간 초과
   public static int go(int n, int[] p, int sum, int price) {

        if (sum > n) {
            return 0;
        }
        if (sum == n) {
            return price;
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, go(n, p, sum + i, price + p[i])) ;
        }
        return max;
    }


}