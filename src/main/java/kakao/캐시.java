package kakao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

//2018 KAKAO BLIND RECRUITMENT
public class 캐시 {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        LinkedList<String> queue = new LinkedList<>();
        for (String city : cities) {
            String cityUpper = city.toUpperCase();

            if (queue.contains(cityUpper)) {
                answer += 1;
                queue.remove(cityUpper);
                queue.offer(cityUpper);
                continue;
            }

            answer += 5;
            if (queue.size() >= cacheSize) {
                queue.pollFirst();
            }
            queue.offer(cityUpper);
        }

        return answer;
    }
}
