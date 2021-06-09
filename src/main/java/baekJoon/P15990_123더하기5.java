package baekJoon;

import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/15990
public class P15990_123더하기5 {

    /*
    [문제설명]
    정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 3가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다. 단, 같은 수를 두 번 이상 연속해서 사용하면 안 된다.
    1+2+1
    1+3
    3+1
    정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

    [시간제한]
    1 초 (추가 시간 없음)

    [입력]
    첫째 줄에 테스트 케이스의 개수 T가 주어진다.
    각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 100,000보다 작거나 같다.

    [출력]
    각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 1,000,000,009로 나눈 나머지를 출력한다.
     */

    //연속 제한 조건을 충족시키기 위한 점화식을 세워야한다.
    //d[i][j] = i를 1,2,3의 합으로 나타내는 방법의 수, 마지막에 사용한 수는 j라고 하면
    //1로 끝나는 i는 d[i][1]고 i-1일때 2와 3으로 끝나야한다.
    //2로 끝나는 i는 d[i][2]고 i-2일때 1과 3으로 끝나야한다.
    //3로 끝나는 i는 d[i][3]고 i-3일때 1과 2로 끝나야한다.
    //즉 점화식은 d[n][1] + d[n][2] + d[n][3] = d[n-1][2] + d[n-1][3] + d[n-2][1] + d[n-2][3] + d[n-3][1] + d[n-3][2]
    //초기화할떄 d[0]은 초기화 하면 안된다. d[0][1]은 1로 끝나는 0인데 불가능하기 때문


    static final long mod = 1000000009L;
   public static void main(String[] args) throws IOException {
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

       int MAX = 100000;
       long[][] d = new long[MAX+1][4];
       d[1][1] = 1;
       d[2][2] = 1;
       d[3][3] = 1;
       d[3][2] = 1;
       d[3][1] = 1;

       for (int i = 4; i <= MAX; i++) {
           d[i][1] = (d[i-1][2] + d[i-1][3])%mod;
           d[i][2] = (d[i-2][3] + d[i-2][1])%mod;
           d[i][3] = (d[i-3][1] + d[i-3][2])%mod;
       }

        int t = Integer.parseInt(bf.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bf.readLine());
            bw.write(((d[n][1]+d[n][2]+d[n][3])%mod)+"\n");
        }

       bw.flush();
    }




}
