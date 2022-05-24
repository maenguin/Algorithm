
package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//문제 출처 : https://www.acmicpc.net/problem/2470
//노션 링크 : https://delirious-sock-4dc.notion.site/3ead560184dc4ffe9789c711e3c7d50d
//알고 리즘 : 투포인터
public class P2470_두용액 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        solution(n, a);
    }

    private static void solution(int n, int[] a) {
        Arrays.sort(a);
        int[] answer = new int[] {(int) 1e9, (int) 1e9};
        for (int i = 0, j = n - 1; i < j; ) {
            int sum = a[i] + a[j];
            if (Math.abs(sum) < Math.abs(answer[0] + answer[1])) {
                answer[0] = a[i];
                answer[1] = a[j];
            }
            if (sum <= 0) {
                i++;
            } else {
                j--;
            }
        }
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

}
