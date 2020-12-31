package programmers.level2;

public class 삼각달팽이 {

    public int[] solution(int n) {

        int sum = n * (n + 1) / 2;
        int[] answer = new int[sum];


        int num = 1;
        int i = 0;
        int j;
        int floor = 1;

        answer[0] = num++;
        while (true){

            j = floor;
            while (i + j < sum && answer[i + j] == 0){
                i += j++;
                answer[i] = num++;
                floor++;
            }

            if (num > sum) break;

            while (i + 1 < sum && answer[i + 1] == 0){
                answer[++i] = num++;
            }

            if (num > sum) break;

            j = floor;
            while (i - j > 0 && answer[i - j] == 0) {
                i -= j--;
                answer[i] = num++;
                floor--;
            }

            if (num > sum) break;

        }

        return answer;
    }

}
