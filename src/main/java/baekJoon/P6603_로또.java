
package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/6603
public class P6603_로또 {

    /*
    [문제설명]
    독일 로또는 {1, 2, ..., 49}에서 수 6개를 고른다.
    로또 번호를 선택하는데 사용되는 가장 유명한 전략은 49가지 수 중 k(k>6)개의 수를 골라 집합 S를 만든 다음 그 수만 가지고 번호를 선택하는 것이다.
    예를 들어, k=8, S={1,2,3,5,8,13,21,34}인 경우 이 집합 S에서 수를 고를 수 있는 경우의 수는 총 28가지이다.
    ([1,2,3,5,8,13], [1,2,3,5,8,21], [1,2,3,5,8,34], [1,2,3,5,13,21], ..., [3,5,8,13,21,34])
    집합 S와 k가 주어졌을 때, 수를 고르는 모든 방법을 구하는 프로그램을 작성하시오.

    [시간제한]
    1 초

    [입력]
    입력은 여러 개의 테스트 케이스로 이루어져 있다.
    각 테스트 케이스는 한 줄로 이루어져 있다.
    첫 번째 수는 k (6 < k < 13)이고, 다음 k개 수는 집합 S에 포함되는 수이다.
    S의 원소는 오름차순으로 주어진다.
    입력의 마지막 줄에는 0이 하나 주어진다.

    [출력]
    각 테스트 케이스마다 수를 고르는 모든 방법을 출력한다. 이때, 사전 순으로 출력한다.
    각 테스트 케이스 사이에는 빈 줄을 하나 출력한다.
     */


    //n과m(2)와 같은 문제라고 볼 수 있음
    //순열을 이용해서 풀어보면, 0을 선택 1을 선택하지 않음으로 정하고
    //k개의 0과 n-k개의 1을 가진 배열을 생성한 후 nextPerm을 돌리면 k!(n-k)!개의 조합이 나오게 된다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int[] b = new int[n];
            for (int i = 6; i < n; i++) {
                b[i] = 1;
            }

            do {
                for (int i = 0; i < n; i++) {
                    if (b[i] == 0){
                        System.out.print(a[i] + " ");
                    }
                }
                System.out.println();
            } while (nextPermutation(b));
            System.out.println();
        }

    }


    public static boolean nextPermutation(int[] a) {
        int i = a.length-1;
        while (i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length-1;
        while (a[j] <= a[i-1]) {
            j -= 1;
        }

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }
}
