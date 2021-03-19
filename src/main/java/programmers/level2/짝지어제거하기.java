package programmers.level2;

import java.util.Stack;

public class 짝지어제거하기 {

    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()){
                stack.push(c);
                continue;
            }
            Character peek = stack.peek();
            if (peek == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }


        return stack.isEmpty() ? 1 : 0;
    }
}
