
package baekJoon;


import java.util.Scanner;
import java.util.function.IntToLongFunction;

//문제 출처 : https://www.acmicpc.net/problem/2805
//노션 링크 : https://delirious-sock-4dc.notion.site/2805-33218237086441b1a93f1e37b9606dbf
//문제 유형 : DP
public class P2805_나무자르기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] treeHeights = new int[N];
        for (int i = 0; i < treeHeights.length; i++) {
            treeHeights[i] = sc.nextInt();
        }
        System.out.println(lowerBoundBinarySearchWithAsc(
            cutterHeight -> getTreeMeterToTake(treeHeights, cutterHeight),
            0,
            Integer.MAX_VALUE,
            M
        ));
    }

    private static int lowerBoundBinarySearchWithAsc(IntToLongFunction function, int start, int end, int target) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (function.applyAsLong(mid) >= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private static long getTreeMeterToTake(int[] treeHeights, int cutterHeight) {
        long result = 0;
        for (int treeHeight : treeHeights) {
            if (treeHeight > cutterHeight) {
                result += treeHeight - cutterHeight;
            }
        }
        return result;
    }

}
