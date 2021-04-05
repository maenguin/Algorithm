package baekJoon;


import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/1978
public class P1978_소수찾기 {

    /*
    주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

    시간제한 : 2 초
    입력 : 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
    출력 : 주어진 수들 중 소수의 개수를 출력한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int primeCnt = 0;
        while (n-- > 0) {
            if (isPrime(sc.nextInt())) {
                primeCnt++;
            }
        }
        System.out.println(primeCnt);
    }


    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}
