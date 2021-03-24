package programmers.level2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class N개의최소공배수 {
    public int solution(int[] arr) {

        Arrays.sort(arr);
        int lcm = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int a = arr[i];
            lcm = lcm(a, lcm);
        }
        return lcm;
    }

    private int gcdU(int n, int m) {

        int temp = 0;
        while (n % m != 0) {
            temp = n % m;
            n = m;
            m = temp;
        }
        return m;
    }

    private int lcm(int n, int m) {
        return n*m/gcdU(n,m);
    }
}
