package programmers.heap;


//문제 설명
//        매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다. 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
//
//        섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
//        Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
//        Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때, 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
//
//        제한 사항
//        scoville의 길이는 2 이상 1,000,000 이하입니다.
//        K는 0 이상 1,000,000,000 이하입니다.
//        scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
//        모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
//        입출력 예
//        scoville	K	return
//        [1, 2, 3, 9, 10, 12]	7	2
//        입출력 예 설명
//        스코빌 지수가 1인 음식과 2인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
//        새로운 음식의 스코빌 지수 = 1 + (2 * 2) = 5
//        가진 음식의 스코빌 지수 = [5, 3, 9, 10, 12]
//
//        스코빌 지수가 3인 음식과 5인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
//        새로운 음식의 스코빌 지수 = 3 + (5 * 2) = 13
//        가진 음식의 스코빌 지수 = [13, 9, 10, 12]
//
//        모든 음식의 스코빌 지수가 7 이상이 되었고 이때 섞은 횟수는 2회입니다.


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Spicier {


    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> scvQueue = new PriorityQueue();

        for (int scv : scoville)
            scvQueue.offer(scv);

        int min1 = 0;
        int min2 = 0;
        boolean success = false;
        //모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
        while ((scvQueue.peek() < K) && ( success = scvQueue.size() > 1) ){
            min1 = scvQueue.poll();
            min2 = scvQueue.poll();

            int mixResult = mix(min1,min2);
            scvQueue.offer(mixResult);
            answer++;

        }


        return success? answer : -1;
    }

    private int mix(int scovile1, int scovile2){
        return scovile1 >= scovile2 ? scovile2 + scovile1*2 : scovile1 + scovile2*2;
    }



    //후기
    //힙을 통해서 구현하니 쉽게 풀린것 같다






}
