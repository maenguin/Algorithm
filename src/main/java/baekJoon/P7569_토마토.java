
package baekJoon;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

//문제 출처 : https://www.acmicpc.net/problem/7569
//노션 링크 : https://delirious-sock-4dc.notion.site/7569-44d548fec6f34d90bc143e262aacbddc
//문제 유형 : 최단거리, 그래프 탐색
public class P7569_토마토 {

    private static int M;
    private static int N;
    private static int H;

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();
        int[][][] tomatoBox = new int[H][N][M];
        for3((i, j, k) -> tomatoBox[i][j][k] = sc.nextInt());
        int answer = bfs(tomatoBox);
        System.out.println(allTomatoesIsDone(tomatoBox) ? answer : -1);
    }

    private static int bfs(int[][][] tomatoBox) {
        int result = 0;
        Queue<Location> queue = new LinkedList<>();
        for3((i, j, k) -> { if (tomatoBox[i][j][k] == 1) queue.offer(new Location(i, j, k)); });
        int[][] dxyzs = {{0, -1, 0}, {-1, 0, 0}, {0, 1, 0}, {1, 0, 0}, {0, 0, -1}, {0, 0, 1}};

        while (!queue.isEmpty()) {
            Location lt = queue.poll();
            result = Math.max(result, tomatoBox[lt.z][lt.y][lt.x]);
            for (int[] dxyz : dxyzs) {
                int nx = lt.x + dxyz[0];
                int ny = lt.y + dxyz[1];
                int nz = lt.z + dxyz[2];
                if (!(0 <= nx && nx < M && 0 <= ny && ny < N && 0 <= nz && nz < H)) continue;
                if (tomatoBox[nz][ny][nx] == 0) {
                    queue.offer(new Location(nz, ny, nx));
                    tomatoBox[nz][ny][nx] = tomatoBox[lt.z][lt.y][lt.x] + 1;
                }
            }
        }
        return result - 1;
    }

    private static boolean allTomatoesIsDone(int[][][] tomatoBox) {
        AtomicBoolean allDone = new AtomicBoolean(true);
        for3((i, j, k) -> { if (tomatoBox[i][j][k] == 0) allDone.set(false); });
        return allDone.get();
    }

    private static void for3(TriConsumer<Integer, Integer, Integer> consumer) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    consumer.accept(i, j, k);
                }
            }
        }
    }

    private static class Location {
        int z;
        int y;
        int x;

        public Location(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

    @FunctionalInterface
    public interface TriConsumer<T, U, S> {
        void accept(T t, U u, S s);
    }

}
