package programmers.level2;

//2017 팁스타운
//https://programmers.co.kr/learn/courses/30/lessons/12985
public class 예상대진표 {

    public int solution(int n, int a, int b)
    {
        int answer = 1;

        while (!meet(a,b)) {
            a = (a+1)/2;
            b = (b+1)/2;
            answer++;
        }
        return answer;
    }

    private boolean meet(int a, int b) {
        return (a%2 == 0 && a-1 == b) || (b%2 == 0 && b-1 == a);
    }

}
