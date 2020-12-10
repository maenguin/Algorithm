package programmers.level1;

import java.util.ArrayList;

public class 소수찾기 {

    public int solution(int n) {
        int answer = 0;

        ArrayList<Integer> eratos = new ArrayList<>(n+1);

        eratos.add(0,0);
        eratos.add(1,0);
        for (int i = 2; i <= n; i++) {
            eratos.add(i,1);
        }

        for (int i = 2; i*i <= n; i++) {

            if (eratos.get(i) == 1){
                for (int j = i*i; j <= n; j += i) {
                    eratos.set(j,0);
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (eratos.get(i) == 1){
                answer += 1;
                System.out.println(i);
            }
        }

        return answer;
    }

    private boolean isPrime(int n) {
        for (int i = 3; i < n/2; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
