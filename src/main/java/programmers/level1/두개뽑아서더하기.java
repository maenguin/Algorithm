package programmers.level1;

import java.util.*;

public class 두개뽑아서더하기 {

    public int[] solution(int[] numbers) {


        Set<Integer> set = new TreeSet();

        for (int i = 0; i < numbers.length -1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        //3ms대로 느린편
        //return set.stream().mapToInt(Integer::intValue).toArray();


        //0.7ms대
        int[] answer = new int[set.size()];
        int index = 0;
        Iterator itor = set.iterator();
        while(itor.hasNext()){
            answer[index] = (int)itor.next();
            index++;
        }

        return answer;
    }

}

