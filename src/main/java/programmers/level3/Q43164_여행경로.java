package programmers.level3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/43164
//문제 유형 : 그래프 탐색
//풀이 방법 : DFS
public class Q43164_여행경로 {

    private List<String[]> candidates = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        Map<String, List<String>> adjMap = new HashMap<>();
        for (String[] ticket : tickets) {
            adjMap.computeIfAbsent(ticket[0], s -> new ArrayList<>()).add(ticket[1]);
        }
        String[] output = new String[tickets.length + 1];
        output[0] = "ICN";
        dfs(adjMap, output, "ICN", 1, tickets.length + 1);
        candidates.sort((o1, o2) -> {
            for (int i = 0; i < o1.length; i++) {
                if (!o1[i].equals(o2[i])) {
                    return o1[i].compareTo(o2[i]);
                }
            }
            return 0;
        });
        return candidates.get(0);
    }

    private void dfs(Map<String, List<String>> adjMap, String[] output, String next, int depth, int n) {
        if (depth == n) {
            candidates.add(output.clone());
            return;
        }
        List<String> airports = adjMap.get(next);
        if (airports == null) return;
        for (int i = 0; i < airports.size(); i++) {
            String airport = airports.get(i);
            if (airport.isEmpty()) continue;
            output[depth] = airport;
            airports.set(i, "");
            dfs(adjMap, output, airport, depth + 1, n);
            airports.set(i, airport);
        }
    }
}
