
package baekJoon;


import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/20436
//노션 링크 : https://delirious-sock-4dc.notion.site/20436-ZOAC3-29e0b0049b55473a9c3ce91b9110070f
//문제 유형 : 시뮬레이션, 구현
public class P20436_ZOAC3 {

    private static char[][] LEFT = {{'q', 'w', 'e', 'r', 't'}, {'a', 's', 'd', 'f', 'g'}, {'z', 'x', 'c', 'v'}};
    private static char[][] RIGHT = {{' ', 'y', 'u', 'i', 'o', 'p'}, {' ', 'h', 'j', 'k', 'l'}, {'b', 'n', 'm'}};

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        char sl = sc.next().charAt(0);
        char sr = sc.next().charAt(0);
        String str = sc.next();

        int[] slPos = getPos(sl);
        int[] srPos = getPos(sr);
        int answer = 0;
        for (char c : str.toCharArray()) {
            int[] pos = getPos(c);
            if (pos[2] == 0) {
                answer += Math.abs(slPos[0] - pos[0]) + Math.abs(slPos[1] - pos[1]) + 1;
                slPos = pos;
            } else {
                answer += Math.abs(srPos[0] - pos[0]) + Math.abs(srPos[1] - pos[1]) + 1;
                srPos = pos;
            }
        }
        System.out.println(answer);
    }

    private static int[] getPos(char target) {
        for (int i = 0; i < LEFT.length; i++) {
            for (int j = 0; j < LEFT[i].length; j++) {
                if (LEFT[i][j] == target) return new int[]{i, j, 0};
            }
        }
        for (int i = 0; i < RIGHT.length; i++) {
            for (int j = 0; j < RIGHT[i].length; j++) {
                if (RIGHT[i][j] == target) return new int[]{i, j, 1};
            }
        }
        return new int[0];
    }

}
