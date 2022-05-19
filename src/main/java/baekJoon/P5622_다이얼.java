package baekJoon;

import java.util.Scanner;

public class P5622_다이얼 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] dial = new char[]{3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10};
        String next = sc.next();
        int answer = 0;
        for (char c : next.toCharArray()) {
            answer += dial[c - 'A'];
        }
        System.out.println(answer);
    }

}
