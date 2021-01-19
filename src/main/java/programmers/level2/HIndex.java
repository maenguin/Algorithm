package programmers.level2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HIndex {

    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = citations.length -1; i >= 0; i--) {
            int citation = citations[i];
            if (citation < citations.length - i) {
                break;
            }
            answer++;
        }

        return answer;
    }

}
