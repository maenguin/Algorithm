package programmers.level2;


import java.util.Arrays;

public class 최솟값만들기 {

    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            int b = B[A.length -1 -i];
            answer += a*b;
        }

        return answer;
    }


}
