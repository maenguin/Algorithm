package utils;

import java.util.stream.IntStream;

public class Permutation {

    private int[] arr;
    private int n;
    private int r;
    private int[][] result;
    private int index;


    public Permutation(int[] arr, int n, int r) {
        this.n = n;
        this.r = r;
        int factorial = IntStream.rangeClosed(1,n).reduce(1, (x, y) -> x * y);
        result = new int[factorial][r];
        this.arr = arr;
    }

    public int[][] getResult(boolean stable) {
        if (stable) {
            int[] output = new int[n];
            boolean[] visited = new boolean[n];
            stablePermutation(arr,output,visited,0,n,r);
        } else {
            unstablePermutation(arr,n,r,0);
        }
        return result;
    }

    private void unstablePermutation(int[] arr, int n, int r, int depth) {
        if (depth == r) {
            fillResult(arr, r);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            unstablePermutation(arr, n, r, depth + 1);
            swap(arr, depth, i);
        }
    }

    private void stablePermutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            fillResult(output, r);
            return;
        }

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                stablePermutation(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    private void fillResult(int[] arr, int r) {
        for (int i = 0; i < r; i++) {
            result[index][i] = arr[i];
        }
        index++;
    }

    void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

}