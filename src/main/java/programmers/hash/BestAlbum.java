package programmers.hash;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


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




    ///다른분 풀이 분석 stream 이용

    //Music객체를 정렬하기 위해 Comparable 인터페이스를 상속받고 compareTo함수를 오버라이딩 했다.
    public class Music implements Comparable<Music>{

        private int played;
        private int id;
        private String genre;

        public Music(String genre, int played, int id) {
            this.genre = genre;
            this.played = played;
            this.id = id;
        }

        //플레이횟수를 내림차순으로 횟수가 같으면 id를 오름차순으로 정렬하도록 설정
        @Override
        public int compareTo(Music other) {
            if(this.played == other.played) return this.id - other.id;
            return other.played - this.played;
        }

        public String getGenre() {return genre;}
    }

    public int[] solution2(String[] genres, int[] plays) {



        return IntStream.range(0, genres.length)//genres수만큼 IntStream size설정해 생성 [0,1,2,3~~]
                .mapToObj(i -> new Music(genres[i], plays[i], i)) //IntStream값을 이용해 Music Stream생성
                .collect(Collectors.groupingBy(Music::getGenre)) //장르를 기준으로 그룹바이 Map<String, List<Music>>
                .entrySet().stream()//엔트리셋으로 변환후 스트림으로 Set<Map.Entry<String, List<Music>>>
                .sorted((a, b) -> sum(b.getValue()) - sum(a.getValue()))//장르 총플레이 횟수를 기준으로 오름차순으로 정렬
                .flatMap(x->x.getValue().stream().sorted().limit(2))//후 총 플레이 횟수 높은 장르의 음악들을 꺼내서 스트림생성, 오름차순 정렬후 그중에 최대 2개만 빼내서 플래팅
                .mapToInt(x->x.id).toArray(); //후 id만 추출 하고 arr로 변환
    }

    //뮤직 객체리스트에서 플레이횟수의 총합을 반환
    private int sum(List<Music> value) {
        int answer = 0;
        for (Music music : value) {
            answer+=music.played;
        }
        return answer;
    }



}
