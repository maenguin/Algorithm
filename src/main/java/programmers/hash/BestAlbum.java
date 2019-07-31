package programmers.hash;

import java.util.*;


//베스트앨범
//        문제 설명
//        스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
//
//        속한 노래가 많이 재생된 장르를 먼저 수록합니다.
//        장르 내에서 많이 재생된 노래를 먼저 수록합니다.
//        장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
//        노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
//
//        제한사항
//        genres[i]는 고유번호가 i인 노래의 장르입니다.
//        plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
//        genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
//        장르 종류는 100개 미만입니다.
//        장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
//        모든 장르는 재생된 횟수가 다릅니다.






public class BestAlbum {

    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        HashMap<String,Integer> hash = new LinkedHashMap<>();
        Map<String, Map<Integer,Integer>> playHash = new LinkedHashMap<>();
        for (int i = 0; i < genres.length; i++) {
            hash.put(genres[i], hash.getOrDefault(genres[i],0) + plays[i]);
            playHash.put(genres[i], playHash.getOrDefault(genres[i], new LinkedHashMap<>()));
            playHash.get(genres[i]).put(i,plays[i]);
        }

        List<String> SortedGenreList = getStringKeyListSortedByValue(hash);
        for (String genre: SortedGenreList) {
            List<Integer> integerKeyListSortedByValue = getIntegerKeyListSortedByValue(playHash.get(genre));
            for (int i = 0; i < integerKeyListSortedByValue.size(); i++) {
                if (i > 1) break;
                answer.add(integerKeyListSortedByValue.get(i));
            }

        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }


    public List<String> getStringKeyListSortedByValue(Map map) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());

        Collections.sort(list, (o1, o2) -> {
            int comparision = (o1.getValue() - o2.getValue()) * -1;
            return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
        });

        // 순서유지를 위해 LinkedHashMap을 사용
        List<String> keyList = new ArrayList<>();
        for(Iterator<Map.Entry<String, Integer>> iter = list.iterator(); iter.hasNext();){
            Map.Entry<String, Integer> entry = iter.next();
            keyList.add(entry.getKey());
        }
        return keyList;
    }

    public List<Integer> getIntegerKeyListSortedByValue(Map map) {
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());

        Collections.sort(list, (o1, o2) -> {
            int comparision = (o1.getValue() - o2.getValue()) * -1;
            return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
        });

        // 순서유지를 위해 LinkedHashMap을 사용
        List<Integer> keyList = new ArrayList<>();
        for(Iterator<Map.Entry<Integer, Integer>> iter = list.iterator(); iter.hasNext();){
            Map.Entry<Integer, Integer> entry = iter.next();
            keyList.add(entry.getKey());
        }
        return keyList;
    }
}
