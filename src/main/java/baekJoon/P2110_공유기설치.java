package baekJoon;

import java.util.Arrays;
import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/2110
//노션 링크 : https://delirious-sock-4dc.notion.site/2110-2df1cea701f048cbaac4dff7ebe98acd
//문제 유형 : 이분 탐색, 매개 변수 탐색
public class P2110_공유기설치 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] houses = new int[n];
        for (int i = 0; i < houses.length; i++) {
            houses[i] = sc.nextInt();
        }
        Arrays.sort(houses);
        int result = 0;
        int left = 1;
        int right = houses[houses.length - 1] - houses[0];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canInstallRouters(houses, c, mid)) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }


    private static boolean canInstallRouters(int[] houses, int routerCount, int distance) {
        int installedCount = 1;
        int lastHouse = 0;
        for (int i = 1; i < houses.length; i++) {
            if (houses[i] - houses[lastHouse] >= distance) {
                installedCount++;
                lastHouse = i;
            }
        }
        return installedCount >= routerCount;
    }

}
