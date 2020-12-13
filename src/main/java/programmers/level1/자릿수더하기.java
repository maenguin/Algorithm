package programmers.level1;

public class 자릿수더하기 {


    //수학적으로
    public int solution(int n) {
        int answer = 0;
        int lengthOfn = String.valueOf(n).length();

        for (int i = 0; i < lengthOfn; i++) {
            answer += ((n % Math.pow(10,i + 1)) - answer)/Math.pow(10,i);
        }

        return answer;
    }



    //이게 더빨라
    public int solution2(int n) {
        int answer = 0;
        String s = String.valueOf(n);

        for (char c : s.toCharArray()) {
            answer += c - '0';
        }

        return answer;
    }


    //수학적2 형변환 없는 버전 제일 빠르다
    public int solution3(int n) {

        int answer = 0;

        while (n > 0) {
            answer += n % 10;
            n /= 10;
        }

        return answer;
    }
}
