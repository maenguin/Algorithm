package ebay;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q4_RGB전구 {

    private static Map<String, String> bulbMap = new HashMap<>();
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String bulbs = scanner.next();
        boolean existsAnswer = false;
        Queue<String> queue = new LinkedList<>();
        bulbMap.put(bulbs, "");
        queue.offer(bulbs);
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            if (isAllRed(poll)) {
                existsAnswer = true;
                break;
            }
            char[] chars = poll.toCharArray();
            for (int i = 0; i < n - k + 1; i++) {
                for (int j = 0; j < k; j++) {
                    chars[i + j] = changeColor(chars[i + j]);
                }
                String o = String.valueOf(chars);
                if (!bulbMap.containsKey(o)) {
                    queue.offer(o);
                    bulbMap.put(o, poll);
                }
                for (int j = 0; j < k; j++) {
                    chars[i + j] = rollBackColor(chars[i + j]);
                }
            }

        }
        if (existsAnswer) {
            String collect = IntStream.range(0, n).mapToObj(value -> "R").collect(Collectors.joining());
            tracePath(bulbs, collect);
            System.out.println(count - 1);
        } else {
            System.out.println(-1);
        }
    }

    private static void tracePath(String start, String end) {
        if (!start.equals(end) && !end.isEmpty()) {
            tracePath(start, bulbMap.get(end));
        }
        count++;
    }

    private static boolean isAllRed(String bulbs) {
        for (char c : bulbs.toCharArray()) {
            if (c != 'R') {
                return false;
            }
        }
        return true;
    }

    private static char changeColor(char color) {
        switch (color) {
            case 'R':
                return 'G';
            case 'G':
                return 'B';
            case 'B':
                return 'R';
            default:
                return 'X';
        }
    }

    private static char rollBackColor(char color) {
        switch (color) {
            case 'R':
                return 'B';
            case 'G':
                return 'R';
            case 'B':
                return 'G';
            default:
                return 'X';
        }
    }

}
