package ebay;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q3_빨강파랑격자 {

    private static String[] grid;
    private static ArrayList<Edge>[] adjList;
    private static List<Integer> outerVertex;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        grid = new String[n];
        for (int i = 0; i < n; i++) {
            grid[i] = scanner.next();
        }
        int totalVertex = 3;
        for (int i = 2; i <= n; i++) {
            totalVertex += i * 3;
        }
        adjList = new ArrayList[totalVertex];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        outerVertex = initializeEdge();
        int answer = 0;
        for (Integer vertex : outerVertex) {
            count = 0;
            dfs(vertex, 0);
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }

    private static List<Integer> initializeEdge() {
        List<Integer> outerVertex = new ArrayList<>();
        int lineFirstVertex = 0;
        int triNo = 0;
        for (int i = 0; i < grid.length; i++) {
            String s = grid[i];
            int weight = i * 3;
            lineFirstVertex += weight;
            int v1 = lineFirstVertex;
            outerVertex.add(v1);
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (j % 2 == 0) {
                    v1 += j > 0 ? 3 : 0;
                    if (j == s.length() - 1) {
                        outerVertex.add(v1 + 1);
                    }
                    if (i == grid.length - 1) {
                        outerVertex.add(v1 + 2);
                    }
                    connectEdge(v1, v1 + 1, v1 + 2, c == 'R', true, triNo);
                } else {
                    connectEdge(v1 + 2 - weight, v1 + 1, v1 + 3, c == 'R', false, triNo);
                }
                triNo++;
            }
        }
        return outerVertex;
    }

    private static void connectEdge(int v1, int v2, int v3, boolean isRed, boolean isForward, int triNo) {
        if ((isForward && isRed) || (!isForward && !isRed)) {
            adjList[v1].add(new Edge(v3, triNo));
            adjList[v2].add(new Edge(v1, triNo));
            adjList[v3].add(new Edge(v2, triNo));
        } else {
            adjList[v1].add(new Edge(v2, triNo));
            adjList[v2].add(new Edge(v3, triNo));
            adjList[v3].add(new Edge(v1, triNo));
        }
    }

    private static void dfs(int x, int beforeTriNo) {
        if (count > 0 && outerVertex.contains(x)) {
            return;
        }
        count++;
        for (Edge edge : adjList[x]) {
            if (edge.triNo == beforeTriNo) continue;
            dfs(edge.v, edge.triNo);
        }
    }

    static class Edge {
        int v;
        int triNo;

        public Edge(int v, int triNo) {
            this.v = v;
            this.triNo = triNo;
        }
    }
}
