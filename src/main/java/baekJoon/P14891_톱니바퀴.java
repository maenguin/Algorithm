package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/14891
public class P14891_톱니바퀴 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] cogwheels = new int[4][8];

        for (int i = 0; i < 4; i++) {
            String next = sc.next();
            for (int j = 0; j < 8; j++) {
                cogwheels[i][j] = next.charAt(j) - '0';
            }
        }
        int k = sc.nextInt();
        while (k-- > 0) {
            int wheelNo = sc.nextInt() - 1;
            int direction = sc.nextInt();

            rotate(cogwheels[wheelNo], direction);

            //톱니바퀴의 회전은 4바퀴가 동시에 일어난다.
            //그래서 회전을 하지 않고 회전이 일어나는 톱니를 먼저 구한 후 후처리 하는 방법이 있고
            //순차적으로 톱니바퀴의 회전을 처리 하면서 이전 값을 구해서 하는 방법이 있다
            //아래 풀이는 후자를 이용
            //강의에서는 전자 이용

            //타겟 톱니바퀴 오른쪽으로 전파
            int direct1 = direction; //옆으로 갈때마다 돌리는 방향이 달라지므로 변수를 하나 둔다.
            for (int i = wheelNo + 1; i <= 3 ; i++) {
                direct1 *= -1;
                //이전 톱니바퀴가 이미 돌아가 있으므로 이전 톱니바퀴가 돌아간 방향을 기준으로 맞닿은 위치를 구한다.
                if (cogwheels[i - 1][2 + direct1*-1] == cogwheels[i][6]) {
                    break;
                }

                rotate(cogwheels[i], direct1);
            }
            //타겟 톱니바퀴 왼쪽으로 전파
            int direct2 = direction;
            for (int i = wheelNo - 1; i >= 0 ; i--) {
                direct2 *= -1;
                if (cogwheels[i + 1][6 + direct2*-1] == cogwheels[i][2]) {
                    break;
                }

                rotate(cogwheels[i], direct2);
            }

        }

        int answer = 0;
        for (int i = 0; i < cogwheels.length; i++) {
            answer += cogwheels[i][0] == 1 ? Math.pow(2,i) : 0;
        }
        System.out.println(answer);
    }

    //톱니가 8개 이므로 톱니바퀴 값을 옮기는 전략을 취하자
    public static void rotate(int[] cogwheel, int direction) {
        switch (direction) {
            //시계방향
            case 1:
                int temp = cogwheel[7];
                for (int i = 7; i >= 1 ; i++) {
                    cogwheel[i] = cogwheel[i-1];
                }
                cogwheel[0] = temp;
                break;
            //반시계방향
            case -1:
                int temp2 = cogwheel[0];
                for (int i = 0; i <= 6; i++) {
                    cogwheel[i] = cogwheel[i+1];
                }
                cogwheel[7] = temp2;
                break;
        }
    }

}
