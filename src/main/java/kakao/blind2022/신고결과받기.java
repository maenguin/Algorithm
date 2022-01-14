package kakao.blind2022;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/92334
//문제 유형 : 자료구조
public class 신고결과받기 {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, User> userMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            userMap.put(id_list[i], new User(i));
        }
        for (String s : report) {
            String[] split = s.split(" ");
            userMap.get(split[1]).reportMeUserSet.add(split[0]);
        }
        for (User user : userMap.values()) {
            if (user.reportMeUserSet.size() >= k) {
                for (String reportMeUser : user.reportMeUserSet) {
                    answer[userMap.get(reportMeUser).index]++;
                }
            }
        }
        return answer;
    }

    private static class User {
        int index;
        Set<String> reportMeUserSet;

        public User(int index) {
            this.index = index;
            reportMeUserSet = new HashSet<>();
        }
    }

}
