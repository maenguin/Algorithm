package kakao.blind2022;

import java.util.ArrayList;

//문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/92343
//노션 링크 : https://delirious-sock-4dc.notion.site/9d1c996b41a842f7bfb2f11ab478de97
//문제 유형 : 그래프 탐색
//풀이 방법 : DFS, 비트마스크
public class 양과늑대 {

    private ArrayList<Integer>[] adjList;
    private int[] info;
    private int answer;

    public int solution(int[] info, int[][] edges) {
        answer = 0;
        this.info = info;
        adjList = new ArrayList[info.length];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adjList[from].add(to);
            adjList[to].add(from);
        }
        dfs( 0, -1, 0, 0, 0);
        return answer;
    }

    private void dfs(int cur, int parent, int lamb, int wolf, int state) {
        boolean stateChanged = (state & (1 << cur)) == 0;
        lamb += stateChanged && info[cur] == 0 ? 1 : 0;
        wolf += stateChanged && info[cur] == 1 ? 1 : 0;
        if (lamb <= wolf) return;
        answer = Math.max(answer, lamb);
        state = state | (1 << cur);
        for (Integer next : adjList[cur]) {
            if (!(stateChanged && info[cur] == 0) && next == parent) continue;
            dfs(next, cur, lamb, wolf, state);
        }
    }
}
