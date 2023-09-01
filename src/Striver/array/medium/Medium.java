package Striver.array.medium;

import java.util.ArrayList;
import java.util.HashMap;

public class Medium {

    public static void main(String[] args) {

    }

    //2Sum Problem
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int i=0; i<nums.length; i++){
            int k=target-nums[i];
            if(hashMap.containsKey(k)){
                return new int[]{hashMap.get(k),i};
            }else {
                hashMap.put(nums[i],i);
            }
        }
        return new int[]{-1, -1};
    }

    //Sort an array of 0's 1's and 2's
    public void sortColors(int[] nums) {
        int low=0;
        int mid=0;
        int high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                int temp = nums[mid];
                nums[mid]=nums[low];
                nums[low]=temp;
                mid++;
                low++;
            }else if(nums[mid]==1){
                mid++;
            }else{
                int temp = nums[mid];
                nums[mid]=nums[high];
                nums[high]=temp;
                high--;
            }
        }
    }

    //Majority Element (>n/2 times)
    public int majorityElement(int[] arr) {
        int ansIndex=0;
        int count=0;
        for (int i=0; i<arr.length; i++){
            if (arr[i]==arr[ansIndex]){
                count++;
            }else {
                count--;
            }
            if (count==0){
                ansIndex=i;
                count=1;
            }
        }
        int countMajority=0;
        for (int i=0; i<arr.length; i++){
            if (arr[ansIndex]==arr[i]){
                countMajority++;
            }
        }
        if (countMajority>arr.length/2){
            return arr[ansIndex];
        }
        return 0;
    }

    //kadane's Maximum Subarray

    public int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int sum=0;
        int max_sum=nums[0];
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(sum>max_sum){
                max_sum=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return max_sum;
    }

    //Stock Buy and Sell
    //[7,1,5,3,6,4]
    public int maxProfit(int[] prices) {
        int buy_price =prices[0];
        int max_profit =0;
        for (int i=1; i<prices.length;i++){
            if (buy_price<prices[i]){
                int profit = prices[i]-buy_price;
                max_profit = Math.max(max_profit,profit);
            }else {
                buy_price=prices[i];
            }
        }
        return max_profit;
    }

    //Rearrange Array Elements by Sign
    public int[] rearrangeArray(int[] nums) {
        int posInx=0;
        int negInx=1;
        int[] arr  = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(nums[i]<0){
                arr[negInx] = nums[i];
                negInx+=2;
            }else{
                arr[posInx] = nums[i];
                posInx+=2;
            }
        }
        return arr;
    }

    //Next Permutation

    //Leaders in an Array problem
    public static ArrayList<Integer>
    printLeadersBruteForce(int[] arr, int n){
        ArrayList<Integer> ans= new ArrayList<>();
        // Last element of an array is always a leader,
        // push into ans array.
        int max = arr[n - 1];

        ans.add(arr[n-1]);

        // Start checking from the end whether a number is greater
        // than max no. from right, hence leader.
        for (int i = n - 2; i >= 0; i--)
            if (arr[i] > max) {
                ans.add(arr[i]);
                max = arr[i];
            }

        return ans;

    }

    //Longest Consecutive Sequence in an Array

    //Set Matrix Zero
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        int[] row = new int[n];
        int[] col = new int[m];

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (matrix[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (row[i] ==1 || col[j]==1){
                    matrix[i][j]=0;
                }
            }
        }
    }

    //Rotate Matrix by 90 degrees
    public void rotate(int[][] A) {
        int n=A.length;
        int[][] X = new int[n][n];

        for(int i=0; i<n;i++){
            int y=0;
            for(int j=n-1; j>=0;j--){
                X[i][y]=A[j][i];
                y++;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                A[i][j]=X[i][j];
            }
        }
    }

    //Print the matrix in spiral manner

    //Count subarrays with given sum
    public int subarraySum(int[] arr, int K) {
        int count = 0;
        int currSum = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i=0; i<arr.length; i++){
            currSum = currSum+arr[i];

            if (currSum-K==0){
                count++;
            }

            if (hashMap.containsKey(currSum-K)){
                count++;
            }

            hashMap.put(currSum,i);
        }
        return count;
    }


}
