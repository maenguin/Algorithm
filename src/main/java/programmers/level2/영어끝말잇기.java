package programmers.level2;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class 영어끝말잇기 {

    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};

        Set<String> wordSet = new HashSet<>();
        String preWord = words[0].substring(0,1);
        int seq = 1;
        for (String word : words) {

            if (wordSet.contains(word) || !word.startsWith(preWord.substring(preWord.length() - 1))) {
                int no = (seq % n) == 0 ? n : (seq % n);
                int turn = (int)Math.ceil((double)seq/n);
                answer[0] = no;
                answer[1] = turn;
                break;
            }
            preWord = word;
            wordSet.add(word);
            seq++;
        }

        return answer;
    }


}
