
package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/14391
public class P14391_종이조각 {

    /*
    [문제설명]
    링크참조

    [시간제한]
    2 초

    [메모리 제한]
    256 MB

    [입력]
    첫째 줄에 종이 조각의 세로 크기 N과 가로 크기 M이 주어진다. (1 ≤ N, M ≤ 4)
    둘째 줄부터 종이 조각이 주어진다. 각 칸에 쓰여 있는 숫자는 0부터 9까지 중 하나이다.

    [출력]
    영선이가 얻을 수 있는 점수의 최댓값을 출력한다.

     */


    //가로나 세로의 최대자리수로 만들면 최대값이지만 0이 있다면 반례가 있을 수 있기 때문에 BF를 사용한다.
    //가로를 0 세로를 1이라고 하고 경우의 수를 모두 찾는다.
    //N*M 이 int 자릿수보다 작으므로 비트마스크를 이용한다.
    //0000 처럼 가로가 연속된 경우 분리여부를 판단해야되는데 문제에서 최댓값을 구해야 하므로 분리 하지 않는다.
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.next();
        }

        int ans = 0;


        for (int i = 0; i < (1 << (n * m)); i++) {
            int sum = 0;

            for (int j = 0; j < n; j++) {
                int hrSum = 0;
                for (int k = 0; k < m; k++) {
                    int l = k + j*m;
                    if ((i & (1<<l)) == 0){
                        hrSum *= 10;
                        hrSum += a[j].charAt(k) - '0';
                    } else {
                        sum += hrSum;
                        hrSum = 0;
                    }

                }
                sum += hrSum;
            }

            for (int j = 0; j < m; j++) {
                int verSum = 0;
                for (int k = 0; k < n; k++) {
                    int l = j + k*m;
                    if ((i & (1<<l)) != 0){
                        verSum *= 10;
                        verSum += a[k].charAt(j) - '0';
                    } else {
                        sum += verSum;
                        verSum = 0;
                    }

                }
                sum += verSum;
            }

            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }


}
