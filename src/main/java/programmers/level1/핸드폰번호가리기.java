package programmers.level1;

public class 핸드폰번호가리기 {


    public String solution(String phone_number) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < phone_number.length(); i++) {
            char c = phone_number.length() - i <= 4 ? phone_number.charAt(i) : '*';
            builder.appendCodePoint(c);
        }
        return builder.toString();
    }

    public String solution2(String phone_number) {
        //전방탐색 뒤 4자리 남기고 * 치환
        return phone_number.replaceAll(".(?=.{4})","*");

        //번외 후방탐색 앞 4자리 남기고 * 치환
        //return phone_number.replaceAll("(?<=.{4}).","*");

        //번외 가운데 번호 * 치환
        //return phone_number.replaceAll("(?<=.2|.{3}).(?=.{4})","*");
    }
}
