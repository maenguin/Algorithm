package programmers.level2;

import java.util.Arrays;

public class 구명보트 {

    public int solution2(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);


        for (int i = 0; i < people.length; i++) {

            int person1 = people[i];
            if (person1 == 0)
                continue;

            if (person1 * 2 > limit) {
                answer++;
                people[i] = 0;
                continue;
            }

            int minDiffIdx = 0;
            for (int j = i + 1; j < people.length; j++) {

                int person2 = people[j];
                if (person2 == 0)
                    continue;

                int sum = person1 + person2;
                if (sum > limit)
                    break;

                minDiffIdx = j;

            }

            people[i] = 0;
            if (minDiffIdx != 0) {
                people[minDiffIdx] = 0;
            }
            answer++;

        }

        return answer;
    }

    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int i = 0;
        int j = people.length - 1;

        while (i <= j) {
            int personI = people[i];
            int personJ = people[j];
            int sum = personI + personJ;

            if (sum <= limit) {
                i++;
            }
            j--;
            answer++;
        }


        return answer;
    }

}
