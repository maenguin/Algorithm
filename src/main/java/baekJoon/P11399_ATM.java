
package baekJoon;


import java.util.Arrays;
import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/11399
//노션 링크 : https://delirious-sock-4dc.notion.site/11399-ATM-652b497d1dc14ffca5cdd545dcd717e3
//문제 유형 : 시뮬레이션, 구현
public class P11399_ATM {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ps = new int[n];
        for (int i = 0; i < n; i++) {
            ps[i] = sc.nextInt();
        }

        Arrays.sort(ps);
        int answer = 0;
        int sum = 0;
        for (int p : ps) {
            answer += sum + p;
            sum += p;
        }
        System.out.println(answer);
    }

}
