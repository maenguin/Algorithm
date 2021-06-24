package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/14226
public class P14226_이모티콘 {

    /*
    [문제설명]
    영선이는 매우 기쁘기 때문에, 효빈이에게 스마일 이모티콘을 S개 보내려고 한다.

    영선이는 이미 화면에 이모티콘 1개를 입력했다. 이제, 다음과 같은 3가지 연산만 사용해서 이모티콘을 S개 만들어 보려고 한다.

    화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
    클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
    화면에 있는 이모티콘 중 하나를 삭제한다.
    모든 연산은 1초가 걸린다.
    또, 클립보드에 이모티콘을 복사하면 이전에 클립보드에 있던 내용은 덮어쓰기가 된다.
    클립보드가 비어있는 상태에는 붙여넣기를 할 수 없으며, 일부만 클립보드에 복사할 수는 없다.
    또한, 클립보드에 있는 이모티콘 중 일부를 삭제할 수 없다.
    화면에 이모티콘을 붙여넣기 하면, 클립보드에 있는 이모티콘의 개수가 화면에 추가된다.

    영선이가 S개의 이모티콘을 화면에 만드는데 걸리는 시간의 최솟값을 구하는 프로그램을 작성하시오.

    [시간제한]
    2 초

    [메모리 제한]
    512  MB

    [입력]
    첫째 줄에 S (2 ≤ S ≤ 1000) 가 주어진다.

    [출력]
    첫째 줄에 이모티콘을 S개 만들기 위해 필요한 시간의 최솟값을 출력한다.

     */

    //BFS로 최단거리를 구하는 형태로 접근
    //이모티콘 개수와 클립보드의 이모티콘 개수에 따라서 정점이 다르다고 볼 수 있다.
    //왠지는 모르겠는데 MAX를 s로 해도 된다고 한다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int MAX = 2*s;

        int[][] dist = new int[MAX][MAX];

        Queue<Vertex> queue = new LinkedList<>();
        queue.offer(new Vertex(1, 0));
        dist[1][0] = 1;

        while (!queue.isEmpty()) {
            Vertex x = queue.poll();

            if (x.emoticonCnt == s) {
                break;
            }

            if (0 < x.emoticonCnt && x.emoticonCnt < MAX ) {

                //이모티콘 클립보드로 복사
                if (dist[x.emoticonCnt][x.emoticonCnt] == 0) {
                    queue.offer(new Vertex(x.emoticonCnt, x.emoticonCnt));
                    dist[x.emoticonCnt][x.emoticonCnt] = dist[x.emoticonCnt][x.clipboardCnt] + 1;
                }
                //클립보드 붙여넣기
                if (x.emoticonCnt + x.clipboardCnt < MAX && dist[x.emoticonCnt + x.clipboardCnt][x.clipboardCnt] == 0 ) {
                    queue.offer(new Vertex(x.emoticonCnt + x.clipboardCnt, x.clipboardCnt));
                    dist[x.emoticonCnt + x.clipboardCnt][x.clipboardCnt] = dist[x.emoticonCnt][x.clipboardCnt] + 1;
                }
                //이모티콘 제거
                if (dist[x.emoticonCnt -1][x.clipboardCnt] == 0) {
                    queue.offer(new Vertex(x.emoticonCnt -1, x.clipboardCnt));
                    dist[x.emoticonCnt -1][x.clipboardCnt] = dist[x.emoticonCnt][x.clipboardCnt] + 1;
                }
            }

        }


        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < MAX; i++) {
            if (dist[s][i] != 0) {
                ans = Math.min(dist[s][i], ans);
            }
        }
        System.out.println(ans -1);
        for (int[] ints : dist) {
            System.out.println(Arrays.toString(ints));
        }
    }

    static class Vertex {
        int emoticonCnt;
        int clipboardCnt;

        public Vertex(int emoticonCnt, int clipboardCnt) {
            this.emoticonCnt = emoticonCnt;
            this.clipboardCnt = clipboardCnt;
        }
    }


    //강의 풀이
    public static void main2(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] d = new int[n+1][n+1];
        for (int i=0; i<=n; i++) {
            Arrays.fill(d[i], -1);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        q.add(0);
        d[1][0] = 0;
        while (!q.isEmpty()) {
            int s = q.remove();
            int c = q.remove();
            if (d[s][s] == -1) {
                d[s][s] = d[s][c] + 1;
                q.add(s); q.add(s);
            }
            if (s+c <= n && d[s+c][c] == -1) {
                d[s+c][c] = d[s][c] + 1;
                q.add(s+c); q.add(c);
            }
            if (s-1 >= 0 && d[s-1][c] == -1) {
                d[s-1][c] = d[s][c] + 1;
                q.add(s-1); q.add(c);
            }
        }
        int ans = -1;
        for (int i=0; i<=n; i++) {
            if (d[n][i] != -1) {
                if (ans == -1 || ans > d[n][i]) {
                    ans = d[n][i];
                }
            }
        }
        System.out.println(ans);
    }
}