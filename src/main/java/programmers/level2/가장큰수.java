package programmers.level2;

import java.util.*;
import java.util.stream.Collectors;

public class 가장큰수 {

    public String solution(int[] numbers) {
        String answer = "";

        List<String> list = Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.toList());
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                if (o1.length() != o2.length()) {
                    int min = Math.min(o1.length(), o2.length());
                    if (o1.substring(0, min).equals(o2.substring(0, min))) {
                        return (o2 + o1).compareTo(o1 + o2);
                    }
                }
                return o2.compareTo(o1);
                //return o1.compareTo(o2); 도 가능
            }
        });

        StringBuilder builder = new StringBuilder();
        for (String s : list) {
            builder.append(s);
        }
        return builder.toString().replaceAll("^0*$","0");
    }



}
