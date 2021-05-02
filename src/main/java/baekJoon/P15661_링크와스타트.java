package baekJoon;
import java.util.*;

//https://www.acmicpc.net/problem/15661
public class P15661_링크와스타트 {


    static int N ;
    static int[][] S;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                S[i][j] = sc.nextInt();
            }
        }
        ArrayList<Integer> teamA = new ArrayList<>();
        ArrayList<Integer> teamB = new ArrayList<>();
        go(0, teamA, teamB);
        System.out.println(ans);
    }

    //14889 스타트와링크 문제에서 인원을 균등분배한다는 조건이 삭제된 문제
    public static void go(int player, ArrayList<Integer> teamA, ArrayList<Integer> teamB) {

        if (player == N) {
            if (teamA.size() < 1) return;
            if (teamB.size() < 1) return;
            ans = Math.min(ans, Math.abs(calcStat(teamA) - calcStat(teamB)));
            return;
        }

        teamA.add(player);
        go(player + 1, teamA, teamB);
        teamA.remove(teamA.size() - 1);

        teamB.add(player);
        go(player + 1, teamA, teamB);
        teamB.remove(teamB.size() - 1);
    }

    public static int calcStat(ArrayList<Integer> team) {
        int stat = 0;
        for (int i = 0; i < team.size(); i++) {
            for (int j = 0; j < team.size(); j++) {
                if (i == j) continue;
                stat += S[team.get(i)][team.get(j)];
            }
        }
        return stat;
    }




}
