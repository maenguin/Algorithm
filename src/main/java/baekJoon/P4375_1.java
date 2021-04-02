package baekJoon;

import java.util.Scanner;

//https://www.acmicpc.net/problem/4375
public class P4375_1 {


    //2와 5로 나누어 떨어지지 않는 정수 n(1 ≤ n ≤ 10000)가 주어졌을 때, 1로만 이루어진 n의 배수를 찾는 프로그램을 작성하시오.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(solution(scanner.nextInt()));
        }
    }

    //(a*b)%n = ((a%n)*(b%n)) 임을 이용했다.
    public static int solution(int n) {
        int num = 1;
        for (int i = 1; ; i++) {
            if (num % n == 0)
                return i;
            num = (num*10+1)%n;
        }
    }



}
