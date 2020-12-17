package programmers.level1;

public class 콜라츠추측 {

    public int solution(int num) {
        int answer = 0;
        long numl = num;
        while (numl != 1 && answer < 500) {
            numl = numl % 2 == 0 ? numl/2 : numl*3 + 1;
            answer++;
        }
        return numl == 1 ? answer : -1;
    }

}
