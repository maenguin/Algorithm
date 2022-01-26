package kakao.blind2022;

//문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/92344
//노션 링크 : https://delirious-sock-4dc.notion.site/a1a7f519e2814707a2617ca1fb5589ea
//문제 유형 : 수학
//풀이 방법 : 누적합
public class 파괴되지않은건물 {

    public int solution(int[][] board, int[][] skills) {
        int answer = 0;
        for (int[] skill : skills) {
            doSkill(board, skill);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0) answer++;
            }
        }
        return answer;
    }

    private void doSkill(int[][] board, int[] skill) {
        int type = skill[0];
        int r1 = skill[1];
        int c1 = skill[2];
        int r2 = skill[3];
        int c2 = skill[4];
        int degree = skill[5];
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                board[i][j] += type == 1 ? -degree : degree;
            }
        }
    }

    ///위처럼 구하면 시간초과 발생.. 누적합을 이용해야 한다!

    public int solution2(int[][] board, int[][] skills) {
        int answer = 0;
        int[][] accumulateSum = getAccumulateSum(board.length, board[0].length, skills);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] + accumulateSum[i][j] > 0) answer++;
            }
        }
        return answer;
    }

    private int[][] getAccumulateSum(int n, int m, int[][] skills) {
        int[][] sum = new int[n][m];
        //(x1,y1)부터 (x2,y2)까지 n만큼의 변화는 (x1,y1)에 +n, (x1,y2+1)에 -n, (x2+1,y1)에 -n, (x2+1,y2+1)에 +n을 한 것과 같다.
        for (int[] skill : skills) {
            int type = skill[0];
            int r1 = skill[1];
            int c1 = skill[2];
            int r2 = skill[3];
            int c2 = skill[4];
            int degree = type == 1 ? -skill[5] : skill[5];
            sum[r1][c1] += degree;
            if (r2 + 1 < n) sum[r2 + 1][c1] -= degree;
            if (c2 + 1 < m) sum[r1][c2 + 1] -= degree;
            if (r2 + 1 < n && c2 + 1 < m) sum[r2 + 1][c2 + 1] += degree;
        }
        //그 후 위에서 아래로 누적합한 뒤, 왼쪽에서 오른쪽으로 누적합하거나 왼쪽에서 오른쪽으로 누적합 한 뒤, 위에서 아래로 누적합
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                sum[i][j] += sum[i][j - 1];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum[i][j] += sum[i - 1][j];
            }
        }
        return sum;
    }
}
