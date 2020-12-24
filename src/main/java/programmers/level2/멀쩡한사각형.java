package programmers.level2;

import java.math.BigInteger;

//Summer/Winter Coding(2019)
public class 멀쩡한사각형 {

    public long solution(int w, int h) {
        long answer = (long) w * h;
        int gcd = gcd(w,h);

        double slope = (double)h/w;
        double pos = 0;
        int numOfSelectedSquareInOneRect = 0;
        for (int i = 1; i <= w/gcd; i++) {
            int numOfSelectedSquareInOneLine = (int)Math.ceil(slope * i) - (int)Math.floor(pos);
            numOfSelectedSquareInOneRect += numOfSelectedSquareInOneLine;
            pos = slope * i;
        }

        return answer - (numOfSelectedSquareInOneRect * gcd);
    }

    private int gcd(int n, int m) {

        int temp = 0;
        while (n % m != 0) {
            temp = n % m;
            n = m;
            m = temp;
        }
        return m;
    }

    public long solution2(int w, int h) {

        long answer = (long)w * h;

        //long gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();
        int gcd = gcd(w,h);
        return answer - ( w + h - gcd);

    }


}
