package kakao;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//2018 KAKAO BLIND RECRUITMENT
public class 방금그곡 {

    public String solution(String m, String[] musicinfos) {
        String answer = "";

        List<MusicInfo> matchedMusicList = new ArrayList<>();

        for (int i = 0; i < musicinfos.length; i++) {
            String[] split = musicinfos[i].split(",");
            MusicInfo mi = new MusicInfo(split[0], split[1], split[2], split[3], i);
            if (mi.match(m)) {
                matchedMusicList.add(mi);
            }
        }
        Collections.sort(matchedMusicList);


        return matchedMusicList.size() > 0 ? matchedMusicList.get(0).title : "(None)";
    }

    static class MusicInfo implements Comparable<MusicInfo>{
        private String beginTime;
        private String endTime;
        private String title;
        private String score;
        private int inputOrder;

        public MusicInfo(String beginTime, String endTime, String title, String score, int inputOrder) {
            this.beginTime = beginTime;
            this.endTime = endTime;
            this.title = title;
            this.score = score;
            this.inputOrder = inputOrder;
        }

        public int getPlayTime() {

            LocalTime beg = LocalTime.parse(beginTime);
            LocalTime end = LocalTime.parse(endTime);

            LocalTime minus = end.minus(Duration.ofMinutes(beg.getHour() * 60 + beg.getMinute()));

            return minus.getHour()*60 + minus.getMinute();

        }

        public boolean match(String score) {
            List<String> originNotes = new ArrayList<>();
            Matcher matcher = Pattern.compile("([A-Z]#?)").matcher(this.score);
            while (matcher.find()) {
                originNotes.add(matcher.group(1));
            }

            int playTime = getPlayTime();

            StringBuilder listenNotes = new StringBuilder();
            for (int i = 0; i < playTime; i++) {
                listenNotes.append(originNotes.get(i % originNotes.size()));
            }


            Pattern pattern2 = Pattern.compile(String.format("(%s[^#]|%s$)",score,score));
            Matcher matcher2 = pattern2.matcher(listenNotes);
            return matcher2.find();
        }

        @Override
        public int compareTo(MusicInfo o) {
            int pt1 = this.getPlayTime();
            int pt2 = o.getPlayTime();

            return pt1 > pt2 ? -1 : pt1 < pt2 ? 1 : Integer.compare(this.inputOrder,o.inputOrder);
        }
    }


    /**
     * feedback
     * C# -> V 처럼 미리 replace 하면 획기적으로 쉽게 풀 수 있다..
     */

}
