package programmers.level2;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://programmers.co.kr/learn/courses/30/lessons/12978
public class 배달 {

    public int solution(int N, int[][] road, int K) {
        int answer = 0;


        Graph graph = new Graph(N);
        for (int i = 0; i < road.length; i++) {
            graph.input(road[i][0],road[i][1],road[i][2]);
        }
        int[] dist = graph.dijkstraWithPriorityQueue(1);
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        return answer;
    }


    static class Graph {
        private int n; //정점의 개수
        private int maps[][]; //정점간의 가중치 정보
        private int[] routes; //정점별 최단 루트 일때의 이전 정점

        public Graph(int n) {
            this.n = n;
            maps = new int[n + 1][n + 1];
            routes = new int[n+1];
        }

        public void input(int i, int j, int w) {
            if (maps[i][j] == 0) {
                maps[i][j] = w;
                maps[j][i] = w;
            } else {
                if (maps[i][j] > w){
                    maps[i][j] = w;
                    maps[j][i] = w;
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
                if (!visited[i] && maps[start][i] != 0) {
                    distance[i] = maps[start][i];
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

                    if (!visited[j] && maps[minIndex][j] != 0 && distance[j] > distance[minIndex] + maps[minIndex][j]) {
                        distance[j] = distance[minIndex] + maps[minIndex][j];
                    }

                }


            }
            return distance;
        }




        //우선순위큐를 사용해 성능을 개선한 버전 O(nlogn)
        public int[] dijkstraWithPriorityQueue(int start) {

            int[] distance = new int[n + 1]; //정점별 최소거리
            boolean[] visited = new boolean[n + 1]; //정점별 방문여무
            PriorityQueue<Vertex> queue = new PriorityQueue<>();
            //정점별 최소거리를 무한으로 초기화
            Arrays.fill(distance, Integer.MAX_VALUE);
            //시작 정점의 거리를 0으로 초기화
            distance[start] = 0;
            routes[start] = start;

            queue.offer(new Vertex(start, distance[start]));
            while (!queue.isEmpty()) {

                Vertex vertex = queue.poll();
                visited[vertex.no] = true;

                for (int i = 1; i < n + 1; i++) {
                    //방문하지 않은 연결된 정점을 찾고 최소거리를 갱신
                    if (!visited[i] && maps[vertex.no][i] != 0 && distance[i] > distance[vertex.no] + maps[vertex.no][i]){
                        distance[i] = distance[vertex.no] + maps[vertex.no][i];
                        routes[i] = vertex.no;
                        //갱신된 정점을 우선순위 큐에 저장, 최소거리가 짧은 순서대로 poll됨
                        queue.offer(new Vertex(i, distance[i]));
                    }
                }
            }


            //번외 최단 거리별 최단 루트 출력하기
            System.out.println("Arrays.toString(routes) = " + Arrays.toString(routes));

            for (int i = 1; i < n+1; i++) {
                if (i == start)
                    continue;

                int route = i;
                StringBuilder builder = new StringBuilder(start);
                do {
                    route = routes[route];
                    builder.insert(0,route + " ");
                } while (route != start);
                System.out.println(i+" = " + builder);
            }

            return distance;
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

}
