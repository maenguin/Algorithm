package programmers.stackqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BridgeTruck {



    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int minAnswer = bridge_length + truck_weights.length;

        int truckWeights = 0;

        for (int i = 0; i < truck_weights.length; i++) {
            for (int j = i; j < truck_weights.length && j < i + bridge_length; j++) {
                truckWeights += truck_weights[j];
            }
            System.out.println("truckWeights : "+truckWeights);
            if (truckWeights > weight){
                answer += (bridge_length-1);
            }
            truckWeights = 0;
        }

        System.out.println(answer + minAnswer);
        return answer + minAnswer;
    }

    public class Truck{

        private int weight;
        private int index;

        public Truck(int weight, int index) {
            this.weight = weight;
            this.index = index;
        }
    }


    public class Bridge{
        private Queue<Truck> queue;
        private int weight;
        private int bridgeLength;
        private int currentWeights;


        public Bridge(int weight, int bridgeLength) {
            this.weight = weight;
            this.bridgeLength = bridgeLength;
            queue = new LinkedList<Truck>();
        }



        public boolean offer(Truck truck){
            if (currentWeights + truck.weight > weight){
                return false;
            }
            queue.offer(truck);
            currentWeights += truck.weight;
            return true;
        }

        public Truck poll(){
            final Truck truck = queue.poll();
            currentWeights -= truck.weight;
            return truck;
        }
        public Truck peek(){
            return queue.peek();
        }
        public boolean isEmpty(){
            return queue.isEmpty();
        }

    }

    public int solution2(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Bridge bridge = new Bridge(weight,bridge_length);


        do {
            bridge.offer(new Truck(truck_weights[answer],answer));
            Truck truck = bridge.peek();
            if (truck.index + bridge_length == answer){
                bridge.poll();
            }


            answer++;
        }while (!bridge.isEmpty());

        return answer;
    }

}
