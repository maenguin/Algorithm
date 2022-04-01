
package baekJoon;


import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/11659
//노션 링크 : https://delirious-sock-4dc.notion.site/11659-4-5ad97e8a744e49a9b2b90302a22bb217
//문제 유형 : 누적합
public class P11659_구간합구하기4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n + 1];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        initAccumulateSum(nums);
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            sb.append(getSumBetween(nums, i, j)).append("\n");
        }
        System.out.println(sb);
    }

    private static void initAccumulateSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
    }

    private static int getSumBetween(int[] nums, int i, int j) {
        return nums[j] - nums[i - 1];
    }

}
