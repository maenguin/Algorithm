package programmers.level1;

import java.util.ArrayList;

public class 자연수뒤집어배열로만들기 {

    public int[] solution(long n) {
        int[] answer = new int[String.valueOf(n).length()];

        int index = 0;
        while (n > 0) {
            answer[index++] = (int)(n%10);
            n /= 10;
        }
        return answer;
    }

}
