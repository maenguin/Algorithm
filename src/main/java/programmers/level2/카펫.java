package programmers.level2;

public class 카펫 {

    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        int width = brown/2 -1;
        int height = 3;

        while (width * height != sum) {
            width--;
            height++;
        }

        int[] answer = {width, height};
        return answer;
    }

}
