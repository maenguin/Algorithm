
package baekJoon;

import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/1459
//노션 링크 :
//알고 리즘 : 그리디
public class P1459_걷기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextInt();
        long y = scanner.nextInt();
        long w = scanner.nextInt();
        long s = scanner.nextInt();
        long min = Math.min(x, y);
        long diff = Math.max(x, y) - min;
        long left = diff % 2;
        if (w > s) {
            System.out.println(min * s + (diff - left) * s + left * w);
        } else if (w * 2 < s) {
            System.out.println((x + y) * w);
        } else {
            System.out.println(min * s + diff * w);
        }
    }

}
