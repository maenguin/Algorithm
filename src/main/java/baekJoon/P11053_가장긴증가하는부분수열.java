
package baekJoon;


import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/11053
//노션 링크 : https://delirious-sock-4dc.notion.site/22860-small-681e8ffd04b14fe0a282103b89290426
//문제 유형 : DP
public class P11053_가장긴증가하는부분수열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        solution2(a);
    }

    private static void solution1(int[] a) {
        int answer = 0;
        //d[i] : 끝이 a[i]로 끝나는 가장 긴 증가하는 부분 수열의 최대 길이
        //d[n] = 1 + max(d[j]) (j는 a[j] < a[n]인 0 ~ n-1 사이의 값)
        int[] d = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    max = Math.max(max, d[j]);
                }
            }
            d[i] = max + 1;
            answer = Math.max(answer, d[i]);
        }
        System.out.println(answer);
    }

    private static void solution2(int[] a) {
        //z[i] : LIS의 길이가 i일때, LIS의 마지막 요소 중 최솟값
        int[] z = new int[a.length + 1];
        int lastZIndex = 0;
        for (int i = 0; i < a.length; i++) {
            int j = lowerBoundBinarySearch(z, 0, lastZIndex, a[i]);
            if (a[i] < z[j]) {
                z[j] = a[i];
            }
            if (j > lastZIndex) {
                lastZIndex++;
                z[j] = a[i];
            }
        }
        System.out.println(lastZIndex);
    }

    private static int lowerBoundBinarySearch(int[] a, int start, int end, int target) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (a[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
