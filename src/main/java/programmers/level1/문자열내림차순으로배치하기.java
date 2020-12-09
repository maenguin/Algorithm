package programmers.level1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class 문자열내림차순으로배치하기 {

    public String solution(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new StringBuilder(String.valueOf(chars)).reverse().toString();


//        String[] split = s.split("");
//        Arrays.sort(split, Comparator.reverseOrder());
//        return String.join("",split);
//
//        return Arrays.stream(s.split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
//        return s.chars().boxed().sorted(Collections.reverseOrder()).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

}
