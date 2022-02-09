package kakao.Intern2021;

//문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/81302
//노션 링크 : https://delirious-sock-4dc.notion.site/cd5ddc16920549aba706f968e43880b1
//문제 유형 : 그래프 탐색, 그래프 이론
//풀이 방법 : DFS
public class 거리두기확인하기 {

    private int[] dx = {-1,0,0,1};
    private int[] dy = {0,-1,1,0};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int i = 0;
        for (String[] place : places) {
            answer[i++] = check(place);
        }
        return answer;
    }

    private int check(String[] place) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i].charAt(j) != 'P') continue;
                boolean[][] visited = new boolean[5][5];
                if (!dfs(place, visited, i, j, 0)) return 0;
            }
        }
        return 1;
    }

    private boolean dfs(String[] place, boolean[][] visited, int x, int y, int depth) {
        visited[x][y] = true;
        if (depth != 0 && place[x].charAt(y) == 'P') return false;
        if (depth == 2) return true;
        boolean keepDistance = true;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (0 <= nx && nx < 5 && 0 <= ny && ny < 5 && place[nx].charAt(ny) != 'X' && !visited[nx][ny]) {
                keepDistance &= dfs(place, visited, nx, ny, depth + 1);
            }
        }
        return keepDistance;
    }

}
