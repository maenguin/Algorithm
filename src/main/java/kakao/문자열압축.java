package kakao;


import java.util.Stack;

//2020 kakao blind recuritment
public class 문자열압축 {

    public int solution(String s) {

        int length = s.length();
        int answer = length;

        Stack<String> stack = new Stack<>();
        for (int i = 1; i <= length/2; i++) {
            int compressedLengthWheni = 0;
            for (int j = 0; j < length; j+= i) {
                String sub = s.substring(j, Math.min(j + i, length));

                if (!stack.isEmpty() && !stack.peek().equals(sub)) {
                    compressedLengthWheni += stack.size() == 1 ? sub.length() : sub.length() + (int)Math.log(stack.size()) + 1 ;
                    stack.clear();
                }
                stack.push(sub);
            }
            if (!stack.isEmpty()) {
                compressedLengthWheni += stack.size() == 1 ? i : i + (int)Math.log(stack.size()) + 1;
                stack.clear();
            }

            answer = Math.min(answer, compressedLengthWheni);
        }


        return answer;
    }

}
