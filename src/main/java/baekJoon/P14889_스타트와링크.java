package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/14889
public class P14889_스타트와링크 {


    static int N ;
    static int R ;
    static int[][] S;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = N/2;
        S = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                S[i][j] = sc.nextInt();
            }
        }
        go(0, 0);
        System.out.println(ans);
    }

    //단순하게 생각한 풀이
    //1. N명 중에 N/2명을 뽑는다.
    //2. 뽑은 N/2명을 A 나머지를 B라고 하고
    //3. A와 B에서 2개씩 뽑아 점수를 더한다.
    //4. 차이를 산출한다.
    static int[] TeamA = new int[10];
    static int[] TeamB = new int[10];
    static int ans = Integer.MAX_VALUE;
    public static void go(int select, int player){
        if (select == N/2) {
            int b = 0;
            for (int i = 0; i < N; i++) {
                boolean isTeamA = false;
                for (int j = 0; j < N / 2; j++) {
                    if (TeamA[j] == i){
                        isTeamA = true;
                        break;
                    }
                }
                if (!isTeamA) {
                    TeamB[b++] = i;
                }
            }
            ans = Math.min( Math.abs( calcStats(TeamA) - calcStats(TeamB)), ans);


            return;
        }
        if (player >= N){
            return;
        }
        TeamA[select] = player;
        go(select+1, player+1);
        go(select, player+1);
    }

    public static int calcStats(int[] team){
        int stat = 0;
        for (int i = 0; i < N / 2 - 1; i++) {
            for (int j = i + 1; j < N/2; j++) {
                stat += S[team[i]][team[j]];
                stat += S[team[j]][team[i]];
            }
        }
        return stat;
    }




}