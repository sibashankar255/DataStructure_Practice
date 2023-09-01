package Striver.array.easy;

import java.util.HashMap;
import java.util.Map;

public class Easy {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,7,11,44,0,9};
        System.out.println(secondLargest(arr));
    }

    //Largest Element in an Array
    public static int largest(int[] arr){
        int max = arr[0];
        for (int i=1; i<arr.length; i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }

    //Second the Largest Element in an Array
    public static int secondLargest(int[] arr){
        int max=arr[0];
        int secondMax = arr[0];

        for (int i=1; i<arr.length; i++){
            if (arr[i]>max){
                secondMax=max;
                max=arr[i];
            }
        }
        return secondMax;
    }

    //Check if the array is sorted
    public static boolean isSorted(int[] arr){
        int count=0 ;
        for(int i=0 ;i<arr.length;i++){
            if(arr[i]>arr[(i+1)%arr.length])
                count++;
        }
        return (count<=1);
    }

    //Remove duplicates from Sorted array
    public int removeDuplicates(int[] nums) {
        int ptr=1;
        for(int i=0; i< nums.length-1; i++){
            if(nums[i] != nums[i+1]){
                nums[ptr] = nums[i+1];
                ptr++;
            }
        }
        return ptr;
    }

    //Left Rotate an array by one place
    public void rotate(int[] A, int B) {
        int n = A.length;
        B=B%n;
        reverse(A, 0, n-1);
        reverse(A,0, B-1);
        reverse(A,B,n-1);
    }
    public int[] reverse(int[] A, int s, int e){
        int k=0;
        while(s<e){
            k=A[s];
            A[s]=A[e];
            A[e]=k;
            s++;
            e--;
        }
        return A;
    }

    //Move Zeros to end
    public void moveZeroesTwoPointer(int[] arr) {
        int n = arr.length;
        if(n<=1) return;
        int s=0;
        int e=1;
        while(e<n){
            if(arr[s]==0 && arr[e]!=0){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e++;
            }else if(arr[s]==0 && arr[e]==0){
                e++;
            }else{
                s++;
                e++;
            }
        }
    }
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int num:nums){
            if(num != 0){
                nums[i] = num;
                i++;
            }
        }
        while(i<nums.length){
            nums[i] = 0;
            i++;
        }
    }

    //Linear Search
    public static int linearSearch(int[] arr, int k){
        for (int i=0; i<arr.length; i++){
            if (arr[i]==k){
                return i;
            }
        }
        return -1;
    }

    //Find missing number in an array
    //based on XOR property  a^a=0
    public static int missingNumber(int[] nums){
        int n = nums.length;
        int xor1 = 0;
        int xor2 = 0;
        for(int i=1; i<n; i++){
            xor1= xor1^i;
        }

        for(int i=0; i<n; i++){
            xor2= xor2^nums[i];
        }

        xor1=xor1^n;

        return xor1^xor2;
    }

    //Maximum Consecutive Ones
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int count=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==1){
                count++;
                max = Math.max(max,count);
            }else{
                count=0;
            }
        }
        return max;
    }

    //Find the number that appears once, others two
    public int singleNumber(int[] nums) {
        int xor=0;
        for(int i=0; i<nums.length; i++){
            xor = xor^nums[i];
        }
        return xor;
    }

    //Longest Subarray with given Sum K
    public static int getLongestSubarray(int []a, long k) {
        int n = a.length; // size of the array.

        int left = 0, right = 0; // 2 pointers
        long sum = a[0];
        int maxLen = 0;
        while (right < n) {
            // if sum > k, reduce the subarray from left
            // until sum becomes less or equal to k:
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }

            // if sum = k, update the maxLen i.e. answer:
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // Move forward thw right pointer:
            right++;
            if (right < n) sum += a[right];
        }

        return maxLen;
    }

    //Longest Subarray with sum K | [Postives and Negatives]
    public static int largestSubArraySum(int[] arr, int sum){
        int n =arr.length;
        int prefixSum=0;
        int start=0;
        int end=-1;
        int maxLen =0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i=0; i<n; i++){
            prefixSum = prefixSum+arr[i];

            if (prefixSum==sum){
                start=0;
                end=i;
                maxLen = Math.max(maxLen,end-start+1);
            }

            if (hashMap.containsKey(prefixSum-sum)){
                start = hashMap.get(prefixSum-sum)+1;
                end=i;
                maxLen = Math.max(maxLen,end-start+1);
            }

            hashMap.put(prefixSum,i);
        }

        return maxLen;
    }

    //largest subarray with equal number of 1 & 0

    //replace all 0 with 1 and


}
