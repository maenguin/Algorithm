package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/16935
public class P16935_배열돌리기3 {

    /*
    [문제설명]
    크기가 N×M인 배열이 있을 때, 배열에 연산을 R번 적용하려고 한다. 연산은 총 6가지가 있다.

    1번 연산은 배열을 상하 반전시키는 연산이다.

    1 6 2 9 8 4 → 4 2 9 3 1 8
    7 2 6 9 8 2 → 9 2 3 6 1 5
    1 8 3 4 2 9 → 7 4 6 2 3 1
    7 4 6 2 3 1 → 1 8 3 4 2 9
    9 2 3 6 1 5 → 7 2 6 9 8 2
    4 2 9 3 1 8 → 1 6 2 9 8 4
       <배열>       <연산 결과>
    2번 연산은 배열을 좌우 반전시키는 연산이다.

    1 6 2 9 8 4 → 4 8 9 2 6 1
    7 2 6 9 8 2 → 2 8 9 6 2 7
    1 8 3 4 2 9 → 9 2 4 3 8 1
    7 4 6 2 3 1 → 1 3 2 6 4 7
    9 2 3 6 1 5 → 5 1 6 3 2 9
    4 2 9 3 1 8 → 8 1 3 9 2 4
       <배열>       <연산 결과>
    3번 연산은 오른쪽으로 90도 회전시키는 연산이다.

    1 6 2 9 8 4 → 4 9 7 1 7 1
    7 2 6 9 8 2 → 2 2 4 8 2 6
    1 8 3 4 2 9 → 9 3 6 3 6 2
    7 4 6 2 3 1 → 3 6 2 4 9 9
    9 2 3 6 1 5 → 1 1 3 2 8 8
    4 2 9 3 1 8 → 8 5 1 9 2 4
       <배열>       <연산 결과>
    4번 연산은 왼쪽으로 90도 회전시키는 연산이다.

    1 6 2 9 8 4 → 4 2 9 1 5 8
    7 2 6 9 8 2 → 8 8 2 3 1 1
    1 8 3 4 2 9 → 9 9 4 2 6 3
    7 4 6 2 3 1 → 2 6 3 6 3 9
    9 2 3 6 1 5 → 6 2 8 4 2 2
    4 2 9 3 1 8 → 1 7 1 7 9 4
       <배열>       <연산 결과>
    5, 6번 연산을 수행하려면 배열을 크기가 N/2×M/2인 4개의 부분 배열로 나눠야 한다. 아래 그림은 크기가 6×8인 배열을 4개의 그룹으로 나눈 것이고, 1부터 4까지의 수로 나타냈다.

    1 1 1 1 2 2 2 2
    1 1 1 1 2 2 2 2
    1 1 1 1 2 2 2 2
    4 4 4 4 3 3 3 3
    4 4 4 4 3 3 3 3
    4 4 4 4 3 3 3 3
    5번 연산은 1번 그룹의 부분 배열을 2번 그룹 위치로, 2번을 3번으로, 3번을 4번으로, 4번을 1번으로 이동시키는 연산이다.

    3 2 6 3 1 2 9 7 → 2 1 3 8 3 2 6 3
    9 7 8 2 1 4 5 3 → 1 3 2 8 9 7 8 2
    5 9 2 1 9 6 1 8 → 4 5 1 9 5 9 2 1
    2 1 3 8 6 3 9 2 → 6 3 9 2 1 2 9 7
    1 3 2 8 7 9 2 1 → 7 9 2 1 1 4 5 3
    4 5 1 9 8 2 1 3 → 8 2 1 3 9 6 1 8
         <배열>            <연산 결과>
    6번 연산은 1번 그룹의 부분 배열을 4번 그룹 위치로, 4번을 3번으로, 3번을 2번으로, 2번을 1번으로 이동시키는 연산이다.

    3 2 6 3 1 2 9 7 → 1 2 9 7 6 3 9 2
    9 7 8 2 1 4 5 3 → 1 4 5 3 7 9 2 1
    5 9 2 1 9 6 1 8 → 9 6 1 8 8 2 1 3
    2 1 3 8 6 3 9 2 → 3 2 6 3 2 1 3 8
    1 3 2 8 7 9 2 1 → 9 7 8 2 1 3 2 8
    4 5 1 9 8 2 1 3 → 5 9 2 1 4 5 1 9
         <배열>            <연산 결과>

    [시간제한]
    2 초

    [입력]
    첫째 줄에 배열의 크기 N, M과 수행해야 하는 연산의 수 R이 주어진다.

    둘째 줄부터 N개의 줄에 배열 A의 원소 Aij가 주어진다.

    마지막 줄에는 수행해야 하는 연산이 주어진다. 연산은 공백으로 구분되어져 있고, 문제에서 설명한 연산 번호이며, 순서대로 적용시켜야 한다.

    [출력]
    한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
    수열은 사전 순으로 증가하는 순서로 출력해야 한다.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        while (r-- > 0) {
            int i = sc.nextInt();
            switch (i) {
                case 1: a = upSideDown(a); break;
                case 2: a = leftSideRight(a); break;
                case 3: a = rotateR90(a);break;
                case 4: a = rotateL90(a);break;
                case 5: a = operation5(a);break;
                case 6: a = operation6(a);break;
            }
        }


        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

    }



    private static int[][] upSideDown(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = a[n-1-i][j];
            }
        }
        return ans;
    }
    private static void upSideDown2(int[][] arr) {
        for (int k = 0; k < arr[0].length; k++) {
            int i = 0;
            int j = arr.length - 1;

            while (i < j) {
                int temp = arr[i][k];
                arr[i][k] = arr[j][k];
                arr[j][k] = temp;
                i++;
                j--;
            }
        }
    }

    private static int[][] leftSideRight(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = a[i][m-1-j];
            }
        }
        return ans;
    }
    private static void leftSideRight2(int[][] arr) {
        for (int k = 0; k < arr.length; k++) {
            int i = 0;
            int j = arr[k].length - 1;

            while (i < j) {
                int temp = arr[k][i];
                arr[k][i] = arr[k][j];
                arr[k][j] = temp;
                i++;
                j--;
            }
        }
    }


    private static int[][] rotateR90(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = a[n-1-j][i];
            }
        }
        return ans;
    }

    private static int[][] rotateL90(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = a[j][m-1-i];
            }
        }
        return ans;
    }

    private static int[][] operation5(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < m/2; j++) {
                ans[i][j+m/2] = a[i][j];
                ans[i+n/2][j+m/2] = a[i][j+m/2];
                ans[i+n/2][j] = a[i+n/2][j+m/2];
                ans[i][j] = a[i+n/2][j];
            }
        }
        return ans;
    }
    private static int[][] operation6(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < m/2; j++) {
                ans[i][j+m/2] = a[i+n/2][j+m/2];
                ans[i+n/2][j+m/2] = a[i+n/2][j];
                ans[i+n/2][j] = a[i][j];
                ans[i][j] = a[i][j+m/2];
            }
        }
        return ans;
    }

}
