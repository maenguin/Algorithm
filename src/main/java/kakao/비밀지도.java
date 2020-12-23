package kakao;

//2018 KAKAO BLIND
public class 비밀지도 {


    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = arr1[i] | arr2[i];
            String s = Integer.toString(arr1[i], 2);
            StringBuilder builder = new StringBuilder();

            for (int j = 0; j < n - s.length(); j++) {
                builder.appendCodePoint(' ');
            }
            for (char c : s.toCharArray()) {
                builder.appendCodePoint(c == '1' ? '#' : ' ');
            }
            answer[i] = builder.toString();
        }

        return answer;
    }

}
