
package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/9095
public class P9095_123더하기 {

    /*
    [문제설명]
    정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
    1+1+1+1
    1+1+2
    1+2+1
    2+1+1
    2+2
    1+3
    3+1
    정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

    [시간제한]
    1 초 (추가 시간 없음)

    [입력]
    첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 11보다 작다.

    [출력]
    각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solution(sc.nextInt());
        }
    }

    public static void solution(int n) {
        int ans = recursive(n, 0, 0);
        System.out.println(ans);
    }

    public static int recursive(int n, int depth, int sum) {
        if (sum > n) {
            return 0;
        }
        if (sum == n) {
            return 1;
        }
        int cnt = 0;
        cnt += recursive(n, depth + 1, sum + 1);
        cnt += recursive(n, depth + 1, sum + 2);
        cnt += recursive(n, depth + 1, sum + 3);
        return cnt;
    }


}