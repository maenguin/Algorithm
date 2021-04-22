package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/18290
public class P18290_NM과K_1 {

    /*
    [문제설명]
    크기가 N×M인 격자판의 각 칸에 정수가 하나씩 들어있다.
    이 격자판에서 칸 K개를 선택할 것이고, 선택한 칸에 들어있는 수를 모두 더한 값의 최댓값을 구하려고 한다.
    단, 선택한 두 칸이 인접하면 안된다.
    r행 c열에 있는 칸을 (r, c)라고 했을 때, (r-1, c), (r+1, c), (r, c-1), (r, c+1)에 있는 칸이 인접한 칸이다.

    [시간제한]
    2 초

    [입력]
    첫째 줄에 N, M, K가 주어진다. 둘째 줄부터 N개의 줄에 격자판에 들어있는 수가 주어진다.

    [출력]
    선택한 칸에 들어있는 수를 모두 더한 값의 최댓값을 출력한다.

    [제한]
    1 ≤ N, M ≤ 10
    1 ≤ K ≤ min(4, N×M)
    격자판에 들어있는 수는 -10,000보다 크거나 같고, 10,000보다 작거나 같은 정수이다.
    항상 K개의 칸을 선택할 수 있는 경우만 입력으로 주어진다.
     */


    
    static int n;
    static int m;
    static int k;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        board = new int[n][m];
        visited  = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        go(0, 0);
        System.out.println(ans);
    }

    //N과M(1)을 2차원으로 확장시켰다고 생각하고 문제를 해결해보자
    //k를 선택할때까지 NM번을 계속 반복하기 때문에 비효율적
    //O(NM^k)
    public static void go(int selectedCnt, int sum) {

        if (selectedCnt == k) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                
                if (visited[x][y]) continue;

                boolean isContiguous = false;
                for (int i = 0; i < 4; i++) {
                    int x1 = x + dx[i];
                    int y1 = y + dy[i];
                    if (0 <= x1 && x1 < n && 0 <= y1 && y1 < m) {
                        if (visited[x1][y1])
                            isContiguous = true;
                    }
                }
                if (isContiguous) continue;

                visited[x][y] = true;
                go(selectedCnt + 1, sum + board[x][y]);
                visited[x][y] = false;
            }
        }
    }

    //중복되는 작업을 피하기 위해 순열을 조합으로 만들어보자
    //N과M(2)를 이용한다.
    public static void go2(int selectedCnt, int sum, int startX, int startY) {

        if (selectedCnt == k) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int x = startX; x < n; x++) {
            for (int y = (x == startX ? startY : 0); y < m; y++) {

                if (visited[x][y]) continue;

                boolean isContiguous = false;
                for (int i = 0; i < 4; i++) {
                    int x1 = x + dx[i];
                    int y1 = y + dy[i];
                    if (0 <= x1 && x1 < n && 0 <= y1 && y1 < m) {
                        if (visited[x1][y1])
                            isContiguous = true;
                    }
                }
                if (isContiguous) continue;

                visited[x][y] = true;
                go2(selectedCnt + 1, sum + board[x][y], x, y);
                visited[x][y] = false;
            }
        }
    }

    //2차원 배열을 1차원이라고 생각하고 풀 수 도 있다.
    //(r,c)는 r*m+c로 나타낼 수 있다.
    public static void go3(int selectedCnt, int sum, int start) {

        if (selectedCnt == k) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = start; i < n*m; i++) {

            int y = i%m;
            int x = i/m;
            if (visited[x][y]) continue;

            boolean isContiguous = false;
            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (visited[nx][ny])
                        isContiguous = true;
                }
            }
            if (isContiguous) continue;

            visited[x][y] = true;
            go3(selectedCnt + 1, sum + board[x][y], i+1);
            visited[x][y] = false;
        }
    }
}
