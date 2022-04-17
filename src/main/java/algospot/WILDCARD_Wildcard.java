package algospot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//문제 출처 : https://algospot.com/judge/problem/read/WILDCARD
//노션 링크 : https://delirious-sock-4dc.notion.site/50a667e0e23c401db4382e282a45f4b3
//알고 리즘 : DP
public class WILDCARD_Wildcard {

    private static StringBuilder answer = new StringBuilder();
    private static String word;
    private static String file;
    private static int[][] cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        while (c-- > 0) {
            word = sc.next();
            int n = sc.nextInt();
            String[] files = new String[n];
            for (int i = 0; i < n; i++) {
                files[i] = sc.next();
            }
            solution(files);
        }
        System.out.println(answer);
    }

    private static void solution(String[] files) {
        List<String> candidates = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            file = files[i];
            cache = new int[word.length()][file.length()];
            if (dfs(0, 0)) {
                candidates.add(file);
            }
        }
        Collections.sort(candidates);
        for (String candidate : candidates) {
            answer.append(candidate).append('\n');
        }
    }

    private static boolean dfs(int w, int f) {
        if (w == word.length() && f == file.length()) return true;
        if (w == word.length() - 1 && word.charAt(w) == '*') return true;
        if (w >= word.length() || f >= file.length()) return false;
        if (cache[w][f] != 0) return cache[w][f] == 1;
        char c = word.charAt(w);
        boolean result = false;
        if (c == '*') {
//            for (int k = 0; f + k < file.length(); k++) {
//                result |= dfs(w + 1, f + k);
//            }
            result = dfs(w + 1, f) || dfs(w, f + 1);
        } else if (c == '?' || c == file.charAt(f)) {
            result = dfs(w + 1, f + 1);
        }
        cache[w][f] = result ? 1 : -1;
        return result;
    }

    //////////////////////////////////////////////////////////////////////////////////

    private static boolean jongman(int w, int f) {
        if (cache[w][f] != 0) return cache[w][f] == 1;
        while (w < word.length() && f < file.length() && (word.charAt(w) == '?' || word.charAt(w) == file.charAt(f))) {
            w++;
            f++;
        }
        if (w == word.length()) return f == file.length();
        if (word.charAt(w) == '*') {
            if (jongman(w + 1, f) || (f < file.length() && jongman(w, f + 1))) {
                cache[w][f] = 1;
                return true;
            }
        }
        cache[w][f] = -1;
        return false;
    }

}
