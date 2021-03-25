package utils;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Graph {
    private int n; //정점의 개수
    private int[][] graph; //정점간의 거리 정보
    private int[] prev; //출발지까지 가장 빠르게 갈 수 있다고 계산된 이웃 노드를 가리킨다.

    public Graph(int n) {
        this.n = n;
        graph = new int[n][n];
        prev = new int[n];
    }

    public void input(int i, int j, int w) {
        if (graph[i][j] == 0) {
            graph[i][j] = w;
            graph[j][i] = w;
        } else {
            if (graph[i][j] > w){
                graph[i][j] = w;
                graph[j][i] = w;
            }
        }
    }

    public int[] dijkstra(int start){
        int[] distance = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i < n+1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[start] = 0;
        visited[start] = true;

        for (int i = 1; i < n+1; i++) {
            if (!visited[i] && graph[start][i] != 0) {
                distance[i] = graph[start][i];
            }
        }

        for (int i = 0; i < n - 1; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int j = 1; j < n + 1; j++) {
                if (!visited[j] && distance[j] != Integer.MAX_VALUE && distance[j] < min) {
                    min = distance[j];
                    minIndex = j;
                }
            }

            visited[minIndex] = true;

            for (int j = 1; j < n + 1; j++) {

                if (!visited[j] && graph[minIndex][j] != 0 && distance[j] > distance[minIndex] + graph[minIndex][j]) {
                    distance[j] = distance[minIndex] + graph[minIndex][j];
                }

            }


        }
        return distance;
    }




    //우선순위큐를 사용해 성능을 개선한 버전 O(nlogn)
    public int[] dijkstraWithPriorityQueue(int start) {

        int[] distance = new int[n]; //정점별 최소거리
        boolean[] visited = new boolean[n]; //정점별 방문여무
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        //정점별 최소거리를 무한으로 초기화
        Arrays.fill(distance, Integer.MAX_VALUE);
        //시작 정점의 거리를 0으로 초기화
        distance[start] = 0;
        prev[start] = start;

        queue.offer(new Vertex(start, distance[start]));
        while (!queue.isEmpty()) {

            Vertex vertex = queue.poll();
            visited[vertex.no] = true;

            for (int i = 0; i < n; i++) {
                //방문하지 않은 연결된 정점을 찾고 최소거리를 갱신
                if (!visited[i] && graph[vertex.no][i] != 0 && distance[i] > distance[vertex.no] + graph[vertex.no][i]){
                    distance[i] = distance[vertex.no] + graph[vertex.no][i];
                    prev[i] = vertex.no;
                    //갱신된 정점을 우선순위 큐에 저장, 최소거리가 짧은 순서대로 poll됨
                    queue.offer(new Vertex(i, distance[i]));
                }
            }
        }
        printPrev(start);


        return distance;
    }

    //정점별 최단 루트 출력하기
    private void printPrev(int start) {
        System.out.println("Arrays.toString(prev) = " + Arrays.toString(prev));

        for (int i = 0; i < n; i++) {
            if (i == start)
                continue;

            int route = i;
            StringBuilder builder = new StringBuilder(start);
            do {
                route = prev[route];
                builder.insert(0,route + " ");
            } while (route != start);
            System.out.println(i+" = " + builder);
        }
    }

    static class Vertex implements Comparable<Vertex> {
        private int no;
        private int distance;

        public Vertex(int no, int distance) {
            this.no = no;
            this.distance = distance;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.distance,o.distance);
        }
    }

}