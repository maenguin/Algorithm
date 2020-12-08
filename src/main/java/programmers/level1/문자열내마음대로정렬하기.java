package programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

public class 문자열내마음대로정렬하기 {

    public String[] solution(String[] strings, int n) {

        Arrays.sort(strings, (s1, s2) ->
        {
            char c1 = s1.charAt(n);
            char c2 = s2.charAt(n);
            return c1 > c2 ? 1 : (c1 < c2 ? -1 : s1.compareTo(s2) );
        } );

        return strings;
    }

}
