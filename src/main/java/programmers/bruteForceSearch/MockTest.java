package programmers.bruteForceSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MockTest {

    public int[] solution(int[] answers) {
        int[] scores = new int[3];

        int[] student1 = new int[]{1,2,3,4,5};
        int[] student2 = new int[]{2,1,2,3,2,4,2,5};
        int[] student3 = new int[]{3,3,1,1,2,2,4,4,5,5};


        int curAnswer = 0;
        for (int i = 0; i < answers.length; i++) {
            curAnswer = answers[i];

            if (curAnswer == student1[i % (student1.length)])
                scores[0]++;
            if (curAnswer == student2[i % (student2.length)])
                scores[1]++;
            if (curAnswer == student3[i % (student3.length)])
                scores[2]++;

        }

        System.out.println("scores[0] : "+scores[0]);
        System.out.println("scores[1] : "+scores[1]);
        System.out.println("scores[2] : "+scores[2]);

        int score1 = scores[0];
        int score2 = scores[1];
        int score3 = scores[2];
        List<Integer> list = new ArrayList<>();

        Arrays.sort(scores);
        if (scores[2] == score1)
            list.add(1);
        if (scores[2] == score2)
            list.add(2);
        if (scores[2] == score3)
            list.add(3);
        return list.stream().mapToInt(a->a).toArray();
    }



}
