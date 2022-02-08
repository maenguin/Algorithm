package baekJoon;

import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/15684
//노션 링크 : https://delirious-sock-4dc.notion.site/0d74fa62346243f58670e9febefb6ecf
//문제 유형 : 브루트포스, 백트래킹
//풀이 방법 : 조합, DFS
public class P15684_사다리조작 {

    private static int[][] ladders;
    private static int n;
    private static int h;
    private static int answer = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //세로선의 개수
        int m = sc.nextInt(); //가로선의 개수
        h = sc.nextInt(); //세로선마다 가로선을 놓을 수 있는 위치의 개수
        ladders = new int[h][n]; //사다리 정보
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            ladders[a][b] = 1;
            ladders[a][b + 1] = -1;
        }
        if (isOk()) {
            System.out.println(0);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            combination(i, 0, 0);
            if (answer != -1) break;
        }
        System.out.println(answer);
    }

    private static void combination(int r, int depth, int start) {
        if (depth == r) {
            if (isOk()) answer = r;
            return;
        }
        for (int i = start; i < h * (n - 1); i++) {
            int x = i / (n - 1);
            int y = i % (n - 1);
            if (Math.abs(ladders[x][y]) == 1 || Math.abs(ladders[x][y + 1]) == 1) continue;
            ladders[x][y] = 1;
            ladders[x][y + 1] = -1;
            combination(r, depth + 1, i);
            ladders[x][y] = 0;
            ladders[x][y + 1] = 0;
        }
    }

    private static boolean isOk() {
        for (int i = 0; i < n; i++) {
            if (ghostLeg(0, i, true) != i) return false;
        }
        return true;
    }

    private static int ghostLeg(int x, int y, boolean down) {
        if (x == h) return y;
        int ladder = ladders[x][y];
        if (ladder != 0 && down) return ghostLeg(x, y + ladder, false);
        return ghostLeg(x + 1, y, true);
    }

}
