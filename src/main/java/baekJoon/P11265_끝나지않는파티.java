package baekJoon;


import java.util.Scanner;

//문제 유형 : 최단거리
//알고리즘 : 플로이드 (응용 없음)
public class P11265_끝나지않는파티 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //파티장 크기
        int m = sc.nextInt(); //손님 수

        int[][] map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        floyd(map);

        while (m-- > 0) {
            int a = sc.nextInt(); //현재 위치
            int b = sc.nextInt(); //다음 위치
            int limitTime = sc.nextInt(); //걸리는 시간
            var shortestTime = map[a][b];
            if (shortestTime <= limitTime) {
                System.out.println("Enjoy other party");
            } else {
                System.out.println("Stay here");
            }

        }
    }

    private static void floyd(int[][] d) {
        for (int k = 1; k < d.length; k++) {
            for (int i = 1; i < d.length; i++) {
                for (int j = 1; j < d.length; j++) {
                    if (d[i][j] > d[i][k] + d[k][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }
    }

}
