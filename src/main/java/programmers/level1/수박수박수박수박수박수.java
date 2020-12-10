package programmers.level1;

public class 수박수박수박수박수박수 {

    public String solution(int n) {

        String[] subak = new String[]{"수","박"};
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            answer.append(subak[i%2]);
        }

        return answer.toString();
    }


}
