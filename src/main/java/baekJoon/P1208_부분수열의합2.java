package baekJoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/1208
//노션 링크 : https://delirious-sock-4dc.notion.site/cd5ddc16920549aba706f968e43880b1
//문제 유형 : 이분 탐색, 중간에서 만나기
//풀이 방법 : 중간에서 만나기, 자료구조
public class P1208_부분수열의합2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        int left = 0;
        int right = N - 1;
        int mid = left + (right - left) / 2;
        Map<Integer, Integer> leftSums = getSumsMap(nums, left, mid);
        Map<Integer, Integer> rightSums = getSumsMap(nums, mid + 1, right);

        long answer = leftSums.getOrDefault(S, 0) + rightSums.getOrDefault(S, 0);
        for (Integer i : leftSums.keySet()) {
            if (rightSums.containsKey(S - i)) {
                answer += (long) leftSums.get(i) * rightSums.get(S - i);
            }
        }
        System.out.println(answer);
    }

    private static Map<Integer, Integer> getSumsMap(int[] nums, int start, int end) {
        int length = end - start + 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < (1 << length); i++) {
            int sum = 0;
            for (int j = 0; j < length; j++) {
                if ((i & 1 << j) != 0) {
                    sum += nums[start + j];
                }
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return map;
    }

}
