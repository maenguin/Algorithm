

package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/10974
public class P10974_모든순열 {

    /*
    [문제설명]
    N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램을 작성하시오.

    [시간제한]
    1 초

    [입력]
    첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다.

    [출력]
    첫째 줄부터 N!개의 줄에 걸쳐서 모든 순열을 사전순으로 출력한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i+1;
        }

        do {
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        } while (nextPermutation(a));
    }


    public static boolean nextPermutation(int[] a) {
        int i = a.length-1;
        while (i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length-1;
        while (a[j] <= a[i-1]) {
            j -= 1;
        }

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }
}