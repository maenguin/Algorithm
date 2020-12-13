package programmers.level1;

public class 이상한문자만들기 {

    public String solution(String s) {

        StringBuilder builder = new StringBuilder();

        int i = 0;
        for (char oldChar : s.toCharArray()) {

            i = oldChar == ' ' ? 0 : i + 1;
            char newChar = i % 2 == 0 ? Character.toLowerCase(oldChar) : Character.toUpperCase(oldChar);
            builder.appendCodePoint(newChar);
        }

        return builder.toString();
    }



}
