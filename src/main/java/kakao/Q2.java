package kakao;

import java.util.Stack;

public class Q2 {



        public String cutPre(String s){
            if (s.isEmpty() && s.length() <= 1) return "";
            return  s.substring(1);
        }
        public String cutPost(String s){
            if (s.isEmpty() && s.length() <= 1) return "";
            return  s.substring(0,s.length()-1);
        }
        public String cutSide(String s){
            return cutPost(cutPre(s));
        }

        public String solution(String p) {
            if (p.isEmpty()){
                return "";
            }
            String answer = "";

            Stack<Integer> stack = new Stack<>();

            //u v 분리 index찾기 균형잡힌 괄호 문자열
            int i = 0;
            int checkBalance = 0;
            do {
                checkBalance =  p.charAt(i) == ')' ? checkBalance +1 : checkBalance -1;
                i++;
            } while (checkBalance != 0);


            String u = p.substring(0,i);
            System.out.println("u : "+u+i);
            String v = "";
            if (p.length() < i){
                v = p.substring(i);
            }
            System.out.println("v : "+v);


            stack.clear();
            for (int j = 0; j < u.length(); j++) {

                if (!stack.empty() && u.charAt(j) == ')') {
                    stack.pop();
                }
                else {
                    stack.push(j);
                }
            }

            //올바른 문자열인경우
            if (stack.empty()){
                answer = u + solution(v);
                System.out.println("올바름 " +answer);
                System.out.println("재귀전ㅍ " +v);
                System.out.println("재귀 " +solution(v));
            }
            else{
                u = cutSide(u);
                System.out.println("cutted : "+u);
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < u.length(); j++) {
                    if (p.charAt(j) == ')') {
                        s.append('(');
                    }
                    else {
                        s.append(')');
                    }
                }
                answer =  "("+solution(v)+")" + s.toString();
                System.out.println("s.toString() : "+s.toString());
                System.out.println("answer" + answer);
            }

            return answer;
        }

}
