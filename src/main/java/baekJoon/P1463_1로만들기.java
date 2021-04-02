package baekJoon;

import java.util.Arrays;
import java.util.Scanner;

//https://www.acmicpc.net/problem/1463
public class P1463_1로만들기 {

    /*
    정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
    1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
    2. X가 2로 나누어 떨어지면, 2로 나눈다.
    3. 1을 뺀다.
    정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

    시간제한 : 0.15 초
    입력 : 첫째 줄에 1보다 크거나 같고, 10^6보다 작거나 같은 정수 N이 주어진다.
    출력 : 첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solution(n);
    }

    // d[i] : i를 1로 만들때의 연산 횟수의 최소값을 저장하는 배열
    // 어떤 수 를 한번 연산했을때 3이 나오면 그 수의 최솟값은 1 + 3의 최솟값(1)이된다.
    // 이를 이용해 답을 재사용하는 방향으로 구한다.
    // 3가지 연산을 모두 시도했을때 최소가 되는 값을 d[i]배열에 저장한다.
    // d[n] = 1 + min(d[n/3], d[n/2], d[n-1])
    public static void solution(int n) {
        int[] d = new int[n + 1];
        d[1] = 0;

        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + 1;
            if (i % 3 == 0) {
                d[i] = Math.min(d[i], d[i / 3] + 1);
            }
            if (i % 2 == 0) {
                d[i] = Math.min(d[i], d[i / 2] + 1);
            }
        }
        System.out.println(d[n]);
    }


    //Top-down으로 구해보기
    public static int[] d;
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n + 1];
        System.out.println(solution2(n));
    }

    public static int solution2(int n) {
        //가장 작은 크기
        if (n == 1) {
            return 0;
        }
        //Memorization
        if (d[n] > 0) {
            return d[n];
        }
        d[n] = solution2(n-1) + 1;
        if (n % 3 == 0) {
            d[n] = Math.min(d[n], solution2(n/3) + 1);
        }
        if (n % 2 == 0) {
            d[n] = Math.min(d[n], solution2(n/2) + 1);
        }
        return d[n];
    }

}