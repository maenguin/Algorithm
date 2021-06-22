package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/1697
public class P1697_숨바꼭질 {

    /*
    [문제설명]
    수빈이는 동생과 숨바꼭질을 하고 있다.
    수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
    수빈이는 걷거나 순간이동을 할 수 있다.
    만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
    순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

    수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

    [시간제한]
    2 초

    [입력]
    첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

    [출력]
    수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
     */

    //이동 시간이 1초로 동일하므로 BFS 최단거리 알고리즘을 사용할 수 있다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int MAX = 200000;
        int[] dist = new int[MAX];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        dist[n] = 1;

        while (!queue.isEmpty()) {
            Integer x = queue.poll();

            if (x == k) {
                break;
            }

            if (x - 1 >= 0 && dist[x-1] == 0) {
                queue.offer(x - 1);
                dist[x-1] = dist[x] + 1;
            }
            if (x * 2 < MAX && dist[x*2] == 0) {
                queue.offer(x*2);
                dist[x*2] = dist[x] + 1;
            }
            if (x + 1 < MAX && dist[x + 1] == 0) {
                queue.offer(x + 1);
                dist[x + 1] = dist[x] + 1;
            }
        }
        System.out.println(dist[k]-1);
    }


    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int MAX = 200000;
        ArrayList<Integer>[] adjList = new ArrayList[MAX];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int u = 0; u < MAX; u++) {
            int v1 = u+1;
            int v2 = u-1;
            int v3 = 2*u;
            if (v1 < MAX && !adjList[u].contains(v1)){
                adjList[u].add(v1);
            }
            if (v2 >= 0 && !adjList[u].contains(v2)){
                adjList[u].add(v2);
            }
            if (v3 < MAX && !adjList[u].contains(v3)){
                adjList[u].add(v3);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[MAX];
        int[] dist = new int[MAX];
        queue.offer(n);
        visited[n] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            if (x == k) {
                System.out.println(dist[x]);
                break;
            }
            for (int y : adjList[x]) {
                if (!visited[y]) {
                    queue.offer(y);
                    visited[y] = true;
                    dist[y] = dist[x] + 1;
                }
            }
        }
        System.out.println(dist[k]);

    }
}