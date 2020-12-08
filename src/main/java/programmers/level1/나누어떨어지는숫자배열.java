package programmers.level1;

import java.util.*;
import java.util.stream.IntStream;

public class 나누어떨어지는숫자배열 {



    //0.3ms
    public int[] solution(int[] arr, int divisor) {


        ArrayList<Integer> list = new ArrayList<>();
        for (int a : arr){
            if (a % divisor == 0)
                list.add(a);
        }

        int[] answer = {-1};
        if (list.size() > 0){

            Collections.sort(list);
            answer = new int[list.size()];
            Iterator<Integer> iterator = list.iterator();
            int i = 0;
            while (iterator.hasNext()){
                answer[i++] = iterator.next();
            }
        }
        return answer;
    }

    //3~20ms
    public int[] solutionByStream(int[] arr, int divisor) {

        int[] answer = Arrays.stream(arr)
                .filter(a -> a % divisor == 0)
                .sorted()
                .toArray();


        return answer.length == 0 ? new int[]{-1} : answer;
    }

}
