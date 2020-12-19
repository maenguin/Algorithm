package kakao;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//2018 KAKAO BLIND
public class 다트게임 {

    public int solution(String dartResult) {
        int answer = 0;

        HashMap<String, Integer> map = new HashMap<>(){
            {
                put("S",1);
                put("D",2);
                put("T",3);
                put("#",-1);
                put("*",2);
            }
        };

        List<DartGameSet> dartGameSets = DartGameSet.getDartGameSet(dartResult);

        for (int i = 0; i < dartGameSets.size(); i++) {
            DartGameSet set = dartGameSets.get(i);
            set.resultScore = (int)Math.pow(set.score, map.get(set.bonus));

            if (set.option.equals("#")) {
                set.resultScore *= map.get(set.option);
            } else if (set.option.equals("*")) {
                set.resultScore *= map.get(set.option);
                if (i != 0) {
                    DartGameSet preSet = dartGameSets.get(i-1);
                    preSet.resultScore *= map.get(set.option);
                }
            }
        }

        for (int i = 0; i < dartGameSets.size(); i++) {
            answer += dartGameSets.get(i).resultScore;
        }

        return answer;
    }


    static class DartGameSet {

        private int score;
        private int resultScore;
        private String bonus;
        private String option;

        public static List<DartGameSet> getDartGameSet(String dartResult) {

            List<DartGameSet> list = new ArrayList<>();
            Pattern pattern = Pattern.compile("([0-9]|10)([SDT])([*#])?");
            Matcher matcher = pattern.matcher(dartResult);

            while (matcher.find()) {
                DartGameSet set = new DartGameSet();
                set.score = Integer.parseInt(matcher.group(1));
                set.bonus = matcher.group(2);
                set.option = matcher.group(3) == null ? "" : matcher.group(3);
                list.add(set);
            }
            return list;
        }
    }

}
