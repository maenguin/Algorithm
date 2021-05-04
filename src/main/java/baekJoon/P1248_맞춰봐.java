
package baekJoon;
import java.util.*;

//https://www.acmicpc.net/problem/1248
public class P1248_맞춰봐 {


    static int N ;
    static char[] C;
    static boolean[] visited;
    static int[] num;
    static int[] output;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        C = sc.next().toCharArray();
        num = new int[21];
        for (int i = 0; i < 21; i++) {
            num[i] = i - 10;
        }
        output = new int[N];
        visited = new boolean[21];
        bf(0);
    }

    public static void bf(int index) {
        if (index == N) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(output[i]);
                if (i != N - 1) {
                    sb.append(' ');
                }
            }
            System.out.println(sb);
            System.exit(0);
            return;
        }

        for (int i = 0; i < 21 ; i++) {
            output[index] = num[i];
            if (validate(index)){
                bf(index + 1);
            }
        }
    }

    //백트래킹용 검사 메소드
    public static boolean validate(int index){
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (index == j) {
                    int sum = sum(i, j);
                    char op = C[cnt];
                    if (op == '+' && sum <= 0){
                        return false;
                    }
                    if (op == '-' && sum >= 0){
                        return false;
                    }
                    if (op == '0' && sum != 0){
                        return false;
                    }
                }
                cnt++;
            }
        }
        return true;
    }

    public static int sum(int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += output[k];
        }
        return sum;
    }



    ////강의
    //강의에서는 S[i][i]가 A[i]임을 이용하여 21번 -> 10번으로 줄였다.
    //부호배열을 쉽게 처리하기 위해 2차원 배열로 변경했다. 메모리 낭비가 있지만 주어진 문제의크기가 작기떄문에 괜찮은듯

    static class 맞춰봐강의풀이 {


        static int N ;
        static int[][] sign;
        static int[] ans;
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            N = sc.nextInt();


            //문제에서 설명하는 S[i][j]를 직관적으로 이해하기 위해 1차원의 부호배열을 2차원으로 변경
            String s = sc.next();
            sign = new int[N][N];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i; j < N; j++) {
                    char c = s.charAt(cnt++);
                    if (c == '0') {
                        sign[i][j] = 0;
                    } else if (c == '+') {
                        sign[i][j] = 1;
                    } else if (c == '-') {
                        sign[i][j] = -1;
                    }
                }
            }
            ans = new int[N];
            bf(0);
        }

        public static void bf(int index) {
            //성공조건
            //백트래킹이 적용되었기에 index가 N이 되면 성공이다.
            if (index == N) {
                for (int i = 0; i < N; i++) {
                    System.out.print(ans[i] + " ");
                }
                System.exit(0);
                return;
            }

            //0만 오는 경우 10번의 루프를 굳이 돌릴 필요없으므로 0을 바로 처리하기 위한 조건을 추가한다.
            if (sign[index][index] == 0) {
                ans[index] = 0;
                if (isValidate(index)){
                    bf(index + 1);
                }
                return;
            }

            //S[i][i]는 A[i]와 같다.
            //그러므로 S[i][i]가 -이면 -10~-1, +면 1~10, 0이면 0으로 각각 루프를 돌리면된다.
            for (int i = 1; i <= 10 ; i++) {
                ans[index] = sign[index][index]*i;
                if (isValidate(index)){
                    bf(index + 1);
                }
            }
        }

        //백트래킹용 검사 메소드
        // (i, index)의 부호를 검사한다.
        // index = 0 => (0,0)
        // index = 1 => (0,1) (1,1)을 검사하면 된다.
        public static boolean isValidate(int index){

            //sum도 같이 처리하기 위해 index역순으로 순회한다.
            int sum = 0;
            for (int i = index; i >= 0; i--) {
                sum += ans[i];
                if (sign[i][index] == 0 && sum != 0){
                    return false;
                }
                if (sign[i][index] > 0 && sum <= 0){
                    return false;
                }
                if (sign[i][index] < 0 && sum >= 0){
                    return false;
                }
            }
            return true;
        }


        /*
        강의코드는 반환값을 boolean으로 설정했다.
        이러는 편이 속도가 더 잘나오더라라
        staticboolean go(int index) {
        if (index == n) {
            return true;
        }
        if (sign[index][index] == 0) {
            ans[index] = 0;
            return check(index) && go(index+1);
        }
        for (int i=1; i<=10; i++) {
            ans[index] = sign[index][index]*i;
            if (check(index) && go(index+1)) return true;
        }
        return false;
    }
         */



    }


}

