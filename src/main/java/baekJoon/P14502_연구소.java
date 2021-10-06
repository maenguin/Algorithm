package baekJoon;

import java.util.*;

//문제 유형 : 그래프 탐색, 브루트 포스
//알고리즘 :
public class P14502_연구소 {

    //N*M 공간, 0빈칸, 1벽, 2바이러스
    //바이러스는 상하좌우로 계속 퍼짐
    //벽을 꼭 3개를 세우고
    //바이러스가 퍼지지 않는 안전영역의 최댓값을 구해야한다.
    private static int n;
    private static int m;
    private static int answer = 0;
    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {-1, 0, 1, 0};
    private static int[][] map;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        selectWallPoint(0, 0, n*m, 3, new ArrayList<>());
        System.out.println(answer);
    }

    public static void selectWallPoint(int index, int selected, int n, int r, List<Point> wallPoints) {
        if (selected == r) {
            if (!canBuildWall(wallPoints)) {
                return;
            }
            buildWall(wallPoints);
            answer = Math.max(answer, getSafeAreaSize());
            destroyWall(wallPoints);
            return;
        }
        if (index >= n) return;
        wallPoints.add(new Point(index / m, index % m));
        selectWallPoint(index + 1, selected + 1, n, r, wallPoints);
        wallPoints.remove(wallPoints.size() - 1);
        selectWallPoint(index + 1, selected, n, r, wallPoints);
    }

    private static boolean canBuildWall(List<Point> wallPoints) {
        for (Point wallPoint : wallPoints) {
            if (map[wallPoint.x][wallPoint.y] == 2 || map[wallPoint.x][wallPoint.y] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void buildWall(List<Point> wallPoints) {
        for (Point wallPoint : wallPoints) {
            map[wallPoint.x][wallPoint.y] = 1;
        }
    }

    private static void destroyWall(List<Point> wallPoints) {
        for (Point wallPoint : wallPoints) {
            map[wallPoint.x][wallPoint.y] = 0;
        }
    }


    private static int getSafeAreaSize() {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int safeAreaSize = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int cell = map[i][j];
                if (visited[i][j] || cell == 1 || cell == 2) continue;

                int curAreaSize = 0;
                boolean containsVirus = false;

                queue.offer(new Point(i,j));
                visited[i][j] = true;
                curAreaSize++;
                while (!queue.isEmpty()) {
                    Point curPoint = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = curPoint.x + dx[k];
                        int ny = curPoint.y + dy[k];
                        if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                            int x = map[nx][ny];
                            if (x == 2) {
                                containsVirus = true;
                            }
                            if (!visited[nx][ny] && x != 2 && x != 1) {
                                queue.offer(new Point(nx, ny));
                                visited[nx][ny] = true;
                                curAreaSize++;
                            }
                        }
                    }
                }
                if (!containsVirus) {
                    safeAreaSize += curAreaSize;
                }
            }
        }
        return safeAreaSize;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
