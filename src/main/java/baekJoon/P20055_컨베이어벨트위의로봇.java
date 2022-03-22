
package baekJoon;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/20055
//노션 링크 : https://delirious-sock-4dc.notion.site/20055-734b36dc7cf94d13988be92559fa3ec0
//문제 유형 : 시뮬레이션, 구현
public class P20055_컨베이어벨트위의로봇 {

    private static int N;
    private static int K;
    private static int BELT_LENGTH;
    private static int[] As;
    private static int upPos;
    private static int downPos;
    private static List<Robot> robots;

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        BELT_LENGTH = 2 * N;
        As = new int[BELT_LENGTH];
        for (int i = 0; i < BELT_LENGTH; i++) {
            As[i] = sc.nextInt();
        }
        upPos = 0;
        downPos = N - 1;
        robots = new ArrayList<>();
        int answer = 1;
        while (true) {
            process1();
            process2();
            process3();
            if (process4()) {
                System.out.println(answer);
                return;
            }
            answer++;
        }
    }

    private static void process1() {
        upPos = getPrevPos(upPos);
        downPos = getPrevPos(downPos);
        checkDownRobot();
    }

    private static void process2() {
        for (Robot robot : robots) {
            int nextPos = getNextPos(robot.pos);
            if (As[nextPos] > 0 && !existsRobot(nextPos)) {
                robot.pos = nextPos;
                As[nextPos]--;
            }
        }
        checkDownRobot();
    }

    private static void process3() {
        if (As[upPos] > 0 && !existsRobot(upPos)) {
            robots.add(new Robot(upPos));
            As[upPos]--;
        }
    }

    private static boolean process4() {
        int count = 0;
        for (int a : As) {
            if (a == 0) count++;
        }
        return count >= K;
    }

    private static void checkDownRobot() {
        robots.removeIf(robot -> robot.pos == downPos);
    }

    private static boolean existsRobot(int pos) {
        boolean existsNext = false;
        for (Robot maybeNextRobot : robots) {
            if (pos == maybeNextRobot.pos) {
                existsNext = true;
                break;
            }
        }
        return existsNext;
    }

    private static int getNextPos(int curPos) {
        return (curPos + 1) % BELT_LENGTH;
    }

    private static int getPrevPos(int curPos) {
        return (curPos - 1 + BELT_LENGTH) % BELT_LENGTH;
    }

    private static class Robot {
        int pos;

        public Robot(int pos) {
            this.pos = pos;
        }
    }

}
