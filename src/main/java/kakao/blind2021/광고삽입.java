package kakao.blind2021;

import java.util.ArrayList;
import java.util.List;

//https://programmers.co.kr/learn/courses/30/lessons/72414?language=java
public class 광고삽입 {

    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";

        int playTime = timeToSec(play_time);
        int advTime = timeToSec(adv_time);
        List<TimeLog> logList = new ArrayList<>();
        for (String log : logs) {
            String[] sp = log.split("-");
            logList.add(new TimeLog(timeToSec(sp[0]),timeToSec(sp[1])));
        }

        //a[i] : time i 일때 구간에 포함된 사용자 수
        int[] a = new int[playTime];
        for (TimeLog timeLog : logList) {
            for (int i = timeLog.start; i < timeLog.end; i++) {
                a[i]++;
            }
        }

        long windowSum = 0;
        long maxSum = 0;
        int windowStart = playTime - 1;
        int maxSumStart = 0;
        for (int windowEnd = playTime - 1; windowEnd >= 0; windowEnd--) {
            windowSum += a[windowEnd];
            if ((playTime - windowEnd) >= advTime) {
                if (maxSum <= windowSum){
                    maxSum = windowSum;
                    maxSumStart = windowEnd;
                }
                windowSum -= a[windowStart];
                windowStart--;
            }
        }
        answer = secToTime(maxSumStart);
        return answer;
    }

    public int timeToSec(String time){
        String[] sp = time.split(":");
        int h = Integer.parseInt(sp[0]);
        int m = Integer.parseInt(sp[1]);
        int s = Integer.parseInt(sp[2]);
        return h*60*60 + m*60 +s;
    }
    public String secToTime(int second){
        int h = second/60/60;
        int m = (second/60) % 60;
        int s = second % 60;
        return String.format("%02d:%02d:%02d",h,m,s);
    }

    static class TimeLog {
        int start;
        int end;

        public TimeLog(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean include(int time){
            return start <= time && time < end;
        }
    }
}
