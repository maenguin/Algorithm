package kakao;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

//2020 카카오 인턴십
public class 수식최대화 {

    Map<String, Integer> priorMap = new HashMap<>();

    public long solution(String expression) {
        long answer = 0;
        List<Long> prizes = new ArrayList<>();

        //순열 최소화 작업
        String[] ops = {"*","+","-"};
        for (String op : ops) {
            if (expression.contains(op)) {
                priorMap.put(op,0);
            }
        }

        //계산식 토큰화
        String[] exps = expression.split("((?<=[-+*])|(?=[-+*]))");

        //순열 생성
        Permutation permutation = new Permutation(new int[]{0,1,2},3,3);
        int[][] perms = permutation.getResult();

        for (int[] perm : perms) {
            int idx = 0;
            //순열에 따른 연산자 우선순위 변경
            for (String s : priorMap.keySet()) {
                priorMap.put(s, perm[idx++]);
            }
            System.out.println("priorMap = " + priorMap);
            List<String> backExpression = convertToBackExpression(exps);
            System.out.println("backExpression = " + backExpression);
            String result = calculateBackExpression(backExpression);
            prizes.add(Math.abs(Long.valueOf(result)));
        }


        Collections.sort(prizes, Collections.reverseOrder());

        return prizes.get(0);
    }

    //후위표현식 변환
    private List<String> convertToBackExpression(String[] expression) {
        List<String> backExpression = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        for (String s : expression) {

            //연산자인경우
            if (priorMap.containsKey(s)) {

                //연산자 우선순위가 같거나 작은 연산자를 전부 꺼냄
                while (!stack.isEmpty() && priorMap.get(stack.peek()) <= priorMap.get(s)){
                    backExpression.add(stack.pop());
                }
                stack.push(s);
            } else {
                backExpression.add(s);
            }
        }
        while (!stack.isEmpty()){
            backExpression.add(stack.pop());
        }
        return backExpression;
    }

    //후위표현식 계산
    private String calculateBackExpression(List<String> backExpression){
        Stack<String> stack = new Stack<>();
        for (String s : backExpression) {
            if (priorMap.containsKey(s)) {
                long calculate = calculate(s, stack.pop(), stack.pop());
                stack.push(String.valueOf(calculate));
            } else {
                stack.push(s);
            }
        }
        return stack.pop();
    }

    private long calculate(String op, String a, String b) {
        long result = 0;
        switch (op) {
            case "*" : result = Long.valueOf(b) * Long.valueOf(a); break;
            case "+" : result = Long.valueOf(b) + Long.valueOf(a); break;
            case "-" : result = Long.valueOf(b) - Long.valueOf(a); break;
        }
        return result;
    }

    static class Permutation {

        private int[] arr;
        private int n;
        private int r;
        private int[][] result;
        private int index;


        public Permutation(int[] arr, int n, int r) {
            this.n = n;
            this.r = r;
            int factorial = IntStream.rangeClosed(1,n).reduce(1, (x, y) -> x * y);
            result = new int[factorial][r];
            this.arr = arr;
        }

        public int[][] getResult() {
            unstablePermutation(arr,n,r,0);
            return result;
        }

        private void unstablePermutation(int[] arr, int n, int r, int depth) {
            if (depth == r) {
                for (int i = 0; i < r; i++) {
                    result[index][i] = arr[i];
                }
                index++;
                return;
            }

            for (int i = depth; i < n; i++) {
                swap(arr, depth, i);
                unstablePermutation(arr, n, r, depth + 1);
                swap(arr, depth, i);
            }
        }

        void swap(int[] arr, int depth, int i) {
            int temp = arr[depth];
            arr[depth] = arr[i];
            arr[i] = temp;
        }

    }



}
