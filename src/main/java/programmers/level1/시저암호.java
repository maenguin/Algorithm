package programmers.level1;

public class 시저암호 {

    public String solution(String s, int n) {
        int range = 'z' - 'a' + 1;
        StringBuilder builder = new StringBuilder();
        for (char oldChar : s.toCharArray()) {
            if (oldChar == ' '){
                builder.append(' ');
                continue;
            }
            int newChar =  oldChar + n;
            if ((Character.isUpperCase(oldChar) && newChar > 'Z') || (!Character.isUpperCase(oldChar) && newChar > 'z') ){
                builder.appendCodePoint(newChar - range);
            }
            else {
                builder.appendCodePoint(newChar);
            }

        }

        return builder.toString();
    }

}
