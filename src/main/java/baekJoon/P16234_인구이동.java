package baekJoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/16234
//문제 유형 : 그래프 탐색
//알고리즘 : DFS, 연결요소
//특이사항 : 연결요소의 값의 합, 사이즈를 구하고 연결요소의 값을 재할당
//          연결요소끼리 영향을 끼치면 안됨
public class P16234_인구이동 {

    //N*N 크기의 땅
    //인접한 땅은 국경선이 존재
    //국경선을 공유하는 땅의 인구 차이가 L명 이상, R명 이하면 국경 오픈
    //국경이 오픈돼서 연결된 땅을 연합이라고 함
    //연합인 땅의 인구수는 (연합의 인구수 합)/연합의 땅 개수 가 된다.

    private static int L;
    private static int R;
    private static int N;
    private static int[][] map;
    private static int[] dr = {0, -1, 0, 1};
    private static int[] dc = {-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        L = scanner.nextInt();
        R = scanner.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        int answer = -1;
        ArrayList<Country> union = new ArrayList<>();
        boolean hasBorderLine;
        do {
            answer++;
            hasBorderLine = false;
            boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;
                    union(visited, union, i, j);
                    if (union.size() > 1) {
                        hasBorderLine = true;
                        movePop(union);
                    }
                    union.clear();
                }
            }
        } while (hasBorderLine);
        System.out.println(answer);
    }

    //union을 바탕으로 연합내의 인구이동을 수행한다.
    private static void movePop(ArrayList<Country> union) {
        int sum = union.stream().mapToInt(c -> c.pop).sum();
        int midPop = sum / union.size();
        for (Country country : union) {
            map[country.r][country.c] = midPop;
        }
    }

    //dfs로 연합을 구한다.
    //연합정보는 union에 담긴다.
    private static void union(boolean[][] visited, List<Country> union, int r, int c) {
        visited[r][c] = true;
        int curPop = map[r][c];
        Country e = new Country(r, c, curPop);
        union.add(e);
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (!(0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc])) {
                continue;
            }
            int nextPop = map[nr][nc];
            int popDiff = Math.abs(curPop - nextPop);
            if (L <= popDiff && popDiff <= R) {
                union(visited, union, nr, nc);
            }
        }

    }

    private static class Country {
        int r;
        int c;
        int pop;

        public Country(int r, int c, int pop) {
            this.r = r;
            this.c = c;
            this.pop = pop;
        }
    }


}
