package baekJoon;

import java.util.*;

//https://www.acmicpc.net/problem/13549
public class P13549_숨바꼭질3 {

    /*
    [문제설명]
    수빈이는 동생과 숨바꼭질을 하고 있다.
    수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
    수빈이는 걷거나 순간이동을 할 수 있다.
    만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
    순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.

    수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

    [시간제한]
    2 초

    [입력]
    첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

    [출력]
    수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
     */

    //숨바꼭질1에서와는 다르게 2*X로 이동하면 0초가 걸린다.
    //즉 간선의 가중치가 0 또는 1이다.
    //가중치가 전부 동일하지 않기 때문에 BFS 최단거리 알고리즘을 적용할 수 없을것 같지만
    //가중치가 2개 뿐이기 때문에 큐를 2개 두거나 덱을 사용해서 문제를 해결할 수 있다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        solution2(n,k);

    }

    //큐 두개 이용
    //가중치가 0일때는 curQ에, 가중치가 1일때는 nextQ에 넣고
    //curQ가 비어있을떄는 curQ와 nextQ를 swap했다.
    private static void solution1(int n, int k){
        int MAX = 200000;
        int[] dist = new int[MAX];
        Arrays.fill(dist, -1);
        Queue<Integer> curQ = new LinkedList<>();
        Queue<Integer> nextQ = new LinkedList<>();

        curQ.offer(n);
        dist[n] = 0;

        while (!curQ.isEmpty()) {
            int x = curQ.poll();

            if (x == k) {
                break;
            }


            if (x * 2 < MAX && dist[x*2] == -1) {
                curQ.offer(x*2);
                dist[x*2] = dist[x];
            }
            if (x - 1 >= 0 && dist[x-1] == -1) {
                nextQ.offer(x - 1);
                dist[x-1] = dist[x] + 1;
            }
            if (x + 1 < MAX && dist[x + 1] == -1) {
                nextQ.offer(x + 1);
                dist[x + 1] = dist[x] + 1;
            }

            if (curQ.isEmpty()) {
                Queue<Integer> temp = curQ;
                curQ = nextQ;
                nextQ = temp;
            }
        }


        System.out.println(dist[k]);
    }

    //덱이용
    //가중치가 0 일떄는 앞에, 1일때는 뒤에 넣었다
    private static void solution2(int n, int k) {

        int MAX = 200000;
        int[] dist = new int[MAX];
        Arrays.fill(dist, -1);
        LinkedList<Integer> deque = new LinkedList<>();
        deque.offer(n);
        dist[n] = 0;

        while (!deque.isEmpty()) {
            int x = deque.pollFirst();

            if (x == k) {
                break;
            }


            if (x * 2 < MAX && dist[x*2] == -1) {
                deque.addFirst(x*2);
                dist[x*2] = dist[x];
            }
            if (x - 1 >= 0 && dist[x-1] == -1) {
                deque.addLast(x - 1);
                dist[x-1] = dist[x] + 1;
            }
            if (x + 1 < MAX && dist[x + 1] == -1) {
                deque.addLast(x + 1);
                dist[x + 1] = dist[x] + 1;
            }
        }

        System.out.println(dist[k]);
    }

}