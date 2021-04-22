
package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/15650
public class P15650_N과M_2 {

    /*
    [문제설명]
    자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
    1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
    고른 수열은 오름차순이어야 한다.

    [시간제한]
    1 초

    [입력]
    첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

    [출력]
    한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
    수열은 사전 순으로 증가하는 순서로 출력해야 한다.
     */

    static boolean[] visited = new boolean[9];
    static int[] output = new int[9];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        go(0, n, m, 0);
    }


    //조합을 구하는 문제라고 볼 수 있다.
    //1번째에서 start값 오면 두번째에는 start + 1 ~ n 의 값이 와야한다.
    public static void go(int index, int start, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(output[i]);
                if (i != m - 1) {
                    System.out.print(' ');
                }
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            output[index] = i;
            go(index + 1,i+1, n, m);
            visited[i] = false;
        }
    }

    //선택의 관점으로 풀었을때
    public static void go2(int input, int selected, int n, int m) {
        if (selected == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(output[i]);
                if (i != m - 1) {
                    System.out.print(' ');
                }
            }
            System.out.println();
            return;
        }
        if (input > n) return;
        output[selected] = input;
        go2(input + 1, selected + 1, n, m);
        go2(input + 1, selected, n, m);
    }

}
