package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/14501
public class P14501_퇴사 {

    /*
    [문제설명]
    상담원으로 일하고 있는 백준이는 퇴사를 하려고 한다.
    오늘부터 N+1일째 되는 날 퇴사를 하기 위해서, 남은 N일 동안 최대한 많은 상담을 하려고 한다.
    백준이는 비서에게 최대한 많은 상담을 잡으라고 부탁을 했고, 비서는 하루에 하나씩 서로 다른 사람의 상담을 잡아놓았다.
    각각의 상담은 상담을 완료하는데 걸리는 기간 Ti와 상담을 했을 때 받을 수 있는 금액 Pi로 이루어져 있다.
    N = 7인 경우에 다음과 같은 상담 일정표를 보자.
    1일에 잡혀있는 상담은 총 3일이 걸리며, 상담했을 때 받을 수 있는 금액은 10이다.
    5일에 잡혀있는 상담은 총 2일이 걸리며, 받을 수 있는 금액은 15이다.
    상담을 하는데 필요한 기간은 1일보다 클 수 있기 때문에, 모든 상담을 할 수는 없다.
    예를 들어서 1일에 상담을 하게 되면, 2일, 3일에 있는 상담은 할 수 없게 된다. 2일에 있는 상담을 하게 되면, 3, 4, 5, 6일에 잡혀있는 상담은 할 수 없다.
    또한, N+1일째에는 회사에 없기 때문에, 6, 7일에 있는 상담을 할 수 없다.
    퇴사 전에 할 수 있는 상담의 최대 이익은 1일, 4일, 5일에 있는 상담을 하는 것이며, 이때의 이익은 10+20+15=45이다.
    상담을 적절히 했을 때, 백준이가 얻을 수 있는 최대 수익을 구하는 프로그램을 작성하시오.

    [시간제한]
    2 초

    [입력]
    첫째 줄에 N (1 ≤ N ≤ 15)이 주어진다.
    둘째 줄부터 N개의 줄에 Ti와 Pi가 공백으로 구분되어서 주어지며, 1일부터 N일까지 순서대로 주어진다. (1 ≤ Ti ≤ 5, 1 ≤ Pi ≤ 1,000)

    [출력]
    첫째 줄에 백준이가 얻을 수 있는 최대 이익을 출력한다.
     */

    static int N;
    static int[] T;
    static int[] P;
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        T = new int[N + 1];
        P = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        go2(1,0);
        System.out.println(ans);
    }

    public static void go(int next, int N, int[] T, int[] P, int sum) {

        if (next > N || next + T[next] > N + 1) {
            ans = Math.max(ans, sum);
            System.out.println("sum = " + sum);
            return ;
        }
        sum += P[next];
        System.out.println("next = " + next + " sum = "+sum);
        go(next + T[next], N, T, P , sum);
        for (int i = next + T[next] + 1; i <= N; i++) {
            go(i, N, T, P , sum);
        }
    }


    //강의
    //각 날짜별로 상담을 할지 말지 선택한다.
    //상담을 하게되면 상담 가능 day가 늘어나고 수입을 얻는다.
    //상담을 안하게되면 다음날로 넘어가고 수입은 얻지 않는다.

    //day : 다음 상담일
    //sum : day 직전 상담까지의 수입
    public static void go2(int day, int sum) {
        //실패 조건
        if (day > N + 1) {
            return;
        }
        //성공 조건
        if (day == N + 1){
            ans = Math.max(ans, sum);
            return;
        }

        //상담 o
        go2(day + T[day], sum + P[day]);
        //상담 x
        go2(day + 1, sum);

    }


}
