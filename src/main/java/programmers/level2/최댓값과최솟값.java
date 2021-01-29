package programmers.level2;

public class 최댓값과최솟값 {

    public String solution(String s) {
        String[] split = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (String s1 : split) {
            min = Math.min(min, Integer.parseInt(s1));
            max = Math.max(max, Integer.parseInt(s1));
        }

        return min + " " + max;
    }

}
