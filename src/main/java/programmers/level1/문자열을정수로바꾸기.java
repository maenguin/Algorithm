package programmers.level1;

public class 문자열을정수로바꾸기 {


    public int solution(String s) {
        return parseInt(s,10);
    }

    private int parseInt(String s, int radix){
        boolean isNegative = false;
        int result = 0;

        char firstChar = s.charAt(0);
        isNegative = firstChar == '-';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '-' && c != '+') {
                result = result * radix + (c - '0');
            }

        }

        return isNegative ? -result : result;
    }

//    public int solution(String s) {
//        return Integer.parseInt(s);
//    }

}
