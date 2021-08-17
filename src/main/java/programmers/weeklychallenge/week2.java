package programmers.weeklychallenge;

//https://programmers.co.kr/learn/courses/30/lessons/83201
public class week2 {
    public String solution(int[][] scores) {

        String answer = "";

        for (int j = 0; j < scores.length; j++) {
            int myScore = scores[j][j];
            int max = -1;
            int min = Integer.MAX_VALUE;
            int sum = 0;
            int scoreCnt = scores[j].length;

            for (int i = 0; i < scoreCnt; i++) {
                int score = scores[i][j];
                sum += score;

                if (i == j) continue;

                if (score > max) {
                    max = score;
                }
                if (score < min) {
                    min = score;
                }
            }

            if (myScore > max) {
                sum -= myScore;
                scoreCnt--;
            }
            if (myScore < min) {
                sum -= myScore;
                scoreCnt--;
            }

            answer += scoreToAlphabet(sum / scoreCnt);
        }


        return answer;
    }

    private String scoreToAlphabet(int score) {

        String result;
        switch (score/10){
            case 10 :
            case 9 : result = "A";
                break;
            case 8 : result = "B";
                break;
            case 7 : result = "C";
                break;
            case 6 :
            case 5 : result = "D";
                break;
            default:  result = "F";
                break;
        }
        return result;
    }
}
