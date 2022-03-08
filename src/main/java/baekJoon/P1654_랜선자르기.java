package baekJoon;

import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/1654
//노션 링크 : https://delirious-sock-4dc.notion.site/1654-59a0ceb37f0144768f722d31dd96a2f9
//문제 유형 : 이분 탐색, 매개 변수 탐색
public class P1654_랜선자르기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] cables = new int[k];
        long max = 0;
        for (int i = 0; i < cables.length; i++) {
            cables[i] = sc.nextInt();
            max += cables[i];
        }
        max /= n;
        long answer = binarySearchUpperBound(cables, max, n);
        System.out.println(answer - 1);
    }

    private static long binarySearchUpperBound(int[] cables, long max, int target) {
        long left = 1;
        long right = max;
        while (left <= right) {
            long mid = left + (right - left)/2;
            int i = cutCable(cables, mid);
            if (i >= target) {
                left = mid + 1;
            } else if (i < target) {
                right = mid - 1;
            }
        }
        return left;
    }

    private static int cutCable(int[] cables, long cm) {
        int n = 0;
        for (int cable : cables) {
            n += cable / cm;
        }
        return n;
    }

}
