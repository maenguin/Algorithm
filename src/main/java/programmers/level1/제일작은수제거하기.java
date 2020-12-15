package programmers.level1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 제일작은수제거하기 {

    public int[] solution(int[] arr) {

        if (arr.length == 1){
            return new int[]{-1};
        }

        int min = Arrays.stream(arr).min().getAsInt();
        int[] answer = Arrays.stream(arr).filter(a -> a != min).toArray();

        return answer;
    }


    //stream이랑 비교했을때 말도 안되게 빠르다
    public int[] solution2(int[] arr) {

        if (arr.length == 1) {
            return new int[]{-1};
        }

        int[] answer = new int[arr.length - 1];
        int minIndex = 0;
        int minValue = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (minValue > arr[i]) {
                minValue = arr[i];
                minIndex = i;
            }
        }

        System.arraycopy(arr, 0, answer, 0 ,minIndex);
        System.arraycopy(arr, minIndex + 1, answer, minIndex ,arr.length - minIndex -1);

        return answer;
    }
}
