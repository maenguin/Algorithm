
package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/10973
public class P10973_이전순열 {

    /*
    [문제설명]
    1부터 N까지의 수로 이루어진 순열이 있다. 이때, 사전순으로 다음에 오는 순열을 구하는 프로그램을 작성하시오.
    사전 순으로 가장 앞서는 순열은 오름차순으로 이루어진 순열이고, 가장 마지막에 오는 순열은 내림차순으로 이루어진 순열이다.
    N = 3인 경우에 사전순으로 순열을 나열하면 다음과 같다.

    1, 2, 3
    1, 3, 2
    2, 1, 3
    2, 3, 1
    3, 1, 2
    3, 2, 1

    [시간제한]
    1 초

    [입력]
    첫째 줄에 N(1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄에 순열이 주어진다.

    [출력]
    첫째 줄에 입력으로 주어진 순열의 다음에 오는 순열을 출력한다.
    만약, 사전순으로 마지막에 오는 순열인 경우에는 -1을 출력한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        if (prevPerm(a)){
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    public static boolean prevPerm(int[] a) {

        int i = a.length - 1;
        while ( i > 0 && a[i-1] <= a[i]){
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length - 1;
        while (a[i - 1] <= a[j]) {
            j -= 1;
        }

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length - 1;
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