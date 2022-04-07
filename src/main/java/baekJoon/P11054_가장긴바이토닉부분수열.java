
package baekJoon;


import java.util.Arrays;
import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/11054
//노션 링크 : https://delirious-sock-4dc.notion.site/11054-fc77589b867e415daa2c6c20c5e8e292
//문제 유형 : DP
public class P11054_가장긴바이토닉부분수열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < A.length; i++) {
            A[i] = sc.nextInt();
        }
        solution1(A);
    }

    private static void solution1(int[] A) {
        //A[i]로 끝나는 가장 긴 증가하는 부분수열의 길이
        int[] dAse = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    dAse[i] = Math.max(dAse[i], dAse[j]);
                }
            }
            dAse[i]++;
        }
        //A[i]로 시작하는 가장 긴 감소하는 부분수열의 길이
        int[] dDes = new int[A.length];
        for (int i = A.length - 1; i >= 0 ; i--) {
            for (int j = A.length - 1; j > i; j--) {
                if (A[j] < A[i]) {
                    dDes[i] = Math.max(dDes[i], dDes[j]);
                }
            }
            dDes[i]++;
        }
        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            answer = Math.max(answer, dAse[i] + dDes[i]);
        }
        System.out.println(Arrays.toString(dAse));
        System.out.println(Arrays.toString(dDes));
        System.out.println(answer - 1);
    }

}
