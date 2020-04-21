package programmers.sort;

//
//가장 큰 수
//        문제 설명
//        0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
//
//        예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
//
//        0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
//
//        제한 사항
//        numbers의 길이는 1 이상 100,000 이하입니다.
//        numbers의 원소는 0 이상 1,000 이하입니다.
//        정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class TheBiggestNumber  {

    public String solution(int[] numbers) {

        String answer = Arrays.stream(numbers)
                .mapToObj(Integer::toString)
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {

                        return myCompare(o1,o2,0);
                    }
                })
                .peek(System.out::println)
                .collect(Collectors.joining());


        return answer;
    }

    private int myCompare(String s1, String s2, int i) {

        if (s1.equals(s2)) {return -1;}
        else if (s2.startsWith(s1)){
            String s = s2.substring(s1.length());
            return myCompare(s1,s,0);
        }
        else if (s1.startsWith(s2)) {
            String s = s1.substring(s2.length());
            return myCompare(s,s2,0);
        }
        else {
            char c1 = s1.length() > i ? s1.charAt(i) : s1.charAt(0);
            char c2 = s2.length() > i ? s2.charAt(i) : s2.charAt(0);

            return c1 == c2 && i < s1.length() && i < s2.length() ? myCompare(s1,s2,i+1) : c2 - c1 ;
        }

        //i번째 char요소가 있으면 가져오고 없으면 마지막 요소를 반환

    }

}
