package programmers.level1;

import java.util.HashMap;

public class 키패드누르기 {

    public String solution(int[] numbers, String hand) {

        StringBuilder builder = new StringBuilder();

        HashMap<Integer,Point> keypad = new HashMap<>(){
            {
                put(1,new Point(0,0));
                put(2,new Point(0,1));
                put(3,new Point(0,2));
                put(4,new Point(1,0));
                put(5,new Point(1,1));
                put(6,new Point(1,2));
                put(7,new Point(2,0));
                put(8,new Point(2,1));
                put(9,new Point(2,2));
                put(0,new Point(3,1));
            }
        };
        char h = Character.toUpperCase(hand.charAt(0));
        Point left = new Point(3,0);
        Point right = new Point(3,2);


        for (int i = 0; i < numbers.length; i++) {
            Point point = keypad.get(numbers[i]);

            if (point.y == 0) {
                builder.append('L');
                left = point;
            } else if (point.y == 2) {
                builder.append('R');
                right = point;
            } else {

                int leftDiff = Math.abs(point.x - left.x) +  Math.abs(point.y - left.y);
                int rightDiff = Math.abs(point.x - right.x) +  Math.abs(point.y - right.y);

                if (rightDiff > leftDiff) {
                    builder.append('L');
                    left = point;
                } else if (rightDiff < leftDiff) {
                    builder.append('R');
                    right = point;
                } else {
                    builder.append(h);
                    if (h == 'R') {
                        right = point;
                    } else {
                        left = point;
                    }
                }

            }
        }


        return builder.toString();
    }


    static class Point {

        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
