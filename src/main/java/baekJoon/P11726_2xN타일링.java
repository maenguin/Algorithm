package baekJoon;

import java.util.Scanner;

public class P11726_2xN타일링 {

    /*
    2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
    아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.

    시간제한 : 1 초
    입력 : 첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
    출력 : 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solution(n);
    }

    // d[i] : 2xi 크기의 직사각형을 채우는 방법의 수
    // d[n] = d[n-1] + d[n-2]
    // n이 홀수라면 d[n]은 d[n-1]에서 |을 추가한 경우와 d[n-2]에서 =을 추가한 경우의 합
    // d[2]를 먼저 초기화 하면 n = 1일때 에러
    public static void solution(int n) {
        int[] d = new int[n + 1];
        d[0] = 1;
        d[1] = 1;

        for (int i = 2; i <= n; i++) {
            d[i] = (d[i-1] + d[i-2]) % 10007;
        }
        System.out.println(d[n]);
    }
}
