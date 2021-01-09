package kakao;

import java.util.Stack;

//2020 KAKAO BLIND
public class 괄호변환 {

    public String solution(String p) {
        return bracketConversion(p);
    }

    public String bracketConversion(String p) {

        if (p.isEmpty()) return "";

        int splitIndex = getSplitIndex(p);
        String u = p.substring(0, splitIndex);
        String v = p.substring(splitIndex);

        return isValidParenthesis(u) ? u + bracketConversion(v) : "("+bracketConversion(v)+")" + trimAndReverse(u);
    }

    public int getSplitIndex(String p) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            left = c == '(' ? left + 1 : left;
            right = c == ')' ? right + 1 : right;
            if (left != 0 && left == right) {
                return i + 1;
            }
        }
        return 0;
    }

    public boolean isValidParenthesis(String u) {
        Stack<Character> stack = new Stack<>();
        for (char c : u.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                continue;
            } else {
                if (stack.isEmpty() || stack.peek() == ')') {
                    return false ;
                }
                stack.pop();
            }
        }
        return true;
    }

    public String trimAndReverse(String u) {
        StringBuilder builder = new StringBuilder();
        String substring = u.substring(1, u.length() - 1);
        for (char c : substring.toCharArray()) {
            builder.appendCodePoint(c == '(' ? ')' : '(');
        }
        return builder.toString();
    }
}
