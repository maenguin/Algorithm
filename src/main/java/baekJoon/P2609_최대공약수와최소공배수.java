package baekJoon;

import java.util.*;

////https://www.acmicpc.net/problem/2609
public class P2609_최대공약수와최소공배수 {

    /*
    두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.

    시간제한 : 1 초
    입력 : 첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.
    출력 : 첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int gcd = gcd(a, b);
        int lcm = (a*b)/gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }

    public static int gcd(int a, int b) {
        int r = a % b;
        while (r != 0) {
            a = b;
            b = r;
            r = a % b;
        }
        return b;
    }

    public static int gcd2(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static int gcdRC(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcdRC(b, a % b);
    }


    public static int lcm(int a, int b) {
        return (a * b) / gcd(a,b);
    }
}
