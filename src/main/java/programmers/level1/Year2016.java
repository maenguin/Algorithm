package programmers.level1;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Year2016 {

    public String solution(int a, int b) {

        //이렇게 구하면 무슨 의미가 있을까 다시 풀자
        //LocalDate target = LocalDate.of(2016,a,b);
        //DayOfWeek dayOfWeek = target.getDayOfWeek();
        //return dayOfWeek.toString().substring(0,3);

        String answer = "";
        String[] dayofWeek = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int[] daysOfMonth = {31,29,31,30,31,30,31,31,30,31,30,31};
        int sumOfDays = 0;

        for (int i = 0; i < a -1; i++) {
            sumOfDays += daysOfMonth[i];
        }
        sumOfDays += b;

        answer = dayofWeek[sumOfDays%7];
        return answer;
    }

}
