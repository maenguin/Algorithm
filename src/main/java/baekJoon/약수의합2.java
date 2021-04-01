package baekJoon;


import java.util.Scanner;

//https://www.acmicpc.net/problem/17427
public class 약수의합2 {

    /*
    두 자연수 A와 B가 있을 때, A = BC를 만족하는 자연수 C를 A의 약수라고 한다.
    예를 들어, 2의 약수는 1, 2가 있고, 24의 약수는 1, 2, 3, 4, 6, 8, 12, 24가 있다.
    자연수 A의 약수의 합은 A의 모든 약수를 더한 값이고, f(A)로 표현한다. x보다 작거나 같은 모든 자연수 y의 f(y)값을 더한 값은 g(x)로 표현한다.
    자연수 N이 주어졌을 때, g(N)을 구해보자.

    시간제한 : 0.5 초 (추가 시간 없음)
    문제의 크기 : N(1 ≤ N ≤ 1,000,000)
    시간복잡도 O(N√N) 보다 적게 걸리는 알고리즘을 사용해야한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    //N이하의 자연수 중에서 M을 약수로 갖는 수(M의 배수)의 개수는 N/M(반내림)개 임을 이용한다.
    public static long solution(int n) {
        long answer = 0;
        for (int i = 1; i <= n; i++) {
            answer += (n/i)*i;
        }
        return answer;
    }

}
