package programmers.level1;

public class 두정수사이의합 {

    public long solution(int a, int b) {
        long answer = 0;

        if (a == b) return a;

        int max = Math.max(a,b);
        int min = Math.min(a,b);

        long maxSum = sum(max);
        long minSum = sum(min);

        if (maxSum > 0){

            if (minSum > 0)
                answer = maxSum - minSum + min;
            else
                answer = maxSum + minSum;
        }
        else {
            answer = minSum - maxSum + max;
        }

        return answer;
    }

    private long sum(long n){
        return n >= 0 ?  n*(n+1)/2 : -n*(n-1)/2;
    }

    //이렇게도 할 수 있더라.. b>a
    private long sumAtoB(long a, long b) {
        return (b - a + 1) * (a + b) / 2;
    }
}
