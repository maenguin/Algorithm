
package baekJoon;

import java.util.Scanner;

//문제 출처 : https://algospot.com/judge/problem/read/JLIS
//노션 링크 : https://delirious-sock-4dc.notion.site/JLIS-LIS-d1edf77b7d6f4f1f8878f3251a7186e2
//알고 리즘 : DP
public class P10819_차이를최대로_Re {

    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        bruteforcePermutation(a, new int[n], new boolean[n], n, n, 0);
        System.out.println(answer);
    }

    private static void bruteforcePermutation(int[] a, int[] output, boolean[] visited, int n, int r, int depth) {
        if (depth == r) {
            int sum = 0;
            for (int i = 0; i < r - 1; i++) {
                sum += Math.abs(output[i] - output[i + 1]);
            }
            answer = Math.max(answer, sum);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            output[depth] = a[i];
            bruteforcePermutation(a, output, visited, n, r, depth + 1);
            visited[i] = false;
        }
    }

}
