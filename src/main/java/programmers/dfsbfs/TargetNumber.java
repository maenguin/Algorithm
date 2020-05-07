package programmers.dfsbfs;


//문제 설명
//        n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
//
//        -1+1+1+1+1 = 3
//        +1-1+1+1+1 = 3
//        +1+1-1+1+1 = 3
//        +1+1+1-1+1 = 3
//        +1+1+1+1-1 = 3
//        사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
//
//        제한사항
//        주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
//        각 숫자는 1 이상 50 이하인 자연수입니다.
//        타겟 넘버는 1 이상 1000 이하인 자연수입니다.
//        입출력 예
//        numbers	target	return
//        [1, 1, 1, 1, 1]	3	5

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class TargetNumber {



    ///dfs로 해결
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int sum = 0;

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0,numbers[0]});
        stack.push(new int[]{0,-numbers[0]});


        boolean flag = false;

        int popIndex = -1;
        while (!stack.empty()) {
            final int[] pop = stack.pop();
            popIndex = pop[0];
            numbers[popIndex] = pop[1];

            //두번 더하면 교체가 되는식
            sum = flag? sum + (2*pop[1]) : sum + pop[1];

            System.out.println("pop : "+pop[1]+ " popIndex : "+pop[0]);

            if (popIndex + 1 != numbers.length) {
                stack.push(new int[]{popIndex+1,numbers[popIndex+1]});
                stack.push(new int[]{popIndex+1,-numbers[popIndex+1]});
            }
            else {
                flag = true;
                System.out.println(Arrays.toString(numbers));
                if (sum == target){
                    answer++;
                }
            }
        }

        System.out.println(answer);
        return answer;
    }

}
