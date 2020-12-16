package programmers.level1;

public class 짝수와홀수 {

    public String solution(int num) {
        String[] numType = {"Even","Odd"};
        return numType[Math.abs(num%2)];
    }

}
