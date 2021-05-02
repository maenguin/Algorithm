

package baekJoon;
import java.util.*;

//https://www.acmicpc.net/problem/2529
public class P2529_부등호 {


    static int k ;
    static char[] ops;
    static ArrayList<String> ansList = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        ops = new char[k];
        for (int i = 0; i < k; i++) {
            ops[i] = sc.next().charAt(0);
        }

        visited = new boolean[10];
        go2(0, "");
        Collections.sort(ansList);
        System.out.println(ansList.get(ansList.size()-1));
        System.out.println(ansList.get(0));

    }

    //순열 개념의 브루트포스
    public static void go(int depth, String num) {

        if (depth == k + 1) {
            if (check(num)){
                ansList.add(num);
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            go(depth + 1, num + i);
            visited[i] = false;

        }

    }

    public static boolean check(String num){

        for (int i = 0; i < ops.length; i++) {
            char op = ops[i];
            char a = num.charAt(i);
            char b = num.charAt(i+1);
            if (!good(a,b,op)){
                return false;
            }

        }
        return true;
    }


    public static void go2(int depth, String num) {

        if (depth == k + 1) {
            ansList.add(num);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) continue;
            //백트래킹 추가
            //다완성했을떄 검사하는게 아니라
            //완성하는 과정에서 검사
            if (depth == 0 || good(num.charAt(depth-1), (char)(i + '0'), ops[depth-1])){
                visited[i] = true;
                go2(depth + 1, num + i);
                visited[i] = false;
            }

        }

    }

    public static boolean good(char x, char y, char op) {
        if (op == '<' && x >= y) {
            return false;
        }
        if (op == '>' && x <= y) {
            return false;
        }
        return true;
    }


}
