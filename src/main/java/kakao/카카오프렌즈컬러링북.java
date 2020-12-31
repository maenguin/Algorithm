package kakao;


import java.util.*;

//2017 카카오코드 예선
public class 카카오프렌즈컬러링북 {


    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int [][]pictureClone = new int[m][n];
        for (int x = 0; x < picture.length; x++) {
            for (int y = 0; y < picture[x].length; y++) {
                pictureClone[x][y] = picture[x][y];
            }
        }
        List<Area> areas = new ArrayList<>();
        Queue<Point> queue = new LinkedList<>();
        int curAreaColor = 0;
        int curAreaSize = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int color = pictureClone[i][j];
                if (color != 0) {
                    curAreaColor = color;
                    queue.offer(Point.of(i,j));
                    pictureClone[i][j] = 0;

                    while (!queue.isEmpty()) {
                        Point curPoint = queue.poll();
                        curAreaSize++;

                        boolean hasSameColorOnLeft = curPoint.y - 1 >= 0 && pictureClone[curPoint.x][curPoint.y - 1] == curAreaColor;
                        boolean hasSameColorOnRight = curPoint.y + 1 < n && pictureClone[curPoint.x][curPoint.y + 1] == curAreaColor;
                        boolean hasSameColorOnTop = curPoint.x - 1 >= 0 && pictureClone[curPoint.x - 1][curPoint.y] == curAreaColor;
                        boolean hasSameColorOnBottom = curPoint.x + 1 < m && pictureClone[curPoint.x + 1][curPoint.y] == curAreaColor;
                        if (hasSameColorOnLeft){
                            queue.offer(Point.of(curPoint.x, curPoint.y - 1));
                            pictureClone[curPoint.x][curPoint.y - 1] = 0;
                        }
                        if (hasSameColorOnRight){
                            queue.offer(Point.of(curPoint.x, curPoint.y + 1));
                            pictureClone[curPoint.x][curPoint.y + 1] = 0;
                        }
                        if (hasSameColorOnTop){
                            queue.offer(Point.of(curPoint.x - 1, curPoint.y));
                            pictureClone[curPoint.x - 1][curPoint.y] = 0;
                        }
                        if (hasSameColorOnBottom){
                            queue.offer(Point.of(curPoint.x + 1, curPoint.y));
                            pictureClone[curPoint.x + 1][curPoint.y] = 0;
                        }
                        System.out.println(queue);
                    }
                    areas.add(Area.of(curAreaColor,curAreaSize));
                    curAreaSize = 0;
                    curAreaColor = 0;

                }


            }
        }
        System.out.println(areas);
        numberOfArea = areas.size();
        maxSizeOfOneArea = areas.stream().max(Comparator.comparingInt(a -> a.size)).get().size;

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }


    public int[] solution2(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int [][]pictureClone = new int[m][n];
        for (int x = 0; x < picture.length; x++) {
            for (int y = 0; y < picture[x].length; y++) {
                pictureClone[x][y] = picture[x][y];
            }
        }
        int[] dx = { 0, 0, -1, 1};
        int[] dy = { 1, -1, 0, 0};

        List<Area> areas = new ArrayList<>();
        Queue<Point> queue = new LinkedList<>();
        int curAreaColor = 0;
        int curAreaSize = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int color = pictureClone[i][j];
                if (color != 0) {
                    curAreaColor = color;
                    queue.offer(Point.of(i,j));
                    pictureClone[i][j] = 0;

                    while (!queue.isEmpty()) {
                        Point curPoint = queue.poll();
                        curAreaSize++;

                        for (int k = 0; k < 4; k++) {
                            Point nextPoint = Point.of(curPoint.x + dx[k], curPoint.y + dy[k]);
                            if (nextPoint.x < 0 || nextPoint.x >= m || nextPoint.y < 0 || nextPoint.y >= n || pictureClone[nextPoint.x][nextPoint.y] != curAreaColor) {
                                continue;
                            }
                            queue.offer(nextPoint);
                            pictureClone[nextPoint.x][nextPoint.y] = 0;
                        }

                        System.out.println(queue);
                    }
                    areas.add(Area.of(curAreaColor,curAreaSize));
                    curAreaSize = 0;
                    curAreaColor = 0;

                }


            }
        }
        System.out.println(areas);
        numberOfArea = areas.size();
        maxSizeOfOneArea = areas.stream().max(Comparator.comparingInt(a -> a.size)).get().size;

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    static class Point{
        int x;
        int y;

        static Point of (int x, int y) {
            Point pt = new Point();
            pt.x = x;
            pt.y = y;
            return pt;
        }

        @Override
        public String toString() {
            return x+ " "+ y;
        }
    }

    static class Area{
        int color;
        int size;

        static Area of (int color, int size) {
            Area area = new Area();
            area.color = color;
            area.size = size;
            return area;
        }

        @Override
        public String toString() {
            return color+ " "+ size;
        }
    }

}
