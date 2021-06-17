package kakao.blind2021;

import java.awt.*;
import java.util.*;
import java.util.List;

//https://programmers.co.kr/learn/courses/30/lessons/72411
public class 메뉴리뉴얼 {


    //문제 접근
    //1. 각각의 주문 메뉴에 대해 코스에 해당하는 조합을 모두 구한다.
    // ex) 주문 메뉴가 ABC 이고 코스가 2,3 이면 AB, BC, AC, ABC
    //2. 조합을 map<조합이름, 조합주문수>로 하는 map에 저장한다.
    //3. 코스 주문수의 최댓값 배열을 만들고 map을 순회하면서 각각의 코스에 대한 최댓값을 구한다.
    //4. 다시 map을 순회하면서 최댓값과 같은 조합을 모두 찾는다.

    private Map<String, Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        for (String order : orders) {
            char[] menus = order.toCharArray();
            Arrays.sort(menus);

            for (int i : course) {
                if (i > menus.length) {
                    break;
                }
                go("",0,i,menus);
            }
        }

        int[] courseMax = new int[11];

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int length = entry.getKey().length();
            courseMax[length] = Math.max(courseMax[length], entry.getValue());
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (courseMax[entry.getKey().length()] >= 2 && courseMax[entry.getKey().length()] == entry.getValue()) {
                answer.add(entry.getKey());
            }
        }

        Collections.sort(answer);

        return answer.toArray(new String[answer.size()]);
    }


    public void go(int index, int selected, int n, int m, char[] output, char[] menus) {
        if (selected == m) {
            String key = String.valueOf(output);
            map.put(key, map.getOrDefault(key,0) + 1);
            return;
        }
        if (index >= n) return;
        output[selected] = menus[index];
        go(index + 1, selected + 1, n, m,output,menus);
        go(index + 1, selected, n, m,output,menus);
    }

    public void go(String s, int index,int m, char[] menus) {
        if (s.length() == m) {
            map.put(s, map.getOrDefault(s,0) + 1);
            return;
        }
        if (index >= menus.length) return;
        go(s + menus[index], index + 1, m,menus);
        go(s, index + 1, m,menus);
    }
}
