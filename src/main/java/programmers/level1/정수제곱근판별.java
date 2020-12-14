package programmers.level1;

public class 정수제곱근판별 {

    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        return sqrt % 1 == 0 ? (long)Math.pow(sqrt+1,2)  : -1;
    }

}
