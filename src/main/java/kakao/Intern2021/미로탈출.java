package kakao.Intern2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/81304
//노션 링크 : https://delirious-sock-4dc.notion.site/a8b6b6b1d792451499c15bf91330dfbe
//알고 리즘 : 다익스트라
public class 미로탈출 {

    private ArrayList<Edge>[] adjList;
    private int[][] distance;
    private static Map<Integer, Integer> trapMap = new HashMap<>();

    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        for (int i = 0; i < traps.length; i++) {
            trapMap.put(traps[i], i);
        }
        adjList = new ArrayList[n + 1];
        for (int i = 1; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];
            int hour = road[2];
            adjList[from].add(new Edge(to, hour, false, trapMap.containsKey(to)));
            adjList[to].add(new Edge(from, hour, true, trapMap.containsKey(from)));
        }
        distance = new int[adjList.length][1 << traps.length + 1];
        for (int[] ints : distance) {
            Arrays.fill(ints, (int)1e9);
        }
        dijkstra(start);
        int answer = (int) 1e9;
        for (int dist : distance[end]) {
            answer = Math.min(answer, dist);
        }
        return answer;
    }

    private void dijkstra(int start) {
        Queue<Vertex> queue = new PriorityQueue<>();
        distance[start][0] = 0;
        queue.offer(new Vertex(start, 0, 0, false));
        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            for (Edge e : adjList[v.no]) {
                if (!e.canUse(v)) continue;
                int nextState = e.isTrapVertex ? v.state ^ (1 << trapMap.get(e.vertexNo)) : v.state;
                if (distance[e.vertexNo][nextState] > v.distance + e.weight) {
                    distance[e.vertexNo][nextState] = v.distance + e.weight;
                    queue.offer(new Vertex(e.vertexNo, distance[e.vertexNo][nextState], nextState, trapMap.containsKey(e.vertexNo)));
                }
            }
        }
    }

    private static class Vertex implements Comparable<Vertex> {
        int no;
        int distance;
        int state;
        boolean isTrap;

        public Vertex(int no, int distance, int state, boolean isTrap) {
            this.no = no;
            this.distance = distance;
            this.state = state;
            this.isTrap = isTrap;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.distance,o.distance);
        }

    }

    private static class Edge {
        int vertexNo;
        int weight;
        boolean isTrapEdge;
        boolean isTrapVertex;

        public Edge(int vertexNo, int weight, boolean isTrapEdge, boolean isTrapVertex) {
            this.vertexNo = vertexNo;
            this.weight = weight;
            this.isTrapEdge = isTrapEdge;
            this.isTrapVertex = isTrapVertex;
        }

        public boolean canUse(Vertex current) {
            if (current.isTrap && this.isTrapVertex) {
                boolean curOn = (current.state & (1 << trapMap.get(current.no))) != 0;
                boolean nextOn = (current.state & (1 << trapMap.get(this.vertexNo))) != 0;
                if (curOn != nextOn) {
                    return isTrapEdge;
                } else {
                    return !isTrapEdge;
                }
            }
            if (!current.isTrap && this.isTrapVertex) {
                boolean nextOn = (current.state & (1 << trapMap.get(this.vertexNo))) != 0;
                return nextOn == isTrapEdge;
            }
            if (current.isTrap && !this.isTrapVertex) {
                boolean curOn = (current.state & (1 << trapMap.get(current.no))) != 0;
                return curOn == isTrapEdge;
            }
            return !isTrapEdge;
        }

    }

}
