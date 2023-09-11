package Striver.slidingWindow;

import array.Subsequence;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class FixedSize {
    public static void main(String[] args) {
        int[] arr = {2,5,1,8,2,9,1};
        System.out.println(subArraySum(arr,3));

    }

    //maximum sum subarray of size k
    public static int subArraySum(int[] nums, int k){

        int sum=0;
        for(int i=0; i<k; i++){
            sum+= nums[i];
        }
        int j=k;
        int i=0;
        int maxSum=sum;
        while (j<nums.length){
            sum = sum+nums[j]-nums[i];
            j++;
            i++;
            maxSum = Math.max(maxSum,sum);
        }

        return maxSum;
    }

    //Maximum of all subarrays of size k
    //Sliding Window Maximum
    public int[] maxSlidingWindow(int[] A, int B) {
        PriorityQueue<Integer> priorityQueue= new PriorityQueue<>(Collections.reverseOrder());
        int[] res = new int[A.length-B+1];

        int i=0;
        for (;i<B; i++){
            priorityQueue.add(A[i]);
        }

        int k=1;
        res[0] = priorityQueue.peek();

        priorityQueue.remove(A[0]);

        for (; i<A.length; i++){
            priorityQueue.add(A[i]);
            res[k]=priorityQueue.peek();
            k++;
            priorityQueue.remove(A[i-B+1]);
        }

        return res;
    }

    public int lengthOfLongestSubstring(String s) {
        int left=0,right=0;
        Set<Character> seen = new HashSet<>();
        int max=0;
        while (right<s.length()){
            char c = s.charAt(right);
            if (seen.add(c)){
                max = Math.max(right-left+1,max);
                right++;
            }else {
                while (s.charAt(left) != c){
                    seen.remove(s.charAt(left));
                    left++;
                }
                seen.remove(c);
                left++;
            }
        }
        return max;
    }
}
