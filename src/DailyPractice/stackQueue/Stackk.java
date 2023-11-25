package DailyPractice.stackQueue;

import java.util.*;

public class Stackk {
    public static void main(String[] args) {

        int[] arr ={1,2,1};
//        for (int i :nextGreaterElements(arr)){
//            System.out.println(i);
//        }

    }

    //Check the expression has valid or Balanced parenthesis or not.
    public boolean isValid(String s) {
        HashMap<Character,Character> hashMap = new HashMap<>();
        hashMap.put(')','(');
        hashMap.put('}','{');
        hashMap.put('[','[');

        Stack<Character> stack = new Stack<Character>();

        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                stack.push(s.charAt(i));
                continue;
            }
            if (stack.size()==0 || hashMap.get(s.charAt(i))!=stack.pop()){
                return false;
            }
        }
        if (stack.size()==0){
            return true;
        }
        return false;
    }

    //Reverse a String using Stack


    //Find the next Greater element
    public static int[] nextGreaterElements(int[] nums1,int[] nums2) {
        Map<Integer, Integer> nextGreatest = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2){
            while (!stack.isEmpty() && stack.peek()<num){
                nextGreatest.put(stack.pop(),num);
            }
            stack.push(num);
        }
        for (int i=0; i<nums1.length; i++){
            nums1[i] = nextGreatest.getOrDefault(nums1[i],-1);
        }
        return nums1;

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        if (nums2.length == 0 || nums1.length == 0)
            return new int[0];

        Map<Integer, Integer> numberNGE = new HashMap<>();
        Stack<Integer> numStack = new Stack<>();

        numStack.push(nums2[nums2.length - 1]);
        numberNGE.put(nums2[nums2.length - 1], -1);

        for (int i = nums2.length - 2; i >= 0; i--) {

            if (nums2[i] < numStack.peek()) {
                numberNGE.put(nums2[i], numStack.peek());
                numStack.push(nums2[i]);
                continue;
            }

            while (!numStack.isEmpty() && numStack.peek() < nums2[i])
                numStack.pop();

            if (numStack.isEmpty()) {
                numStack.push(nums2[i]);
                numberNGE.put(nums2[i], -1);
            } else {
                numberNGE.put(nums2[i], numStack.peek());
                numStack.push(nums2[i]);
            }
        }

        for (int i = 0; i < nums1.length; i++)
            nums1[i] = numberNGE.get(nums1[i]);

        return nums1;
    }


    //Next Greater Element II
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        Arrays.fill(output,-1);
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<n*2; i++){
            while (!stack.isEmpty() && nums[stack.peek()]<nums[i%n]){
                output[stack.pop()] =nums[i%n];
            }
            if (i<n) stack.push(i);
        }
        return output;
    }

    //Merge Overlapping Intervals
    public int[][] merge(int[][] intervals) {
        if (intervals.length<=1){
            return intervals;
        }
        Arrays.sort(intervals,(arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        List<int []> output = new ArrayList<>();
        int[] current_interval = intervals[0];
        output.add(current_interval);

        for (int[] interval : intervals){
            int current_begin = current_interval[0];
            int current_end = current_interval[1];
            int next_begin = interval[0];
            int next_end = interval[1];

            if (current_end>=next_begin){
                current_interval[1]=Math.max(current_end,next_end);
            }else {
                current_interval=interval;
                output.add(current_interval);
            }
        }
        return output.toArray(new int[output.size()][]);
    }

}
