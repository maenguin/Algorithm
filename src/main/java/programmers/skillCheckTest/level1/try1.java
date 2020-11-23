package programmers.skillCheckTest.level1;

import java.util.Arrays;
import java.util.Stack;

public class try1 {

    public String solution(String[] seoul) {
        String answer = "";

        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")){
                answer = "김서방은 "+i+"에 있다";
            }
        }

        return answer;
    }


    private Stack<Integer> baguni = new Stack<>();

    public int solution2(int[][] board, int[] moves) {
        int answer = 0;

        for (int move : moves){

            for (int i = 0; i < board.length; i++) {
                int boardItem = board[i][move-1];
                if (boardItem != 0){
                    answer += pushDollToBaguni(boardItem);
                    board[i][move-1] = 0;
                    break;
                }

            }

        }

        return answer;
    }

    private int pushDollToBaguni(int doll){
        if (dollMatched(doll)){
            baguni.pop();
            return 2;
        }
        else{
            baguni.push(doll);
        }
        return 0;
    }

    private boolean dollMatched(int doll){
        if (!baguni.isEmpty()){
            return baguni.peek() == doll;
        }
        return false;
    }


}
