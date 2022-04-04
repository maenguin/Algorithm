
package baekJoon;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/2143
//노션 링크 : https://delirious-sock-4dc.notion.site/2143-f2e4a5ca9b79420caf2c128807ed3f0d
//문제 유형 : 누적합
public class P2143_두배열의합 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();
        long[] As = new long[n + 1];
        for (int i = 1; i < As.length; i++) {
            As[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        long[] Bs = new long[m + 1];
        for (int i = 1; i < Bs.length; i++) {
            Bs[i] = sc.nextInt();
        }

        initAccumulateSum(As);
        initAccumulateSum(Bs);
        Map<Long, Long> pairA = createSumAndCountPairs(As);
        Map<Long, Long> pairB = createSumAndCountPairs(Bs);

        long answer = 0;
        for (Long a : pairA.keySet()) {
            if (!pairB.containsKey(t - a)) continue;
            answer += pairA.get(a) * pairB.get(t - a);
        }
        System.out.println(answer);
    }

    private static void initAccumulateSum(long[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
    }

    private static long getSumBetween(long[] nums, int i, int j) {
        return nums[j] - nums[i - 1];
    }

    private static Map<Long, Long> createSumAndCountPairs(long[] nums) {
        Map<Long, Long> map = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                long sum = getSumBetween(nums, i, j);
                map.put(sum, map.getOrDefault(sum, 0L) + 1);
            }
        }
        return map;
    }

}
