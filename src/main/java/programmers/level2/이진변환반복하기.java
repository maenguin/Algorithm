package programmers.level2;

public class 이진변환반복하기 {

    public int[] solution(String s) {
        int[] answer = new int[2];

        int numOfZero = 0;
        int numOfConvs = 0;
        int preLength = s.length();

        while (!s.equals("1")) {
            s = s.replaceAll("0", "");
            numOfZero += preLength - s.length();
            s = Integer.toString(s.length(), 2);
            preLength = s.length();
            numOfConvs++;
        }


        answer[0] = numOfConvs;
        answer[1] = numOfZero;
        return answer;
    }

}
