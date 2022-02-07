package kakao.Intern2021;

import java.util.HashMap;
import java.util.Map;

//문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/81301
//노션 링크 : https://delirious-sock-4dc.notion.site/ed2501dc265a4de28220f859527960a1
//문제 유형 : 문자열
public class 숫자문자열과영단어 {

    public int solution(String s) {
        Map<String, int[]> map = new HashMap<>();
        map.put("zer", new int[]{0, 4});
        map.put("one", new int[]{1, 3});
        map.put("two", new int[]{2, 3});
        map.put("thr", new int[]{3, 5});
        map.put("fou", new int[]{4, 4});
        map.put("fiv", new int[]{5, 4});
        map.put("six", new int[]{6, 3});
        map.put("sev", new int[]{7, 5});
        map.put("eig", new int[]{8, 5});
        map.put("nin", new int[]{9, 4});

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                int[] ints = map.get(s.substring(i, i + 3));
                sb.append(ints[0]);
                i += ints[1] - 1;
            }
        }
        return Integer.parseInt(sb.toString());
    }

}
