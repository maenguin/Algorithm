package kakao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//2018 KAKAO BLIND RECRUITMENT
public class 압축 {

    public int[] solution(String msg) {
        int[] answer = {};

        int indexNo = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 'A'; i <= 'Z'; i++) {
            map.put(Character.toString(i), indexNo++);
        }

        List<Integer> indexNoList = new ArrayList<>();
        int begIndex = 0;
        int endIndex = 1;
        int tempIndexNo = 0;

        while (endIndex <= msg.length()) {
            String w = msg.substring(begIndex, endIndex);
            if (map.containsKey(w)) {
                tempIndexNo = map.get(w);
                if (endIndex == msg.length()) {
                    indexNoList.add(tempIndexNo);
                }
                endIndex++;
            } else {
                map.put(w, indexNo++);
                indexNoList.add(tempIndexNo);
                begIndex = endIndex -1;
            }
        }

        return indexNoList.stream().mapToInt(Integer::intValue).toArray();
    }


}
