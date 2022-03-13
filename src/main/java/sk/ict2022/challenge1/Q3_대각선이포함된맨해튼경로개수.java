package sk.ict2022.challenge1;

//문제 출처 :
//노션 링크 : https://delirious-sock-4dc.notion.site/e0cd242ca19f4857b205324691294e86
//문제 유형 : 다이나믹 프로그래밍
public class Q3_대각선이포함된맨해튼경로개수 {

    int mod = 10000019;

    public int solution(int width, int height, int[][] diagonals) {
        long answer = 0;
        long[][] dp = new long[height + 1][width + 1];
        manhattanRoute(dp, height, width);
        for (int[] diagonal : diagonals) {
            int startX = diagonal[1];
            int startY = diagonal[0] - 1;
            int endX = startX - 1;
            int endY = startY + 1;
            answer += dp[startX][startY] * dp[height - endX][width - endY];
            answer %= mod;
            answer += dp[endX][endY] * dp[height - startX][width - startY];
            answer %= mod;
        }
        return (int) answer;
    }

    private long manhattanRoute(long[][] dp, int height, int width) {
        if (dp[height][width] != 0) return dp[height][width];
        if (height == 0 || width == 0) return dp[height][width] = 1;
        return dp[height][width] = manhattanRoute(dp, height - 1, width) % mod + manhattanRoute(dp, height, width - 1) % mod;
    }

}
