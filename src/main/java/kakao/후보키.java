package kakao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;



//2019 KAKAO BLIND RECRUITMENT
//https://programmers.co.kr/learn/courses/30/lessons/42890
public class 후보키 {


    HashSet<HashSet<Integer>> candKeySet = new HashSet<>();

    public int solution(String[][] relation) {

        int columnSize = relation[0].length;

        int[] arr = IntStream.range(0,columnSize).toArray();
        boolean[] visited = new boolean[columnSize];
        for (int i = 0; i < columnSize; i++) {
            combination(arr,visited,0, arr.length,i+1, relation);
        }


        return candKeySet.size();
    }

    void combination(int[] arr, boolean[] visited, int start, int n, int r, String[][] relation) {
        if(r == 0) {
            checkCandidateKey(arr, visited, n,relation);
            return;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1,relation);
            visited[i] = false;
        }
    }



    void checkCandidateKey(int[] arr, boolean[] visited, int n, String[][] relation) {
        HashSet<Integer> key = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (visited[i] == true)
                key.add(arr[i]);
        }
        boolean isMinimal = checkMinimality(key);
        boolean isUnique = checkUniqueness(relation, key);
        if (isMinimal && isUnique) {
            candKeySet.add(key);
        }
    }


    boolean checkMinimality(Set<Integer> Key) {
        if (candKeySet.isEmpty()) {
            return true;
        }

        for (HashSet<Integer> candKey : candKeySet) {
            if (Key.containsAll(candKey)) {
                return false;
            }
        }
        return true;
    }

    boolean checkUniqueness(String[][] relation, Set<Integer> key) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < relation.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (Integer col : key) {
                builder.append(relation[i][col]);
            }
            if (set.contains(builder.toString())) {
                return false;
            }
            set.add(builder.toString());
        }
        return true;
    }

    //비트 연산을 이용해 부분집합을 구할 수도 있다.
    void bit(int[] arr, int n) {
        for(int i=0; i < 1<<n; i++) {
            for(int j=0; j<n; j++) {
                if((i & 1<<j) != 0)
                    System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }

    //다른분이 풀이에 사용하신 최소성을 구하는법, 비트 연산으로도 할 수 있다는걸 알았다
    private boolean possi(List<Integer> list, int now){
        for(int i = 0; i < list.size(); i++){
            if ( (list.get(i) & now) == list.get(i)) return false;
        }
        return true;
    }


}
