
package baekJoon;

import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/12865
//노션 링크 : https://delirious-sock-4dc.notion.site/12865-48809bf0c18243f490c011e37d6720a9
//알고 리즘 : DP
public class P12865_평범한배낭 {

    private static int N;
    private static int K;
    private static int[][] items;
    private static int[][] cache = new int[101][100_001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        items = new int[N][2];
        for (int i = 0; i < N; i++) {
            items[i][0] = sc.nextInt();
            items[i][1] = sc.nextInt();
        }
        System.out.println(packUp(0, 0));
    }

    private static int packUp(int n, int k) {
        if (n >= N) return 0;
        if (cache[n][k] != 0) return cache[n][k];
        int w1 = 0;
        if (k + items[n][0] <= K) {
            w1 = packUp(n + 1, k + items[n][0]) + items[n][1];
        }
        int w2 = packUp(n + 1, k);
        return cache[n][k] = Math.max(w1, w2);
    }


}
