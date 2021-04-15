
package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/1107
public class P1107_리모컨 {

    /*
    [문제설명]
    수빈이는 TV를 보고 있다.
    수빈이는 채널을 돌리려고 했지만, 버튼을 너무 세게 누르는 바람에, 일부 숫자 버튼이 고장났다.
    리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다.
    +를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고, -를 누르면 -1된 채널로 이동한다.
    채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.
    수빈이가 지금 이동하려고 하는 채널은 N이다.
    어떤 버튼이 고장났는지 주어졌을 때, 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오.
    수빈이가 지금 보고 있는 채널은 100번이다.

    [시간제한]
    2 초

    [입력]
    첫째 줄에 수빈이가 이동하려고 하는 채널 N (0 ≤ N ≤ 500,000)이 주어진다.
    둘째 줄에는 고장난 버튼의 개수 M (0 ≤ M ≤ 10)이 주어진다.
    고장난 버튼이 있는 경우에는 셋째 줄에는 고장난 버튼이 주어지며, 같은 버튼이 여러 번 주어지는 경우는 없다.

    [출력]
    첫째 줄에 채널 N으로 이동하기 위해 버튼을 최소 몇 번 눌러야 하는지를 출력한다.
     */

    private static boolean[] broken = new boolean[10];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            broken[sc.nextInt()] = true;
        }
        solution(n);
    }

    public static void solution(int n) {
        int MAX = 1000000;
        int initChannel = 100;
        int ans = Math.abs(initChannel - n);

        for (int i = 0; i < MAX; i++) {
            int len = getLengthIfPossible(i);
            if (len > 0) {
                ans = Math.min(len + Math.abs(n - i), ans);
            }
        }
        System.out.println(ans);
    }

    private static int getLengthIfPossible(int i) {
        int len = 0;
        do {
            if (broken[i % 10]) {
                return 0;
            }
            i /= 10;
            len++;
        } while (i != 0);
        return len;
    }


}