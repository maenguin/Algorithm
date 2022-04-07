
package baekJoon;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/14226
//노션 링크 : https://delirious-sock-4dc.notion.site/16953-A-B-769832b7f59f4612a5e5de86651bf3c5
//알고 리즘 : 그래프 이론, 그래프 탐색, BFS, DP
public class P14226_이모티콘_Re {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        bfs(s);
    }

    static void bfs(int s) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0, 0});
        int MAX = 2 * s;
        boolean[][] visited = new boolean[MAX][MAX];
        while (!queue.isEmpty()) {
            int[] curNode = queue.poll();
            int emoticonCount = curNode[0];
            int clipboard = curNode[1];
            int second = curNode[2];
            if (emoticonCount == s) {
                System.out.println(second);
                return;
            }
            if (emoticonCount != clipboard && !visited[emoticonCount][emoticonCount]) {
                visited[emoticonCount][emoticonCount] = true;
                queue.offer(new int[]{ emoticonCount, emoticonCount, second + 1});
            }
            if (emoticonCount + clipboard < MAX && !visited[emoticonCount + clipboard][clipboard]) {
                visited[emoticonCount + clipboard][clipboard] = true;
                queue.offer(new int[]{ emoticonCount + clipboard, clipboard, second + 1});
            }
            if (emoticonCount - 1 > 0 && !visited[emoticonCount - 1][clipboard]) {
                visited[emoticonCount - 1][clipboard] = true;
                queue.offer(new int[]{ emoticonCount - 1, clipboard, second + 1});
            }
        }
    }

}
