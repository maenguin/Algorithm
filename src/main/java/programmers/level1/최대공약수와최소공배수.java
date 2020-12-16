package programmers.level1;

public class 최대공약수와최소공배수 {

    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gcdU(n, m);
        //answer[1] = lcm(Math.min(n,m), Math.max(n,m));
        answer[1] = n*m/answer[0]; //이런 공식이 있다는걸 까먹고 있었다..
        return answer;
    }


    private int gcdU(int n, int m) {

        int temp = 0;
        while (n % m != 0) {
            temp = n % m;
            n = m;
            m = temp;
        }
        return m;
    }

//    private int gcd(int min, int max) {
//
//        int gcd = 0;
//        for (int i = 1; i <= min; i++) {
//            gcd = min % i == 0 && max % i == 0 ? i : gcd;
//        }
//        return gcd;
//    }



//    private int lcm(int min, int max) {
//
//        int mul = min*max;
//
//        int mini = 1;
//        int maxi = 1;
//        int newMin = min;
//        int newMax = max;
//        while (newMin < mul) {
//
//            while (newMin < newMax) {
//                newMin = min * mini++;
//            }
//
//            if (newMin == newMax) {
//                break;
//            }
//            newMax = max * maxi++;
//        }
//
//        return newMin;
//    }

}
