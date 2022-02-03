package baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//문제 출처 : https://www.acmicpc.net/problem/10942
//노션 링크 : https://delirious-sock-4dc.notion.site/10942-399d7a7d58164997ab871c9baef7a7b7
//문제 유형 : DP
//풀이 방법 : DFS
public class P10942_팰린드롬 {

    private static int[] a;
    //dp[i][j] : i ~ j까지 수가 팰린드롬인 경우 1, 아니면 0
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = new int[n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            sb.append(isPalindromeDFS(s, e) ? 1 : 0).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isPalindromeDFS(int s, int e) {
        if (s >= e) {
            return true;
        }
        boolean result = false;
        if (a[s] == a[e]) {
            if (dp[s + 1][e - 1] != 0) return dp[s + 1][e - 1] == 1;
            result = isPalindromeDFS(s + 1, e - 1);
            dp[s][e] = result ? 1 : -1;
        }
        return result;
    }

}
