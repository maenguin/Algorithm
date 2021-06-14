package kakao.blind2021;

import java.util.Locale;

//https://programmers.co.kr/learn/courses/30/lessons/72410
public class 신규아이디추천 {


    public static void main(String[] args) {
        System.out.println("solution = " + solution("z-+.^."));
    }
    
    public static String solution(String new_id) {
        String answer = new_id;

        //phase1
        answer = answer.toLowerCase(Locale.ENGLISH);
        System.out.println("answer1 = " + answer);
        //phase2
        StringBuilder sb = new StringBuilder();
        for (char c : answer.toCharArray()) {
            if (Character.isAlphabetic(c) || Character.isDigit(c) || c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }
        answer = sb.toString();
        System.out.println("answer2 = " + answer);
        //phase3
        answer = answer.replaceAll("\\.*",".");
        System.out.println("answer3 = " + answer);
        //phase4
        answer = phase4(answer);
        System.out.println("answer4 = " + answer);
        //phase5
        if (answer.isEmpty()) {
            answer = "a";
        }
        System.out.println("answer5 = " + answer);
        //phase6
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer = phase4(answer);
        }
        System.out.println("answer6 = " + answer);
        //phase7
        if (answer.length() <= 2) {
            StringBuilder sb2 = new StringBuilder(answer);
            char c = answer.charAt(answer.length() - 1);
            while (sb2.length() < 3) {
                sb2.append(c);
            }
            answer = sb2.toString();
        }

        System.out.println("answer7 = " + answer);
        return answer;
    }

    private static String phase4(String id){
        if (id.startsWith(".") && id.length() >= 2) {
            id = id.substring(1);
        }
        if (id.endsWith(".") && id.length() >= 2){
            id = id.substring(0,id.length()-1);
        }
        if (id.equals(".")) {
            id = "";
        }
        return id;
    }
}
