package kakao.blind2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 합승택시요금 {

    //dijkstra 사용 O((E+V)logV)
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        ArrayList<Edge>[] adjList = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < fares.length; i++) {
            int from = fares[i][0];
            int to = fares[i][1];
            int weight = fares[i][2];
            adjList[from].add(new Edge(to,weight));
            adjList[to].add(new Edge(from,weight));
        }

        for (int i = 1; i <= n; i++) {
            int[] dist = dijkstra(i, adjList);
            //s -> i 가는 최단 거리는 i -> s가는 최단 거리와 같으므로 i에 대한 dist 배열을 구하고 dist[s]를 사용
            answer = Math.min(answer, dist[s] + dist[a] + dist[b]);
        }

        return answer;
    }


    private int[] dijkstra(int start, ArrayList<Edge>[] adjList) {
        int[] dist = new int[adjList.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        queue.offer(new Vertex(start,0));
        dist[start] = 0;


        while (!queue.isEmpty()) {
            Vertex v = queue.poll();

            //최단거리 갱신 후 큐에 들어 갔지만 꺼내기전에 다른 경로에 의해 다시 최단거리가 갱신된 정점
            if (dist[v.no] < v.dist) {
                continue;
            }
            for (Edge e : adjList[v.no]) {
                if (dist[e.no] > v.dist + e.weight) {
                    dist[e.no] = v.dist + e.weight;
                    queue.offer(new Vertex(e.no, dist[e.no]));
                }
            }
        }

        return dist;
    }

    static class Vertex implements Comparable<Vertex> {
        int no;
        int dist;

        public Vertex(int no, int dist) {
            this.no = no;
            this.dist = dist;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.dist,o.dist);
        }
    }

    static class Edge {
        int no;
        int weight;

        public Edge(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }
    }



    //floyd 사용 O(N^3) N제한이 200이라 사용가능
    public int solution2(int n, int s, int a, int b, int[][] fares) {

        int MAX_VALUE = 1 << 24;
        int answer = MAX_VALUE;

        int[][] d = new int[n + 1][n + 1];
        //Integer.MAX_VALUE로 초기화 하면 floyd 사용시 오버플로우가 발생해서 음수 값이 저장될 수 도 있다.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    d[i][j] = MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < fares.length; i++) {
            int from = fares[i][0];
            int to = fares[i][1];
            int weight = fares[i][2];
            d[from][to] = weight;
            d[to][from] = weight;
        }

        floyd(d);

        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, d[s][i] + d[i][a] + d[i][b]);
        }

        return answer;
    }

    private void floyd(int[][] d) {
        for (int k = 1; k < d.length; k++) {
            for (int i = 1; i < d.length; i++) {
                for (int j = 1; j < d.length; j++) {
                    if (d[i][j] > d[i][k] + d[k][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }
    }


}
