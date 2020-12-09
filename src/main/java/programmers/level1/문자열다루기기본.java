package programmers.level1;

public class 문자열다루기기본 {

    public boolean solution(String s) {
        boolean answer = false;

        boolean isValidateLength = s.length() == 4 || s.length() == 6;
        if (isValidateLength){
            boolean hasNotDigit = s.chars().filter( i -> !Character.isDigit(i)).findAny().isPresent();
            answer = !hasNotDigit;
        }

        return answer;

        //빠르다 정규표현식!
        //return s.matches("^[0-9]{4}|{6}$");
    }

}
