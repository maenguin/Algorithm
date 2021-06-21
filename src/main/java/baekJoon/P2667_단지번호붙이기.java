
package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/2667
public class P2667_단지번호붙이기 {


    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            char[] chars = sc.next().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = chars[j] - '0';
            }
        }

        List<Integer> list = new ArrayList<>();
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int m = map[i][j];
                if (m == 0) continue;
                int cnt = 0;

                queue.offer(new Point(i,j));
                map[i][j] = 0;
                cnt++;

                while (!queue.isEmpty()) {
                    Point pt = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = pt.x + dx[k];
                        int ny = pt.y + dy[k];

                        if (0 <= nx && nx < n && 0 <= ny && ny < n && map[nx][ny] == 1) {
                            queue.offer(new Point(nx, ny));
                            map[nx][ny] = 0;
                            cnt++;
                        }
                    }
                }
                list.add(cnt);
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (Integer e : list) {
            System.out.println(e);
        }

    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }



    /*
    class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};
    public static void bfs(int[][] a, int[][] group, int x, int y, int cnt, int n) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(x, y));
        group[x][y] = cnt;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            x = p.x;
            y = p.y;
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (a[nx][ny] == 1 && group[nx][ny] == 0) {
                        q.add(new Pair(nx, ny));
                        group[nx][ny] = cnt;
                    }
                }
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] a = new int[n][n];
        for (int i=0; i<n; i++) {
            String s = sc.nextLine();
            for (int j=0; j<n; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        int cnt = 0;
        int[][] group = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (a[i][j] == 1 && group[i][j] == 0) {
                    bfs(a, group, i, j, ++cnt, n);
                }
            }
        }
        int[] ans = new int[cnt];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (group[i][j] != 0) {
                    ans[group[i][j]-1]+=1;
                }
            }
        }
        Arrays.sort(ans);
        System.out.println(cnt);
        for (int i=0; i<cnt; i++) {
            System.out.println(ans[i]);
        }
    }
     */
}
