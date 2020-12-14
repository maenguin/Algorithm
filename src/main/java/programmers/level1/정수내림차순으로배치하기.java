package programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

public class 정수내림차순으로배치하기 {

    public long solution(long n) {
        long answer = 0;

        int[] arr = new int[String.valueOf(n).length()];
        int index = 0;
        while (n > 0) {
            arr[index++] = (int) (n % 10);
            n /= 10;
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            answer += arr[i] * Math.pow(10,i);
        }

        return answer;
    }

    public long solution2(long n) {
        long answer = 0;

        char[] chars = String.valueOf(n).toCharArray();
        Arrays.sort(chars);

        return Long.parseLong(new StringBuilder(String.valueOf(chars)).reverse().toString()) ;
    }

}
