import programmers.hash.Camouflage;
import programmers.sort.TheBiggestNumber;
import programmers.stackqueue.Q01;

import java.sql.Time;
import java.time.Clock;
import java.util.*;

public class Main {

    public  static void main (String[] args) {


        kakao.Q2 d = new kakao.Q2();
        String s1 = "(()())()";
        String s2 = ")(";
        d.solution(s2);
    }


    public static void combination(int[] arr, int index, int n, int r, int target) {
        if (r == 0) print(arr, index);
        else if (target == n)
            return;
        else { arr[index] = target;
        combination(arr, index + 1, n, r - 1, target + 1);
        combination(arr, index, n, r, target + 1);
        }
    }
    public static void com_non_rcursive(int[] arr, int index, int n, int r, int target) {
        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[]{index,n,r,target});
        while (!stack.isEmpty()) {
            Integer[] arr2 = stack.pop();
            int index2 = arr2[0];
            int n2 = arr2[1];
            int r2 = arr2[2];
            int target2 = arr2[3];

            if (r2 == 0) print(arr, index2);
            else if (target2 ==n2)
                continue;
            else { arr[index2] = target2;
                stack.push(new Integer[]{index2,n2,r2,target2+1});
                stack.push(new Integer[]{index2+1,n2,r2-1,target2+1});
            }

        }

    }


    public static void print(int[] arr, int length) { for (int i = 0; i < length; i++) System.out.print(arr[i]); System.out.println(""); }


}
