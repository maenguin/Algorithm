package kakao;

import java.util.*;
//2020 카카오 인턴십
//https://programmers.co.kr/learn/courses/30/lessons/67258
public class 보석쇼핑 {

    int gemSetSize;
    int start = 1;
    int end = 100000;
    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        Set<String> gemSet = new HashSet<>();
        for (String gem : gems) {
            gemSet.add(gem);
        }
        gemSetSize = gemSet.size();

        for (int i = 0; i < gems.length; i++) {
            int start = i + 1;
            gemSet.clear();
            for (int j = i; j < gems.length && j < i + this.end - this.start ; j++) {
                gemSet.add(gems[j]);
                if (gemSet.size() == gemSetSize) {
                    int end = j + 1;
                    if (this.end - this.start > end - start) {
                        this.start = start;
                        this.end = end;
                    }
                    break;
                }
            }
        }
        answer[0] = start;
        answer[1] = end;
        return answer;
    }

    public int[] solution2(String[] gems) {
        int[] answer = new int[2];

        Set<String> gemSet = new HashSet<>();
        for (String gem : gems) {
            gemSet.add(gem);
        }
        twoPointer(gems,gemSet.size() );
        answer[0] = start + 1;
        answer[1] = end + 1;
        return answer;
    }

    public void twoPointer(String[] gems, int gemSetSize) {
        int start = 0;
        int end = 0;

        Map<String, Integer> gemMap = new HashMap<>();

        //if else의 조건 순서가 중요!
        int i = 0;
        while (true) {
            //보석을 전부 포함했으면 start 포인터를 움직여서 하나씩 줄여본다.
            //처음에 와야 줄이는것 까지 다 완료한채 종료 할 수 있다.
            if (gemMap.size() == gemSetSize) {
                Integer gemCnt = gemMap.get(gems[start]);
                if (gemCnt <= 1) {
                    gemMap.remove(gems[start]);
                } else {
                    gemMap.put(gems[start], gemCnt -1);
                }
                start++;
            }
            //end가 끝에 도달한 상태에서 start를 움직일 수 없으면 종료
            else if (end == gems.length){
                break;
            }
            //보석을 전부 포함할떄까지 end 포인터를 움직인다.
            else {
                gemMap.put(gems[end], gemMap.getOrDefault(gems[end], 0) + 1);
                end++;
            }


            if (gemMap.size() == gemSetSize) {
                if (this.end - this.start > end-1 - start) {
                    this.start = start;
                    this.end = end-1;
                }
            }
        }

    }

}
