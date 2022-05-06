package algospot;

import java.util.Arrays;
import java.util.Scanner;

//문제 출처 : https://algospot.com/judge/problem/read/ASYMTILING
//노션 링크 : https://delirious-sock-4dc.notion.site/ASYMTILING-fe3a712e090a45e6938a027b30731155
//알고 리즘 : DP
public class ASYMTILING_비대칭타일링 {

    private static final int MOD = 1_000_000_007;
    private static int n;
    private static int[] cache = new int[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        while (c-- > 0) {
            n = sc.nextInt();
            Arrays.fill(cache, -1);
            System.out.println(asymTiling(n));
        }
    }

    private static int asymTiling(int width) {
        if (width % 2 == 1) {
            return (tiling(width) - tiling(width/2) + MOD) % MOD;
        }
        int ret = (tiling(width) - tiling(width/2) + MOD) % MOD;
        return (ret - tiling(width/2 - 1) + MOD) % MOD;
    }

    //대칭 조건이 없는 경우 타일링 개수 구하기
    private static int tiling(int width) {
        if (width <= 1) return 1;
        if (cache[width] != -1) return cache[width];
        return cache[width] = (tiling(width - 1) + tiling(width - 2)) % MOD;
    }

}
