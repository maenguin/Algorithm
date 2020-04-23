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
        private int bridgeEntryTime;

        public Truck(int weight, int bridgeEntryTime) {
            this.weight = weight;
            this.bridgeEntryTime = bridgeEntryTime;
        }
    }


    public class Bridge{
        private Queue<Truck> queue;
        private int limitWeight;
        private int Length;
        private int totalWeight;

        public Bridge(int weight, int bridgeLength) {
            this.limitWeight = weight;
            this.Length = bridgeLength;
            queue = new LinkedList<Truck>();
        }

        public boolean offer(Truck truck){
            if (totalWeight + truck.weight > limitWeight){
                return false;
            }
            queue.offer(truck);
            totalWeight += truck.weight;
            return true;
        }

        public Truck poll(){
            final Truck truck = queue.poll();
            totalWeight -= truck.weight;
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
        int time = 0;
        int truckIndex = 0;
        Bridge bridge = new Bridge(weight,bridge_length);

        do {

            if (!bridge.isEmpty()){
                Truck headTruck = bridge.peek();
                if (headTruck.bridgeEntryTime + bridge_length == time){
                    bridge.poll();
                }
            }

            if (truckIndex < truck_weights.length){
                Truck nextTruck = new Truck(truck_weights[truckIndex],time);
                if (bridge.offer(nextTruck)){
                    truckIndex++;
                }
            }
            time++;

        }while (!bridge.isEmpty());

        answer = time;

        return answer;
    }

}
