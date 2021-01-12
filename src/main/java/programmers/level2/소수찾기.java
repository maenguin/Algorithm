package programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {

    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {

        int n = numbers.length();

        String[] split = numbers.split("");
        String[] output = new String[n];

        for (int i = 0; i < split.length; i++) {
            permutation(split,0,n,i+1);
        }

        return set.size();
    }


    void permutation(String[] arr, int depth, int n, int r) {
        if (depth == r) {
            String s = "";
            for (int i = 0; i < r; i++) {
                s += arr[i];
            }
            int parseInt1 = Integer.parseInt(s);
            if (!set.contains(parseInt1) && isPrime(parseInt1)) {
                set.add(parseInt1);
            }
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(String[] arr, int depth, int i) {
        String temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }



    private boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
