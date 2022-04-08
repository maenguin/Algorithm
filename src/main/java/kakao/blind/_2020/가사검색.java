package kakao.blind._2020;

import java.util.HashMap;
import java.util.Map;

//문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/60060
//노션 링크 : https://delirious-sock-4dc.notion.site/2a6abf5ad7034066bd7ade8980fa307b
//문제 유형 : 세그먼트 트리
public class 가사검색 {

    private Node root;
    private Node reversedRoot;

    public int[] solution(String[] words, String[] queries) {
        root = createSegmentTree(words, false);
        reversedRoot = createSegmentTree(words, true);

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            boolean needReverse = query.charAt(0) == '?';
            answer[i] = getQueryResult(query, needReverse);
        }
        return answer;
    }

    public Node createSegmentTree(String[] words, boolean reverse) {
        Node root = new Node();
        for (String word : words) {
            Node curNode = root;
            curNode.addLengthCount(word.length());
            for (int i = 0; i < word.length(); i++) {
                char c = reverse ? word.charAt(word.length() - 1 - i) : word.charAt(i);
                curNode = curNode.addChild(c);
                curNode.addLengthCount(word.length());
            }
        }
        return root;
    }

    private int getQueryResult(String query, boolean reverse) {
        Node curNode = reverse ? reversedRoot : root;
        int result = 0;
        for (int i = 0; i < query.length(); i++) {
            char c = reverse ? query.charAt(query.length() - 1 - i) : query.charAt(i);
            if (c == '?') {
                result = curNode.lengthAndCountPairs.getOrDefault(query.length(), 0);
                break;
            }
            if (!curNode.children.containsKey(c)) break;
            curNode = curNode.children.get(c);
        }
        return result;
    }

    static class Node {

        Map<Character, Node> children;
        Map<Integer, Integer> lengthAndCountPairs;

        public Node() {
            this.children = new HashMap<>();
            this.lengthAndCountPairs = new HashMap<>();
        }

        private Node addChild(char c) {
            return children.computeIfAbsent(c, character -> new Node());
        }

        private void addLengthCount(Integer leftLength) {
            lengthAndCountPairs.put(leftLength, lengthAndCountPairs.getOrDefault(leftLength, 0) + 1);
        }

    }

}
