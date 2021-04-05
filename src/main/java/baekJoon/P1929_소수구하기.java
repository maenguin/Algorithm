package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/1929
public class P1929_소수구하기 {

    /*
    M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

    시간제한 : 2 초
    입력 : 째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
    출력 : 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean[] sieve = eratosSieve(m);
        for (int i = n; i <= m; i++) {
            if (!sieve[i]) {
                System.out.println(i);
            }
        }
    }


    public static boolean[] eratosSieve(int n) {
        boolean[] sieve = new boolean[n + 1];
        sieve[0] = true;
        sieve[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (!sieve[i]) {
                for (int j = 2; i * j <= n; j++) {
                    sieve[i * j] = true;
                }
            }
        }

        return sieve;
    }

}
