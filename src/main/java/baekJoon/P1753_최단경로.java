package baekJoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/1753
//노션 링크 : https://delirious-sock-4dc.notion.site/1753-22a4976a95b447d8a5e735dfe3969d38
//문제 유형 : 최단경로
//풀이 방법 : 다익스트라, 우선순위큐
public class P1753_최단경로 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int start = sc.nextInt();
        ArrayList<Edge>[] adjList = new ArrayList[v + 1];
        for (int i = 1; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            adjList[from].add(new Edge(to, weight));
        }
        int[] distances = dijkstraWithPriorityQueue(adjList, start);
        for (int i = 1; i < distances.length; i++) {
            System.out.println(distances[i] == 1e9 ? "INF" : distances[i]);
        }
    }

    private static int[] dijkstraWithPriorityQueue(ArrayList<Edge>[] adjList, int start) {
        int[] distance = new int[adjList.length];
        Queue<Vertex> queue = new PriorityQueue<>();
        Arrays.fill(distance, (int)1e9);
        distance[start] = 0;
        queue.offer(new Vertex(start, 0));
        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            if (distance[v.no] < v.distance) continue;
            for (Edge e : adjList[v.no]) {
                if (distance[e.no] > v.distance + e.weight) {
                    distance[e.no] = v.distance + e.weight;
                    queue.offer(new Vertex(e.no, distance[e.no]));
                }
            }
        }
        return distance;
    }

    static class Vertex implements Comparable<Vertex> {
        int no;
        int distance;

        public Vertex(int no, int distance) {
            this.no = no;
            this.distance = distance;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.distance,o.distance);
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
