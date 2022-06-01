
package baekJoon;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/4485
//노션 링크 :
//알고 리즘 : 다익스트라
public class P4485_녹색옷입은애가젤다지 {

    private static int n;
    private static int[][] map = new int[125][125];
    private static int[][] distance = new int[125][125];
    private static int[] dr = {0, 1, 0, -1};
    private static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no = 1;
        while (true) {
            n = sc.nextInt();
            if (n == 0) return;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            for (int[] ints : distance) {
                Arrays.fill(ints, (int) 2e9);
            }
            System.out.printf("Problem %d: %d%n", no++, dijkstra());
        }
    }

    private static int dijkstra() {
        Queue<Vertex> queue = new PriorityQueue<>();
        distance[0][0] = map[0][0];
        queue.offer(new Vertex(0, 0, distance[0][0]));
        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            if (v.r == n - 1 && v.c == n - 1) return distance[v.r][v.c];
            if (distance[v.r][v.c] < v.distance) continue;
            for (int k = 0; k < 4; k++) {
                int nr = v.r + dr[k];
                int nc = v.c + dc[k];
                if (!(0 <= nr && nr < n && 0 <= nc && nc < n)) continue;
                if (distance[nr][nc] > v.distance + map[nr][nc]) {
                    distance[nr][nc] = v.distance + map[nr][nc];
                    queue.offer(new Vertex(nr, nc, distance[nr][nc]));
                }
            }
        }
        return -1;
    }

    static class Vertex implements Comparable<Vertex> {
        int r;
        int c;
        int distance;

        public Vertex(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.distance,o.distance);
        }
    }

}
