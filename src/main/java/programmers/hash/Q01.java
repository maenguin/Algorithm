package programmers.hash;

import java.util.HashMap;


/*
 * 완주하지 못한 선수
 * 프로그래머스 해시 문제
 * 풀고나서 다른 분의 답안을 봤는데 getOrDefault를 통해 정말 깔끔하게
 * 코드를 작성하셔서 놀랐다.
 *
 *
 */

public class Q01 {


    public String solution(String[] participant, String[] completion) {

        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (String p : completion) {
            if (hashMap.containsKey(p)) {
                int i = hashMap.get(p) + 1;
                hashMap.replace(p, i);
                continue;
            }
            hashMap.put(p, 1);


        }

        for (String p : participant) {
            if (hashMap.containsKey(p) && hashMap.get(p) > 0) {
                int i = hashMap.get(p) - 1;
                hashMap.replace(p, i);
                continue;
            }
            answer = p;
        }
        return answer;
    }
    public String betterSolution(String[] participant, String[] completion) {

        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (String player : participant) hashMap.put(player, hashMap.getOrDefault(player,0) + 1 );
        for (String player : completion) hashMap.put(player, hashMap.get(player) - 1 );

        for (String key : hashMap.keySet()) {
            if (hashMap.get(key) != 0 ) {
                answer = key;
            }

        }
        return answer;
    }

}
