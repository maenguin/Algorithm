package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//2019 KAKAO BLIND RECRUITMENT
public class 오픈채팅방 {

    public String[] solution(String[] record) {

        HashMap<String, String> map = new HashMap<>();
        int answerSize = 0;
        for (int i = 0; i < record.length; i++) {
            String s = record[i];
            String[] split = s.split(" ");
            if (split.length > 2 ) {
                map.put(split[1], split[2]);
            }
            if (!split[0].equals("Change")) {
                answerSize++;
            }
        }

        String[] answer = new String[answerSize];
        int answerIndex = 0;
        for (int i = 0; i < record.length; i++) {
            String s = record[i];
            String[] split = s.split(" ");
            switch (split[0]) {
                case "Enter": answer[answerIndex++] = map.get(split[1]) + "님이 들어왔습니다."; break;
                case "Leave": answer[answerIndex++] = map.get(split[1]) + "님이 나갔습니다."; break;
                default: break;
            }
        }

        return answer;
    }


}
