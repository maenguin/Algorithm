package programmers.hash;

//위장 문제

//문제 설명
//        스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
//
//        예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
//
//        종류	이름
//        얼굴	동그란 안경, 검정 선글라스
//        상의	파란색 티셔츠
//        하의	청바지
//        겉옷	긴 코트
//        스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
//
//        제한사항
//        clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
//        스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
//        같은 이름을 가진 의상은 존재하지 않습니다.
//        clothes의 모든 원소는 문자열로 이루어져 있습니다.
//        모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
//        스파이는 하루에 최소 한 개의 의상은 입습니다.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;




public class Camouflage {

//    private int factorial(int n) {
//        int result = 1;
//        for (int i = 2; i <= n; i++) {
//            result *= i;
//        }
//        return result;
//    }
//
//    private int combination(int n, int r) {
//        return factorial(n)/(factorial(r)*factorial(n-r));
//    }

    public int solution(String[][] clothes) {

//        int answer = 0;
//        HashMap<String, Integer> hash = new HashMap<>();
//
//        for (int i = 0; i < clothes.length; i++) {
//            hash.put(clothes[i][1], hash.getOrDefault(clothes[i][1],0) + 1);
//        }
//
//        answer = 1;
//        for (String key: hash.keySet()) {
//            answer *= hash.get(key);
//            System.out.println(hash.get(key));
//        }
//
//        for (int i = 1; i < hash.size() ; i++) {
//            int g = combination(hash.size()-1,i-1);
//            for (String key: hash.keySet()) {
//                answer += hash.get(key)*g;
//
//            }
//        }
//




        return 1;
    }


    //nCr은 n-1Cr + n-1Cr-1 인걸 이용했다.
    //예를 들어 0 1 2 4개중에 2개를 뽑는 경우의 수는
    //(0,x) 0을 뽑는걸 가정하고 나머지 3개중에 하나를 뽑는 경우와
    //(x,x) 0을 제외한 나머지 3개중에 두개를 뽑는 경우의 합이라고 할 수 있다.

    public static void combination(int n, int r, int index, ArrayList<Integer> arr, boolean flag) {

        ArrayList<Integer> arr2 = new ArrayList<>(arr);
        if (flag) {
            arr2.remove(index);
        }

        if (n == r || r==0) {
            System.out.print("[");
            for (int i = 0; i < arr2.size(); i++) {
                System.out.print(arr2.get(i));
            }
            System.out.println("]" + n + " " + r);

            return ;
        }
        combination(n-1,r-1,index +1, arr2 , false);
        combination(n-1,r,index, arr2, true);
    }

    public void solution2(int n) {

        for (int i = 0; i < n; i++) {
            System.out.println("[");
            System.out.println(i);
            System.out.println("]");
        }

        for (int i = 0; i < n; i++) {
            System.out.println("[");
            for (int j = i+1; j < n ; j++) {
                System.out.println(i);
                System.out.println(" ");
            }
            System.out.println("]");
        }

    }

}
