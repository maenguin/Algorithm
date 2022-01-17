package programmers.level3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/43163
//문제 유형 : 최단거리
//풀이 방법 : BFS
public class Q43163_단어변환 {

    public int solution(String begin, String target, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, -1);
        }
        if (!map.containsKey(target)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        map.put(begin, 0);
        while (!queue.isEmpty()) {
            String curWord = queue.poll();
            if (curWord.equals(target)) break;
            for (String nextWord : map.keySet()) {
                if (map.get(nextWord) == -1 && isOneCharDifference(curWord, nextWord)) {
                    queue.offer(nextWord);
                    map.put(nextWord, map.get(curWord) + 1);
                }
            }
        }
        return map.get(target);
    }

    private boolean isOneCharDifference(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            count += s1.charAt(i) != s2.charAt(i) ? 1 : 0;
            if (count > 1) return false;
        }
        return true;
    }
}
