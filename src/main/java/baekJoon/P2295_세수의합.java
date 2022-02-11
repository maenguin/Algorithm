package baekJoon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//문제 출처 : https://www.acmicpc.net/problem/2295
//노션 링크 : https://delirious-sock-4dc.notion.site/2295-15edf7f48e2c411599350aca6565c444
//문제 유형 : 이분탐색, 중간에서 만나기
public class P2295_세수의합 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                set.add(nums[i] + nums[j]);
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (set.contains(nums[i] - nums[j])) {
                    System.out.println(nums[i]);
                    return;
                }
            }
        }
    }

}
