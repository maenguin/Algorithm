package kakao.blind2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 합승택시요금 {

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

}
