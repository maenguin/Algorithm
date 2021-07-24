
package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/14890
//코드 플러스 - 코딩 테스트 준비 - 기초 - 시뮬레이션과 구현
public class P14890_경사로 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        //가로 검사
        for (int i = 0; i < n; i++) {
            int preNum = 0;
            int conCnt = 0;
            for (int j = 0; j < n; j++) {
                int curNum = map[i][j];

                if (preNum == curNum) {
                    conCnt++;

                } else {

                    //높이차가 2 이상이면 안됨
                    if (Math.abs(curNum - preNum) > 1) {
                        break;
                    }
                    if (curNum > preNum && conCnt < l) {
                        break;
                    }
                    if (curNum < preNum) {
                        if (j + l >= n) {
                            break;
                        }

                        boolean result = hasConsecutiveNum(map[i], curNum, j, j + l);
                        if (result) {
                            j += l - 1;
                        } else {
                            break;
                        }
                    }

                    conCnt = 1;
                }
                preNum = curNum;
            }
        }

        //세로 검사
        for (int j = 0; j < n; j++) {
            int preNum = 0;
            int conCnt = 0;
            for (int i = 0; i < n; i++) {
                int curNum = map[i][j];

                if (preNum == curNum) {
                    conCnt++;

                } else {

                    //높이차가 2 이상이면 안됨
                    if (Math.abs(curNum - preNum) > 1) {
                        break;
                    }
                    if (curNum > preNum && conCnt < l) {
                        break;
                    }
                    if (curNum < preNum) {
                        if (i + l >= n) {
                            break;
                        }

                        boolean result = hasConsecutiveNum(map[i], curNum, i, i + l);
                        if (result) {
                            i += l - 1;
                        } else {
                            break;
                        }
                    }

                    conCnt = 1;
                }
                preNum = curNum;
            }
        }
    }

    public static boolean hasConsecutiveNum(int[] a, int num, int start, int end) {
        for (int i = start; i < end; i++) {
            if (a[i] != num) {
                return false;
            }
        }
        return true;
    }



}
