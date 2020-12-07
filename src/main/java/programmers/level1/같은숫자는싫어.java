package programmers.level1;

import java.util.Stack;

public class 같은숫자는싫어 {

    public int[] solution(int []arr) {

        Stack<Integer> stack = new Stack<>();

        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];

            if (stack.peek() != cur){
                stack.push(cur);
            }
        }

        int[] answer = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++)
            answer[i] = stack.get(i);

        return answer;
    }

}
