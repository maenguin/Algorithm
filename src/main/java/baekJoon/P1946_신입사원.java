package baekJoon;

import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/1946
//노션 링크 : https://delirious-sock-4dc.notion.site/1946-15b92fcc6de04ed3a687b7ddcbb50b5e
//알고 리즘 : 그리디
public class P1946_신입사원 {

    private static int[] interviewRanks = new int[100_001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                interviewRanks[sc.nextInt()] = sc.nextInt();
            }
            int answer = 1;
            int minInterviewRank = interviewRanks[1];
            for (int i = 2; i <= n; i++) {
                int curInterviewRank = interviewRanks[i];
                if (curInterviewRank < minInterviewRank) {
                    answer++;
                    minInterviewRank = curInterviewRank;
                }
            }
            System.out.println(answer);
        }
    }

}
