package kakao.blind2022;

import java.util.HashMap;
import java.util.Map;

//문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/92341
//문제 유형 : 자료구조
public class 주차요금계산 {

    public int[] solution(int[] fees, String[] records) {
        int end = timeToMin("23:59");
        Map<String, int[]> map = new HashMap<>();
        for (String record : records) {
            String[] split = record.split(" ");
            if (!map.containsKey(split[1])) {
                map.put(split[1], new int[2]);
            }
            map.get(split[1])[0] += "IN".equals(split[2]) ? -timeToMin(split[0]) : timeToMin(split[0]);
            map.get(split[1])[1] = "IN".equals(split[2]) ? 0 : 1;
        }
        for (int[] value : map.values()) {
            value[0] += value[1] == 0 ? end : 0;
        }
        return map.keySet().stream().sorted().mapToInt(v -> calculateFee(fees, map.get(v)[0])).toArray();
    }

    private int timeToMin(String hhmm) {
        String[] split = hhmm.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    private int calculateFee(int[] fees, int minutes) {
        if (minutes <= fees[0]) return fees[1];
        return fees[1] + (int) Math.ceil((minutes - fees[0]) / (double)fees[2]) * fees[3];
    }
}
