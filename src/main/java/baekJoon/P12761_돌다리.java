
package baekJoon;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/12761
//노션 링크 :
//알고 리즘 : 최단 거리
public class P12761_돌다리 {

    private static int a;
    private static int b;
    private static int n;
    private static int m;
    private static final int MAX = 100_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        n = sc.nextInt();
        m = sc.nextInt();
        System.out.println(jump());
    }

    private static int jump() {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[MAX + 1];
        int[] distance = new int[MAX + 1];
        int[] normalJumps = new int[] {1, -1, a, -a, b, -b};
        int[] powerJumps = new int[] {a, b};

        visited[n] = true;
        queue.offer(n);
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            if (cur == m) return distance[m];
            for (int normalJump : normalJumps) {
                int next = cur + normalJump;
                offerIfOk(queue, visited, distance, cur, next);
            }
            for (int powerJump : powerJumps) {
                int next = cur * powerJump;
                offerIfOk(queue, visited, distance, cur, next);
            }
        }
        return 0;
    }

    private static void offerIfOk(Queue<Integer> queue, boolean[] visited, int[] distance, Integer cur, int next) {
        if (0 <= next && next <= MAX && !visited[next]) {
            queue.offer(next);
            visited[next] = true;
            distance[next] = distance[cur] + 1;
        }
    }


}
