package ebay;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Q2_돌무더기게임 {

    private static List<String> resultCandidates = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        int[] stones = new int[n];
        int[] indexes = new int[12];
        for (int i = 0; i < n; i++) {
            stones[i] = scanner.nextInt();
        }
        doStones(stones, indexes, k, 0);
        if (resultCandidates.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(resultCandidates);
            System.out.println(resultCandidates.get(resultCandidates.size() - 1));
        }
    }

    private static void doStones(int[] stones, int[] indexes, int k, int depth) {
        if (depth > 0 && isGameClear(stones, k, indexes[depth - 1])) {
            resultCandidates.add(Arrays.stream(indexes).limit(depth).mapToObj(String::valueOf).collect(Collectors.joining()));
        }
        for (int i = 0; i < stones.length; i++) {
            if (canRemoveStone(stones, i)) {
                addAndRemoveStone(stones, i);
                indexes[depth] = i;
                doStones(stones, indexes, k, depth + 1);
                rollbackStone(stones, i);
            }
        }
    }

    private static boolean isGameClear(int[] stones, int k, int lastIndex) {
        for (int i = 0; i < stones.length; i++) {
            if (i == lastIndex) {
                if (stones[i] != k) return false;
            } else {
                if (stones[i] != 0) return false;
            }
        }
        return true;
    }

    private static boolean canRemoveStone(int[] stones, int targetStone) {
        for (int i = 0; i < stones.length; i++) {
            if (i != targetStone && stones[i] == 0) return false;
        }
        return true;
    }

    private static void addAndRemoveStone(int[] stones, int targetStone) {
        for (int i = 0; i < stones.length; i++) {
            if (i == targetStone) {
                stones[i]++;
            } else {
                stones[i]--;
            }
        }
    }

    private static void rollbackStone(int[] stones, int targetStone) {
        for (int i = 0; i < stones.length; i++) {
            if (i == targetStone) {
                stones[i]--;
            } else {
                stones[i]++;
            }
        }
    }
}
