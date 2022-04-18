package algospot;

import java.util.Scanner;

//문제 출처 : https://algospot.com/judge/problem/read/LIS
//노션 링크 : https://delirious-sock-4dc.notion.site/55f3455376b34364818888d951b407ba
//알고 리즘 : DP
public class LIS_최대증가부분수열 {

    private static int[] a;
    private static int n;
    private static int[] cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (C-- > 0) {
            n = sc.nextInt();
            a = new int[n + 1];
            for (int i = 1; i < a.length; i++) {
                a[i] = sc.nextInt();
            }
            cache = new int[a.length];
            sb.append(lis(0)).append('\n');
        }
        System.out.println(sb);
    }

    //lis(start)는 start로 시작하는 lis의 길이
    private static int lis(int start) {
        if (cache[start] != 0) return cache[start];
        int max = 0;
        for (int i = start + 1; i < a.length; i++) {
            if (a[start] < a[i]) {
                max = Math.max(max, lis(i) + 1) ;
            }
        }
        return cache[start] = max;
    }

}

