
package baekJoon;

import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/9625
//노션 링크 :
//알고 리즘 :
public class P9625_BABBA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int a = 1;
        int b = 0;
        for (int i = 0; i < k; i++) {
            int temp = b;
            b += a;
            a = temp;
        }
        System.out.printf("%d %d%n", a, b);
    }

}
