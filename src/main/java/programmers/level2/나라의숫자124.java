package programmers.level2;

public class 나라의숫자124 {

    public String solution(int n) {
        String[] arr = {"1","2","4"};
        StringBuilder builder = new StringBuilder();

        while (n > 0){
            builder.insert(0,arr[(n -1 )%3]);
            n = (int)Math.ceil((double)n/3) - 1;
        }

        return builder.toString();
    }

    //더깔끔한 다른분의 솔루션
    public String solution2(int n) {
        String[] arr = {"4","1","2"};
        StringBuilder builder = new StringBuilder();

        while (n > 0){
            builder.insert(0,arr[(n)%3]);
            n = (n - 1)/3;
        }

        return builder.toString();
    }

}
