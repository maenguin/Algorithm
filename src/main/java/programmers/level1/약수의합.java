package programmers.level1;

public class 약수의합 {

    public int solution(int n) {
        int answer = n;

        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }

        return answer;
    }

}
