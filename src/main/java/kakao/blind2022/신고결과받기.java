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
        for (String id : id_list) {
            userMap.put(id, new User(id));
        }
        for (String s : report) {
            String[] split = s.split(" ");
            userMap.get(split[1]).reportMeUserSet.add(split[0]);
        }
        for (User user : userMap.values()) {
            if (user.reportMeUserSet.size() >= k) {
                for (String reportMeUser : user.reportMeUserSet) {
                    userMap.get(reportMeUser).receivedEmailCount++;
                }
            }
        }
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = userMap.get(id_list[i]).receivedEmailCount;
        }
        return answer;
    }

    private static class User {
        String name;
        int receivedEmailCount;
        Set<String> reportMeUserSet;

        public User(String name) {
            this.name = name;
            reportMeUserSet = new HashSet<>();
        }
    }

}
