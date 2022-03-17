
package baekJoon;


import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/1182
//노션 링크 : https://delirious-sock-4dc.notion.site/1182-91b673022c3e441ba918c7a4f9f7482e
//문제 유형 : 브루트포스, 백트래킹
public class P1182_부분수열의합_Re {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        solutionWithBitMask(nums, s);
        solutionWithCombination1(nums, s);
        solutionWithCombination2(nums, s);
    }

    //비트마스크로 부분 집합 구하기
    private static void solutionWithBitMask(int[] nums, int s) {
        int answer = 0;
        for (int i = 1; i < (1 << nums.length); i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += nums[j];
                }
            }
            if (sum == s) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    //조합으로 부분 집합 구하기1
    private static void solutionWithCombination1(int[] nums, int s) {
        int answer = 0;
        for (int i = 1; i <= nums.length; i++) {
            answer += combination1(nums, s, i, 0, 0, 0);
        }
        System.out.println(answer);
    }

    private static int combination1(int[] nums, int s, int r, int index, int sum, int selected) {
        if (selected == r) {
            return sum == s ? 1 : 0;
        }
        if (index >= nums.length) return 0;
        int count = 0;
        count += combination1(nums, s, r, index + 1, sum + nums[index], selected + 1);
        count += combination1(nums, s, r, index + 1, sum, selected);
        return count;
    }

    //조합으로 부분 집합 구하기2
    private static void solutionWithCombination2(int[] nums, int s) {
        int answer = 0;
        for (int i = 1; i <= nums.length; i++) {
            answer += combination2(nums, s, i, 0, 0, 0);
        }
        System.out.println(answer);
    }

    private static int combination2(int[] nums, int s, int r, int index, int sum, int depth) {
        if (depth == r) {
            return sum == s ? 1 : 0;
        }
        int count = 0;
        for (int i = index; i < nums.length; i++) {
            count += combination2(nums, s, r, i + 1, sum + nums[i], depth + 1);
        }
        return count;
    }

}
