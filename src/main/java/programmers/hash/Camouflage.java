package programmers.hash;

//위장 문제

//문제 설명
//        스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
//
//        예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
//
//        종류	이름
//        얼굴	동그란 안경, 검정 선글라스
//        상의	파란색 티셔츠
//        하의	청바지
//        겉옷	긴 코트
//        스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
//
//        제한사항
//        clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
//        스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
//        같은 이름을 가진 의상은 존재하지 않습니다.
//        clothes의 모든 원소는 문자열로 이루어져 있습니다.
//        모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
//        스파이는 하루에 최소 한 개의 의상은 입습니다.


import java.util.*;


public class Camouflage {



    ///머리를 한대 맞은 기분이다.
    //이 문제를 풀려고 조합에 관련된 알고리즘을 재귀로도 비재귀로도 구현했지만
    //테스트1이 계속 시간초과로 실패했다.
    //그러나 단 하나의 영감이 코드의 길이와 복잡도를 말도안되게 줄여주었다...
    //착용하지 않은 경우를 경우로 포함하는것...................
    public int solution(String[][] clothes) {

        int answer = 1;
        HashMap<String, Integer> hash = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            hash.put(clothes[i][1], hash.getOrDefault(clothes[i][1], 0) + 1);
        }

        for (String key :hash.keySet()) {
            answer *= (hash.get(key) + 1);
        }

        return answer -1;
    }



    ////이 밑은 삽질한것들.....

//    public int solution(String[][] clothes) {
//
//        int answer = 0;
//        int[] hashIndex;
//        int idx = 0;
//        HashMap<String, Integer> hash = new HashMap<>();
//
//        for (int i = 0; i < clothes.length; i++) {
//            hash.put(clothes[i][1], hash.getOrDefault(clothes[i][1],0) + 1);
//        }
//
//        hashIndex = new int[hash.size()];
//
//        for (String key:hash.keySet()) {
//            hashIndex[idx] = hash.get(key);
//            idx++;
//
//        }
//
//        for (int i = 0; i < hash.size(); i++) {
//
//            List<int[]> combination = combination(hash.size(),i + 1);
//            for (int j = 0; j < combination.size(); j++) {
//                int mul = 1;
//                for (int k = 0; k < combination.get(j).length; k++) {
//
//                    mul *= hashIndex[combination.get(j)[k]];
//                }
//
//                answer += mul;
//            }
//        }
//
//        return answer;
//    }


    //nCr은 n-1Cr + n-1Cr-1 인걸 이용했다.
    //예를 들어 0 1 2 4개중에 2개를 뽑는 경우의 수는
    //(0,x) 0을 뽑는걸 가정하고 나머지 3개중에 하나를 뽑는 경우와
    //(x,x) 0을 제외한 나머지 3개중에 두개를 뽑는 경우의 합이라고 할 수 있다.

    public static List<int[]> combination(int n, int r) {

        int[] arr = new int[r];
        List<int[]> arrList = new ArrayList<>();
        com_non_rcursive(arr,0,n,r,0,arrList);
        return arrList;
    }
    public static void com_non_rcursive(int[] arr, int index, int n, int r, int target,List<int[]> arrList) {
        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[]{index,n,r,target});
        while (!stack.isEmpty()) {
            Integer[] arr2 = stack.pop();
            int index2 = arr2[0];
            int n2 = arr2[1];
            int r2 = arr2[2];
            int target2 = arr2[3];

            if (r2 == 0) arrList.add(Arrays.copyOf(arr,arr.length));
            else if (target2 ==n2)
                continue;
            else { arr[index2] = target2;
                stack.push(new Integer[]{index2,n2,r2,target2+1});
                stack.push(new Integer[]{index2+1,n2,r2-1,target2+1});
            }

        }

    }


    public static void combination(int n, int r, int index, int target,int[] arr,List<int[]> arrList) {
        if (r==0) {
            arrList.add(Arrays.copyOf(arr,arr.length));
            return ;
        }

        arr[index] = target;
        if (n == r) {
            arrList.add(Arrays.copyOf(arr,arr.length));
            return ;
        }
        combination(n-1,r-1,index +1 ,target + 1, arr,arrList);
        combination(n-1,r,index,target + 1, arr,arrList);
    }

    public static void combination2(int[] arr, int index, int n, int r, int target,List<int[]> arrList) {
        if (r == 0) {
            arrList.add(Arrays.copyOf(arr,arr.length));
            return;
        }
        else if (target == n)
            return;
        else { arr[index] = target;
            combination2(arr, index + 1, n, r - 1, target + 1,arrList);
            combination2(arr, index, n, r, target + 1,arrList);
        }
    }


}
