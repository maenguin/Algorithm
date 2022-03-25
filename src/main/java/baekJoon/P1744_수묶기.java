
package baekJoon;


import java.util.Arrays;
import java.util.Scanner;

//문제 출처 : https://www.acmicpc.net/problem/1744
//노션 링크 : https://delirious-sock-4dc.notion.site/1774-ebe7c17fc2f24a1a871a462f43d9a658
//문제 유형 : 그리디
public class P1744_수묶기 {

    //1. 음수와 양수는 묶지 않는다.
    //2. 양수는 양수끼리 묶는다.
    //2.1 양수는 큰값끼리 묶는다.
    //2.2 양수는 0과 묶지 않는다.
    //2.3 양수는 1과 묶지 않는다.
    //3. 음수는 음수끼리 묶는다.
    //3.1 음수는 작은값끼리 묶는다.
    //3.2 음수는 짝이 남으면 0과 묶는다.
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        if (N == 1) {
            System.out.println(nums[0]);
            return;
        }
        int answer = 0;
        //음수끼리 묶는 부분
        for (int i = 0; i < N && nums[i] < 0; i += 2) {
            //음수 하나만 남은 경우
            if (i + 1 >= N) {
                answer += nums[i];
                break;
            }
            //묶었을때 > 0 이면 더하고 아니면 i번쨰 수만 더한다.
            //묶었을때 = 0 이면 음수 * 0 = 0 이므로 더해준다.
            int mul = nums[i] * nums[i + 1];
            answer += mul >= 0 ? mul : nums[i];
        }
        //양수끼리 묶는 부분
        for (int i = N - 1; i >= 0 && nums[i] > 0; i -= 2) {
            //양수 하나만 남은 경우
            if (i - 1 < 0) {
                answer += nums[i];
                break;
            }
            //양수끼리 묶으면 > 0
            int mul = nums[i] * nums[i - 1];
            //양수와 1을 묶으면 곱보다 합이 더크다
            int pls = nums[i] + nums[i - 1];
            answer += mul > 0 ? Math.max(mul, pls) : nums[i];
        }
        System.out.println(answer);
    }

}
