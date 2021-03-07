package kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//2018 KAKAO BLIND RECRUITMENT
public class 파일명정렬 {

    public String[] solution(String[] files) {
        String[] answer = {};

        List<File> fileList = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            Matcher m = Pattern.compile("(^[A-Za-z]\\D*)(\\d*)(.*)?").matcher(files[i]);
            while (m.find()) {
                fileList.add(new File(m.group(1), m.group(2), m.group(3),i,files[i]));
            }
        }
        Collections.sort(fileList);
        answer = fileList.stream().map(f -> f.fullName).toArray(String[]::new);
        return answer;
    }

    static class File implements Comparable<File> {
        private String head;
        private String number;
        private String tail;
        private int inputOrder;
        private String fullName;

        public File(String head, String number, String tail, int inputOrder, String fullName) {
            this.head = head;
            this.number = number;
            this.tail = tail;
            this.inputOrder = inputOrder;
            this.fullName = fullName;
        }



        @Override
        public int compareTo(File o) {
            int headCompare = this.head.compareToIgnoreCase(o.head);
            if (headCompare != 0) {
                return headCompare;
            }
            int numberCompare = Integer.compare(Integer.parseInt(this.number), Integer.parseInt(o.number));
            if (numberCompare != 0) {
                return numberCompare;
            }
            return Integer.compare(this.inputOrder, o.inputOrder);
        }
    }

}
