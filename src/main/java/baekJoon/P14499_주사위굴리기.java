package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/14499
public class P14499_주사위굴리기 {

    /*
    [문제설명]
    크기가 N×M인 지도가 존재한다. 지도의 오른쪽은 동쪽, 위쪽은 북쪽이다.
    이 지도의 위에 주사위가 하나 놓여져 있으며, 주사위의 전개도는 아래와 같다.
    지도의 좌표는 (r, c)로 나타내며, r는 북쪽으로부터 떨어진 칸의 개수, c는 서쪽으로부터 떨어진 칸의 개수이다.

      2
    4 1 3
      5
      6
    주사위는 지도 위에 윗 면이 1이고, 동쪽을 바라보는 방향이 3인 상태로 놓여져 있으며, 놓여져 있는 곳의 좌표는 (x, y) 이다.
    가장 처음에 주사위에는 모든 면에 0이 적혀져 있다.

    지도의 각 칸에는 정수가 하나씩 쓰여져 있다.
    주사위를 굴렸을 때, 이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다.
    0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 된다.

    주사위를 놓은 곳의 좌표와 이동시키는 명령이 주어졌을 때, 주사위가 이동했을 때 마다 상단에 쓰여 있는 값을 구하는 프로그램을 작성하시오.

    주사위는 지도의 바깥으로 이동시킬 수 없다. 만약 바깥으로 이동시키려고 하는 경우에는 해당 명령을 무시해야 하며, 출력도 하면 안 된다.

    [시간제한]
    2 초

    [메모리 제한]
    512 MB

    [입력]
    첫째 줄에 지도의 세로 크기 N, 가로 크기 M (1 ≤ N, M ≤ 20), 주사위를 놓은 곳의 좌표 x y(0 ≤ x ≤ N-1, 0 ≤ y ≤ M-1), 그리고 명령의 개수 K (1 ≤ K ≤ 1,000)가 주어진다.

    둘째 줄부터 N개의 줄에 지도에 쓰여 있는 수가 북쪽부터 남쪽으로, 각 줄은 서쪽부터 동쪽 순서대로 주어진다. 주사위를 놓은 칸에 쓰여 있는 수는 항상 0이다. 지도의 각 칸에 쓰여 있는 수는 10을 넘지 않는 자연수 또는 0이다.

    마지막 줄에는 이동하는 명령이 순서대로 주어진다. 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4로 주어진다.

    [출력]
    이동할 때마다 주사위의 윗 면에 쓰여 있는 수를 출력한다. 만약 바깥으로 이동시키려고 하는 경우에는 해당 명령을 무시해야 하며, 출력도 하면 안 된다.

     */

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int k = sc.nextInt();

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int[] dice = new int[6];
        //1,2,3,4 인덱스에 해당하는 값이 각각 동,서,북,남
        int[] dx = {0,0,0,-1,1};
        int[] dy = {0,1,-1,0,0};

        while (k-- > 0) {
            int direction = sc.nextInt();
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                x = nx;
                y = ny;
                moveDice(dice, direction);
                if (map[nx][ny] == 0) {
                    map[nx][ny] = dice[5];
                } else {
                    dice[5] = map[nx][ny];
                    map[nx][ny] = 0;
                }
                System.out.println(dice[0]);
            }


        }

    }

    //방향별로 주사위의 값을 옮기는 전략을 취한다. (이게 더 쉬움)
    static void moveDice(int[] dice, int direction) {

        switch (direction) {
            case 1:
                int temp = dice[0];
                dice[0] = dice[3];
                dice[3] = dice[5];
                dice[5] = dice[2];
                dice[2] = temp;
                break;
            case 2:
                int temp2 = dice[0];
                dice[0] = dice[2];
                dice[2] = dice[5];
                dice[5] = dice[3];
                dice[3] = temp2;
                break;
            case 3:
                int temp3 = dice[0];
                dice[0] = dice[4];
                dice[4] = dice[5];
                dice[5] = dice[1];
                dice[1] = temp3;
                break;
            case 4:
                int temp4 = dice[0];
                dice[0] = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[4];
                dice[4] = temp4;
                break;
        }
    }




}