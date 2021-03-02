package kakao;

import java.util.*;

//2018 KAKAO BLIND RECRUITMENT
public class 뉴스클러스터링 {

    public int solution(String str1, String str2) {
        int answer = 0;
        int intersection = 0;
        int union = 0;
        String s1 = str1.toUpperCase();
        String s2 = str2.toUpperCase();

        HashMap<String, Integer> map1 = createMultiset(s1);
        HashMap<String, Integer> map2 = createMultiset(s2);

        if (map1.isEmpty() && map2.isEmpty()) {
            return 65536;
        }
        for (String key1 : map1.keySet()) {
            for (String key2 : map2.keySet()) {
                if (key1.equals(key2)) {
                    intersection += Math.min(map1.get(key1), map2.get(key2));
                    break;
                }
            }
        }

        union = getSize(map1) + getSize(map2) - intersection;
        answer = (int)(((double)intersection / union) * 65536);

        return answer;
    }

    private Integer getSize(HashMap<String, Integer> map1) {
        Integer size = 0;
        for (Integer value : map1.values()) {
            size += value;
        }
        return size;
    }

    private HashMap<String, Integer> createMultiset(String s) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i + 1 < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            if (Character.isAlphabetic(c1) && Character.isAlphabetic(c2)) {
                String item = String.valueOf(c1) + c2;
                hashMap.put(item, hashMap.getOrDefault(item,0) +1 );
            }
        }
        return hashMap;
    }

}
