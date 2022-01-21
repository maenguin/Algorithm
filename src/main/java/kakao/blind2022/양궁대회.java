package kakao.blind2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/92342
//노션 링크 : https://delirious-sock-4dc.notion.site/42c0245c67504efcbeae9859e2e64474
//문제 유형 : 브루트 포스
//풀이 방법 : 중복조합
public class 양궁대회 {

    private int[] apeachInfo;
    private int maxScoreGap = 1;
    private Map<Integer, List<int[]>> candidatesMap = new HashMap<>();
    public int[] solution(int n, int[] info) {
        apeachInfo = info;
        repeatedCombination2(n, new int[info.length], 0, 0);
        List<int[]> candidates = candidatesMap.get(maxScoreGap);
        if (candidates == null || candidates.isEmpty()) return new int[]{-1};
        if (candidates.size() == 1) return candidates.get(0);
        candidates.sort((o1, o2) -> {
            for (int i = o1.length - 1; i >= 0 ; i--) {
                int compare = Integer.compare(o2[i], o1[i]);
                if (compare != 0) return compare;
            }
            return 0;
        });
        return candidates.get(0);
    }

    public void repeatedCombination(int n, int[] ryanInfo, int shootCount, int start) {
        if (shootCount == n) {
            int scoreDiff = calculateScoreGap(ryanInfo);
            if (scoreDiff >= maxScoreGap) {
                candidatesMap.computeIfAbsent(scoreDiff, integer -> new ArrayList<>()).add(ryanInfo.clone());
                maxScoreGap = scoreDiff;
            }
            return;
        }
        for (int i = start; i < ryanInfo.length; i++) {
            ryanInfo[i]++;
            repeatedCombination(n, ryanInfo, shootCount + 1, i);
            ryanInfo[i]--;
        }
    }

    public void repeatedCombination2(int n, int[] ryanInfo, int index, int shootCount) {
        if (shootCount == n) {
            int scoreDiff = calculateScoreGap(ryanInfo);
            if (scoreDiff >= maxScoreGap) {
                candidatesMap.computeIfAbsent(scoreDiff, integer -> new ArrayList<>()).add(ryanInfo.clone());
                maxScoreGap = scoreDiff;
            }
            return;
        }
        if (index >= ryanInfo.length) return;
        ryanInfo[index]++;
        repeatedCombination2(n, ryanInfo, index, shootCount + 1);
        ryanInfo[index]--;
        repeatedCombination2(n, ryanInfo, index + 1, shootCount);
    }

    private int calculateScoreGap(int[] ryanInfo) {
        int score = 0;
        for (int i = 0; i < ryanInfo.length; i++) {
            if (ryanInfo[i] == 0 && apeachInfo[i] == 0) continue;
            score += ryanInfo[i] > apeachInfo[i] ? 10 - i : -(10 - i);
        }
        return score;
    }

}
