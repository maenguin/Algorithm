package programmers.weeklychallenge;

//https://programmers.co.kr/learn/courses/30/lessons/82612
public class week1 {

    public long solution(int price, int money, int count) {

        long sum = (long)price * (count*(count+1)/2);
        long answer = sum - money > 0 ? sum - money : 0;

        return answer ;
    }
}
