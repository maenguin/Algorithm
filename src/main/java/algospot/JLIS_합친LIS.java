package algospot;

import java.util.Scanner;

//문제 출처 : https://algospot.com/judge/problem/read/JLIS
//노션 링크 : https://delirious-sock-4dc.notion.site/JLIS-LIS-d1edf77b7d6f4f1f8878f3251a7186e2
//알고 리즘 : DP
public class JLIS_합친LIS {

    private static int[] a;
    private static int[] b;
    private static int n;
    private static int m;
    private static int[][] cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (C-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            a = new int[n + 1];
            b = new int[m + 1];
            for (int i = 1; i < a.length; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 1; i < b.length; i++) {
                b[i] = sc.nextInt();
            }
            cache = new int[a.length][b.length];
            sb.append(jlis(0, 0)).append('\n');
        }
        System.out.println(sb);
    }

    //jlis(indexA, indexB)는 a[indexA], b[indexB]로 시작하는 JLIS의 길이
    private static int jlis(int indexA, int indexB) {
        if (cache[indexA][indexB] != 0) return cache[indexA][indexB];
        int max = 0;
        long curElement = Math.max(indexA == 0 ? Long.MIN_VALUE : a[indexA], indexB == 0 ? Long.MIN_VALUE : b[indexB]);
        for (int nextA = indexA + 1; nextA < a.length; nextA++) {
            if (curElement < a[nextA]) {
                max = Math.max(max, jlis(nextA, indexB) + 1) ;
            }
        }
        for (int nextB = indexB + 1; nextB < b.length; nextB++) {
            if (curElement < b[nextB]) {
                max = Math.max(max, jlis(indexA, nextB) + 1) ;
            }
        }
        return cache[indexA][indexB] = max;
    }

}

