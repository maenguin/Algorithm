package baekJoon;

import java.util.Arrays;
import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/2217
//노션 링크 : https://delirious-sock-4dc.notion.site/2217-f0c0c7fe716e427da7eba507e747aa3c
//문제 유형 : 그리디
public class P2217_로프 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ropes = new int[n];
        for (int i = 0; i < n; i++) {
            ropes[i] = sc.nextInt();
        }
        Arrays.sort(ropes);
        int answer = 0;
        int a = 1;
        for (int i = ropes.length - 1; i >= 0; i--) {
            int weight = ropes[i] * a++;
            if (weight > answer) {
                answer = weight;
            }
        }
        System.out.println(answer);
    }

}
