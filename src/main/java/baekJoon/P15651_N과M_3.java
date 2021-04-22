


package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/15651
public class P15651_N과M_3 {

    /*
    [문제설명]
    자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
    1부터 N까지 자연수 중에서 M개를 고른 수열
    같은 수를 여러 번 골라도 된다.

    [시간제한]
    1 초

    [입력]
    첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)

    [출력]
    한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
    수열은 사전 순으로 증가하는 순서로 출력해야 한다.
     */

    static int[] output;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        output = new int[m];
        System.out.println(go(0, n, m));
    }


    //중복이 가능한 순열을 구하는 문제라고 볼 수 있다.
    //N과M(1)에서 중복을 방지하기 위해 작성했던 코드를 지우자.
    public static StringBuilder go(int index, int n, int m) {
        if (index == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(output[i]);
                if (i != m - 1) {
                    sb.append(' ');
                }
            }
            sb.append('\n');
            return sb;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            //if (visited[i]) continue;
            //visited[i] = true;
            output[index] = i;
            sb.append(go(index + 1, n, m));
            //visited[i] = false;
        }
        return sb;
    }

}

