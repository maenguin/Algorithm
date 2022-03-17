package baekJoon;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/2457
//노션 링크 : https://delirious-sock-4dc.notion.site/2457-7b17a6b1de4f4ac0906d8b436bb96894
//문제 유형 : 그리디
public class P2457_공주님의정원 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int year = 2022;
        LocalDate firstDate = LocalDate.of(year, 1, 1);
        int flowerStart = (int)ChronoUnit.DAYS.between(firstDate, LocalDate.of(year, 3, 1));
        int flowerEnd = (int)ChronoUnit.DAYS.between(firstDate, LocalDate.of(year, 11, 30));
        int[][] flowers = new int[n][2];
        for (int i = 0; i < n; i++) {
            flowers[i][0] = (int)ChronoUnit.DAYS.between(firstDate, LocalDate.of(year, sc.nextInt(), sc.nextInt()));
            flowers[i][1] = (int)ChronoUnit.DAYS.between(firstDate, LocalDate.of(year, sc.nextInt(), sc.nextInt()));
        }

        Arrays.sort(flowers, Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));

        int answer = 0;
        int curEnd = flowerStart;
        int i = 0;
        while (curEnd <= flowerEnd) {
            int max = 0;
            while (i < n && curEnd >= flowers[i][0]) {
                max = Math.max(max, flowers[i][1]);
                i++;
            }
            if (max < curEnd) {
                answer = 0;
                break;
            }
            curEnd = max;
            answer++;
        }
        System.out.println(answer);
    }

}
