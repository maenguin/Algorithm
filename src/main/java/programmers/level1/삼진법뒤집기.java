package programmers.level1;

import java.util.ArrayList;

public class 삼진법뒤집기 {

    public int solution(int n) {
        int answer = 0;
        int divide = n;
        ArrayList<Integer> list = new ArrayList<>();

        while (divide >= 3){
            list.add(divide%3);
            divide = divide/3;
        }
        list.add(divide);

        for (int i = list.size() -1; i >= 0 ; i--) {
            answer += list.get(i) * Math.pow(3,list.size() - i -1);
        }

        return answer;
    }

}
