package baekJoon;

import java.util.Scanner;

//https://www.acmicpc.net/problem/1037
public class 약수 {

    //양수 A가 N의 진짜 약수가 되려면, N이 A의 배수이고, A가 1과 N이 아니어야 한다. 어떤 수 N의 진짜 약수가 모두 주어질 때, N을 구하는 프로그램을 작성하시오.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] realYaksus = new int[n];
        for (int i = 0; i < n; i++) {
            realYaksus[i] = sc.nextInt();
        }
        System.out.println(solution(realYaksus));
    }

    //n의 약수는 n제곱근을 기준으로 대칭임을 이용한다.
    //즉 진짜 약수의 최솟값과 최댓값을 곱하면 n을 구할 수 있다.
    public static int solution(int[] realYaksus) {
        int max = realYaksus[0];
        int min = realYaksus[0];

        for (int i = 1; i < realYaksus.length; i++) {
            max = Math.max(max, realYaksus[i]);
            min = Math.min(min, realYaksus[i]);
        }
        return max * min;
    }
}
