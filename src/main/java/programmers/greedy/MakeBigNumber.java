package programmers.greedy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MakeBigNumber {

    public String solution(String number, int k) {

        StringBuilder sb = new StringBuilder();

        int leftK = number.length() - k;
        int cur = 0;
        while (leftK != 0){

            char max = 0;
            for (int i = cur; i < number.length() && number.length() - i >= leftK  ; i++) {
                if (max < number.charAt(i)){
                    max = number.charAt(i);
                }
            }
            leftK--;
            sb.append(max);
            cur = number.indexOf(max,cur) + 1;
        }

        return sb.toString();
    }


    //스택으로 풀려고 했다가 포기했는데
    //스택으로 멋지게 푼 풀이가 있어서 너무 감탄스러웠다.
    //while문 안에 조건들을 나열해서 본문 내용을 줄이는 방법이 신기했다.
    //스택으로 풀 수 있는 문제와 없는 문제는 무엇일까?
    //이 문제는 왼쪽부터 차례대로 양옆의 비교를 하기 때문에 가능했던걸까?
    public String Bestsolution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }


}
