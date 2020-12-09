package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 문자열내p와y의개수 {
    boolean solution(String s) {

        Map<Character,Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int numOfP = map.getOrDefault('p',0) + map.getOrDefault('P',0);
        int numOfY = map.getOrDefault('y',0) + map.getOrDefault('Y',0);

        return  numOfP - numOfY == 0;
    }
}
