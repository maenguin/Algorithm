package programmers.level2;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JadenCase문자열만들기 {

    //pattern matcher이용
    public String solution(String s) {
        String answer = "";

        Pattern pattern = Pattern.compile("(\\S)(\\S*\\s*)");
        Matcher matcher = pattern.matcher(s);

        StringBuilder builder = new StringBuilder();
        while (matcher.find()) {
            builder.append(Character.toUpperCase(matcher.group(1).charAt(0)));
            builder.append(matcher.group(2).toLowerCase());
        }

        return builder.toString();
    }


}
