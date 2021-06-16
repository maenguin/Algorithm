package kakao.blind2021;

import java.util.*;

public class 순위검색 {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        String[] langs = new String[]{"cpp", "java", "python", "-"};
        String[] jobGroups = new String[]{"backend", "frontend", "-"};
        String[] careers = new String[]{"junior", "senior", "-"};
        String[] foods = new String[]{"chicken", "pizza", "-"};
        Map<String, List<Integer>> map = new HashMap<>();
        for (String lang : langs) {
            for (String jobGroup : jobGroups) {
                for (String career : careers) {
                    for (String food : foods) {
                        map.put(lang + jobGroup + career + food, new ArrayList<>());
                    }
                }
            }
        }


        for (String s : info) {
            String[] sp = s.split(" ");
            for (String lang : langs) {
                if (lang.equals(sp[0]) || lang.equals("-")) {
                    for (String jobGroup : jobGroups) {
                        if (jobGroup.equals(sp[1]) || jobGroup.equals("-")) {
                            for (String career : careers) {
                                if (career.equals(sp[2]) || career.equals("-")) {
                                    for (String food : foods) {
                                        if (food.equals(sp[3]) || food.equals("-")) {
                                            map.get(lang+jobGroup+career+food).add(Integer.parseInt(sp[4]));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }

        for (List<Integer> value : map.values()) {
            Collections.sort(value);
        }

        int i = 0;
        for (String s : query) {
            String[] sp = s.split(" and ");
            String lang = sp[0];
            String jobGroup = sp[1];
            String career = sp[2];
            String[] sp2 = sp[3].split(" ");
            String food = sp2[0];

            List<Integer> list = map.get(lang + jobGroup + career + food);
            int key = lowerBound(list, Integer.parseInt(sp2[1]));
            answer[i++] = list.size() - key;
        }

        return answer;
    }

    public int lowerBound(List<Integer> list,  int value) {
        int low = 0;
        int high = list.size();
        while (low < high) {
            final int mid = low + (high - low)/2;
            if (value <= list.get(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}
