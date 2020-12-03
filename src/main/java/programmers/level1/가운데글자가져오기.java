package programmers.level1;

public class 가운데글자가져오기 {
    public String solution(String s) {
        String answer = "";

        if (s.length() % 2 == 0){
            answer = s.substring(s.length()/2 - 1, (s.length()/2 - 1)+2);
        }
        else {
            answer = s.substring(s.length()/2, s.length()/2+1);
        }

        //다음과 같이 한줄로 풀 수 도 있다.. 대단하다
        //s.substring((s.length()-1) / 2, s.length()/2 + 1);

        return answer;
    }

}
