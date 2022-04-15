package baekJoon;

import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/14501
//노션 링크 : https://delirious-sock-4dc.notion.site/50a667e0e23c401db4382e282a45f4b3
//알고 리즘 :
public class P14501_퇴사_Re {


    private static int N;
    private static int[] T;
    private static int[] P;
    private static int[] cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        T = new int[N];
        P = new int[N];
        for (int i = 0; i < N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        cache = new int[N];
        System.out.println(counsel(0));
    }

    private static int counsel(int day) {
        if (day >= N) return 0;
        if (cache[day] != 0) return cache[day];
        int doCounsel = 0;
        if (day + T[day] <= N) {
            doCounsel = counsel(day + T[day]) + P[day];
        }
        int doNotCounsel = counsel(day + 1);
        return cache[day] = Math.max(doCounsel, doNotCounsel);
    }


}
