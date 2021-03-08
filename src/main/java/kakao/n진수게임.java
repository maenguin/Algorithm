package kakao;


import java.util.ArrayList;

//2018 KAKAO BLIND RECRUITMENT
public class n진수게임 {

    public String solution(int n, int t, int m, int p) {
        String answer = "";

        int lastOrder = p + (t-1)*m;

        StringBuilder builder = new StringBuilder();
        int decimal = 0;
        while (builder.length() <= lastOrder) {
            builder.append(Integer.toString(decimal++, n).toUpperCase());
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int nextOrder = p + i*m -1;
            result.append(builder.charAt(nextOrder));
        }
        answer = result.toString();

        return answer;
    }

    //Integer.toString()을 쓰자
    public String decimalToRadix(int decimal, int radix) {
        StringBuilder builder = new StringBuilder();
        while (decimal >= radix) {
            int i = decimal % radix;
            builder.insert(0, radix > 10 ? Integer.toString(i,radix) : i);
            decimal /= radix;
        }
        builder.insert(0, decimal);
        return builder.toString();
    }

}
