package programmers.stackqueue;

//
//쇠막대기
//        문제 설명
//        여러 개의 쇠막대기를 레이저로 절단하려고 합니다. 효율적인 작업을 위해서 쇠막대기를 아래에서 위로 겹쳐 놓고, 레이저를 위에서 수직으로 발사하여 쇠막대기들을 자릅니다. 쇠막대기와 레이저의 배치는 다음 조건을 만족합니다.
//
//        - 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있습니다.
//        - 쇠막대기를 다른 쇠막대기 위에 놓는 경우 완전히 포함되도록 놓되, 끝점은 겹치지 않도록 놓습니다.
//        - 각 쇠막대기를 자르는 레이저는 적어도 하나 존재합니다.
//        - 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않습니다.


import java.util.ArrayList;
import java.util.Stack;

class line {
    private int laserNum;

    public int getLaserNum() {
        return laserNum;
    }

    public void increaseLaser() {
        this.laserNum += 1;
    }
}

public class Q01 {

    public int solution(String arrangement) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        Stack<line> lines = new Stack<>();

        for (char c: arrangement.toCharArray()) {

            if ( c == ')' ) {

                if (stack.peek() == '(' ) {
                    stack.pop();
                    stack.push('.');
                    continue;
                }
            }
            stack.push(c);

        }
        System.out.println(stack.toString());
        for (int i = 0 ; i < stack.size() ; i ++) {
            char c = stack.elementAt(i);
            System.out.println(c);

            switch (c) {
                case '(' : lines.push( new line()); break;
                case '.' : lines.forEach(line -> line.increaseLaser()); break;
                case ')' : answer += lines.pop().getLaserNum() + 1; break;
            }

        }



        return answer;
    }

    //인덱스적으로 접근
    //레이져를 만나면 스택에 남아있는 ( 개수만큼 1을 더해주고
    //라인이 끝나면 +1을 해주었다
    public int anotherSolution(String arrangement) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arrangement.length(); i++) {

            if (arrangement.charAt(i) == ')') {


                //바로 옆친구일 경우
               if (stack.peek() + 1 == i) {
                   stack.pop();
                   System.out.println(stack.size());
                   answer += stack.size();
               }
               else {
                   answer += 1;
                   stack.pop();
               }
            }
            else {
                stack.push(i);
            }



        }

        return answer;
    }



}
