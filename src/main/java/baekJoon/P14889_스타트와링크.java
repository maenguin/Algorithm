package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/14889
public class P14889_스타트와링크 {


    static int N ;
    static int R ;
    static int[][] S;
    static int ans = Integer.MAX_VALUE;
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



    //강의
    //배열말고 ArrayList를 사용했다.
    //백트래킹이 없는 완전한 브루트포스 버전
    public static void go2(int player, ArrayList<Integer> teamA, ArrayList<Integer> teamB) {

        //성공조건
        if (player == N) {
            //teamA와 teamB의 인원인 N/2명으로 균등하게 분배되어야한다.
            if (teamA.size() != N/2) return ;
            if (teamB.size() != N/2) return ;

            int statA = 0;
            int statB = 0;

            for (int i = 0; i < N / 2; i++) {
                for (int j = 0; j < N / 2; j++) {
                    if (i == j) continue;
                    statA += S[teamA.get(i)][teamA.get(j)];
                    statB += S[teamB.get(i)][teamB.get(j)];
                }
            }
            ans = Math.min(ans, Math.abs(statA - statB));
            return;
        }

        teamA.add(player);
        go2(player + 1, teamA, teamB);
        teamA.remove(teamA.size() - 1);

        teamB.add(player);
        go2(player + 1, teamA, teamB);
        teamB.remove(teamB.size() - 1);


    }

    //브루트포스에서 해봤자 불가능한 경우를 걸러내기 위한 종료조건을 추가해서 백트래킹으로
    public static void go3(int player, ArrayList<Integer> teamA, ArrayList<Integer> teamB) {

        if (player == N) {
            //teamA와 teamB의 인원인 N/2명으로 균등하게 분배되어야한다.
            int statA = 0;
            int statB = 0;

            for (int i = 0; i < N / 2; i++) {
                for (int j = 0; j < N / 2; j++) {
                    if (i == j) continue;
                    statA += S[teamA.get(i)][teamA.get(j)];
                    statB += S[teamB.get(i)][teamB.get(j)];
                }
            }
            ans = Math.min(ans, Math.abs(statA - statB));
            return;
        }

        if (teamA.size() > N/2 || teamB.size() > N/2 ) return;
        teamA.add(player);
        go2(player + 1, teamA, teamB);
        teamA.remove(teamA.size() - 1);

        teamB.add(player);
        go2(player + 1, teamA, teamB);
        teamB.remove(teamB.size() - 1);


    }




}