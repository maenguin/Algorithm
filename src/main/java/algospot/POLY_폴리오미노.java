package algospot;

import java.util.Arrays;
import java.util.Scanner;

//문제 출처 : https://algospot.com/judge/problem/read/SNAIL
//노션 링크 : https://delirious-sock-4dc.notion.site/POLY-a4e01cb30ebe4a109d5b4b3420873c2d
//알고 리즘 : DP
public class POLY_폴리오미노 {

    private static final int MOD = 10_000_000;
    private static int n;
    private static int[][] cache = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        while (c-- > 0) {
            n = sc.nextInt();
            for (int[] ints : cache) {
                Arrays.fill(ints, -1);
            }
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += poly(n, i);
            }
            System.out.println(sum);
        }
    }
    //현재 블록이 block개 있고 첫번째 줄의 블록 수가 first 일때 세로 단조 폴리오미노의 개수
    private static int poly(int block, int first) {
        if (block - first == 0) return 1;
        if (cache[block][first] != -1) return cache[block][first];
        int sum = 0;
        for (int second = 1; second <= block - first; second++) {
            int add = first + second - 1;
            add *= poly(block - first, second);
            sum += add;
        }
        return cache[block][first] = sum;
    }


}
