package kakao.winter19;


import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Q4 {

    public long[] solution(long k, long[] room_number) {
        long[] answer = {};


//        HashMap<Long, Integer> hash = new HashMap<>();
//
//        for (long i = 1; i <= k; i++) {
//            //hash.put( i , hash.getOrDefault(i, 0) + 1);
//            hash.put( i , 0);
//        }
//        System.out.println("hash done");
//        for (int i = 0; i < room_number.length  ; i++) {
//            if (hash.containsKey(room_number[i])){
//                hash.remove(room_number[i]);
//                System.out.println("remove : "+room_number[i]);
//            }
//            else{
//                final Iterator<Long> iterator = hash.keySet().iterator();
//                while (true){
//                    final Long next = iterator.next();
//                    if (next > room_number[i]){
//                        room_number[i] = next;
//                        hash.remove(room_number[i]);
//                        break;
//                    }
//                }
//            }
//        }
//
//        System.out.println(Arrays.toString(room_number));


        HashMap<String, Integer> hash = new HashMap<>();

        for (int i = 0; i < room_number.length  ; i++) {
            if (hash.containsKey(Long.toString(room_number[i]))){

                for (long j = room_number[i] + 1; j <= k; j++) {
                    if (!hash.containsKey(Long.toString(j))) {
                        hash.put( Long.toString(j)  , 0);
                        System.out.println("put d : "+j );
                        break;
                    }
                }
            }
            else {
                hash.put( Long.toString(room_number[i])  , 0);
                System.out.println("put e : "+room_number[i]);
            }
        }








        return hash.keySet().stream().mapToLong(l -> Long.getLong(l)).toArray();
    }

}
