package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/11723
public class P11723_집합 {

    /*
    [문제설명]
    비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하시오.

    add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
    remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
    check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
    toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
    all: S를 {1, 2, ..., 20} 으로 바꾼다.
    empty: S를 공집합으로 바꾼다.

    [시간제한]
    1.5 초

    [메모리 제한]
    4 MB

    [입력]
    첫째 줄에 수행해야 하는 연산의 수 M (1 ≤ M ≤ 3,000,000)이 주어진다.
    둘째 줄부터 M개의 줄에 수행해야 하는 연산이 한 줄에 하나씩 주어진다.

    [출력]
    check 연산이 주어질때마다, 결과를 출력한다.

     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(bf.readLine());
        int s = 0;
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            String[] s1 = bf.readLine().split(" ");
            switch (s1[0]) {
                case "add" :
                    s = Bitwise.add(s,Integer.parseInt(s1[1]));
                    break;
                case "remove" :
                    s = Bitwise.remove(s,Integer.parseInt(s1[1]));
                    break;
                case "check" :
                    sb.append(Bitwise.check(s, Integer.parseInt(s1[1])) ? "1\n" : "0\n");
                    break;
                case "toggle" :
                    s = Bitwise.toggle(s,Integer.parseInt(s1[1]));
                    break;
                case "all" :
                    s = Bitwise.all();
                    break;
                case "empty" :
                    s = Bitwise.empty();
                    break;
            }
        }
        System.out.println(sb);
    }

    static class Bitwise {

        static int add(int s, int x) {
            return s | (1 << x);
        }
        static int remove(int s, int x) {
            return s & ~(1 << x);
        }
        static boolean check(int s, int x) {
            return (s & (1 << x)) != 0;
        }
        static int toggle(int s, int x) {
            return s ^ (1 << x);
        }
        static int all() {
            return (1 << 21) -1;
        }
        static int empty() {
            return 0;
        }

    }
}