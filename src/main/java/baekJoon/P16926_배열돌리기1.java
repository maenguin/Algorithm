
package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/16926
public class P16926_배열돌리기1 {

    /*
    [문제설명]
    크기가 N×M인 배열이 있을 때, 배열을 돌려보려고 한다. 배열은 다음과 같이 반시계 방향으로 돌려야 한다.

    A[1][1] ← A[1][2] ← A[1][3] ← A[1][4] ← A[1][5]
       ↓                                       ↑
    A[2][1]   A[2][2] ← A[2][3] ← A[2][4]   A[2][5]
       ↓         ↓                   ↑         ↑
    A[3][1]   A[3][2] → A[3][3] → A[3][4]   A[3][5]
       ↓                                       ↑
    A[4][1] → A[4][2] → A[4][3] → A[4][4] → A[4][5]
    예를 들어, 아래와 같은 배열을 2번 회전시키면 다음과 같이 변하게 된다.

    1 2 3 4       2 3 4 8       3 4 8 6
    5 6 7 8       1 7 7 6       2 7 8 2
    9 8 7 6   →   5 6 8 2   →   1 7 6 3
    5 4 3 2       9 5 4 3       5 9 5 4
     <시작>         <회전1>        <회전2>
    배열과 정수 R이 주어졌을 때, 배열을 R번 회전시킨 결과를 구해보자.

    [시간제한]
    1 초

    [입력]
    첫째 줄에 배열의 크기 N, M과 수행해야 하는 회전의 수 R이 주어진다.

    둘째 줄부터 N개의 줄에 배열 A의 원소 Aij가 주어진다.

    [출력]
    입력으로 주어진 배열을 R번 회전시킨 결과를 출력한다.

    [제한]
    2 ≤ N, M ≤ 300
    1 ≤ R ≤ 1,000
    min(N, M) mod 2 = 0
    1 ≤ Aij ≤ 108

     */


    //일차원 배열에 넣은후 a[(i+r)%length]로 한번에 돌린다음 다시 2차원배열에 넣어준다.
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

        //같이 순환하는 부분을 하나의 그룹으로 본다. 맨바깥쪽이 0번째 그룹
        //그 그룹별로 일차원 배열에 담는다.
        List<ArrayList<Integer>> groups = new ArrayList<>();
        int groupCnt = Math.min(n, m)/2;

        for (int k = 0; k < groupCnt; k++) {
            ArrayList<Integer> group = new ArrayList<>();

            //윗줄 담기
            for (int j = k; j < m - 1 - k; j++) {
                group.add(a[k][j]);
            }
            //오른쪽 세로줄 담기
            for (int i = k; i < n - 1 - k; i++) {
                group.add(a[i][m - 1 - k]);
            }
            //아랫줄 담기
            for (int j = m - 1 - k; j > k; j--) {
                group.add(a[n - 1 - k][j]);
            }
            //왼쪽 세로줄 담기
            for (int i = n - 1 -k; i > k; i--) {
                group.add(a[i][k]);
            }
            groups.add(group);

        }

        //다시 배열로 옮길때 %연산으로 돌린걸 넣어준다
        for (int k = 0; k < groupCnt; k++) {

            ArrayList<Integer> group = groups.get(k);
            int index = 0;
            //윗줄 담기
            for (int j = k; j < m - 1 - k; j++) {
                a[k][j] = group.get((index++ + r)%group.size());
            }
            //오른쪽 세로줄 담기
            for (int i = k; i < n - 1 - k; i++) {
                a[i][m - 1 - k] = group.get((index++ + r)%group.size());
            }
            //아랫줄 담기
            for (int j = m - 1 - k; j > k; j--) {
                a[n - 1 - k][j] = group.get((index++ + r)%group.size());
            }
            //왼쪽 세로줄 담기
            for (int i = n - 1 -k; i > k; i--) {
                a[i][k] = group.get((index++ + r)%group.size());
            }


        }



        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

    }




}
