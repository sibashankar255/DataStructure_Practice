package graph.anuj;

import java.util.*;

public class Overview {


    public int[][] threeSum(int[] num) {
        if (num==null || num.length<3){
            return new int[0][];
        }
        Arrays.sort(num);

        Set<List<Integer>> result = new HashSet<>();

        //fix the first element and find the other 2 elements
        for (int i=0; i<num.length-2; i++){

            if (i>0 && num[i]==num[i-1]){
                continue;
            }

            int left = i+1;
            int right = num.length-1;

            while (left<right){
                int sum= num[i] + num[left] + num[right];

                if (sum==0){
                    result.add(Arrays.asList(num[i],num[left],num[right]));

                    while (left<right && num[left]==num[left+1]){left++;}
                    while (left<right && num[right]==num[right-1]){right--;}

                    left++;
                    right--;
                }else if(sum<0){
                    left++;
                }else {
                    right--;
                }
            }
        }
//        return new ArrayList<>(result);

        int[][] arr = result.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);

        return arr;
    }
}
