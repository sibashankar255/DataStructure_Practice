package dynamicProgramming.Scaler;

import java.util.Arrays;
import java.util.List;

public class OneD {

    public static void main(String[] args) {

        int n = 6;
        int[] array = new int[n+1];

        Arrays.fill(array,-1);
        findFibonacci(array,n);

        int[] arr ={2,3,-2,4};

        System.out.println(maxProduct(arr));





    }

    public int climbStairs(int n) {
        if(n==1){
            return n;
        }
        int[] dp = new int[n+1];

        dp[1]=1;
        dp[2]=2;

        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static int findFibonacci(int[] array, int n){
        if(n<=1){
            return n;
        }

        if (array[n] >= 0) {
            return array[n];
        }

        array[n] = findFibonacci(array, n-1)+findFibonacci(array, n-2);

        return array[n];
    }


    //Perfect Squares using recursion

    public int numSquares(int n){
        return rec(n);
    }

    private static int rec(int n) {
        if (n<0){
            return Integer.MAX_VALUE;
        }
        if (n==0){
            return 0;
        }
        int min=n;
        for (int i=1; i*i<n; i++){
            int small = rec(n-(i*i));
            min = Math.min(small,min);
        }

        return min+1;
    }

    //Perfect Squares using memoization
    public int numSquaresMemo(int n){
        int[] memo = new int[n=1];
        return recMemo(n,memo);
    }

    private static int recMemo(int n, int[] memo) {
        if (n<0){
            return Integer.MAX_VALUE;
        }
        if (n==0){
            return 0;
        }
        if (memo[n]>0){
            return memo[n];
        }

        int min=n;
        for (int i=1; i*i<n; i++){
            int small = recMemo(n-(i*i), memo);
            min = Math.min(small,min);
        }

        memo[n] = min+1;

        return min+1;
    }

    //house rob 1


    public static int rob(int[] nums) {
        // Base case: If there are fewer than 2 houses, return the value of the only house (if it exists).
        if (nums.length < 2) {
            return nums[0];
        }

        // Create an array 'dp' to store the maximum money that can be robbed up to the i-th house.
        int[] dp = new int[nums.length];

        // Initialize the first two elements of 'dp' based on the money available in the first two houses.
        dp[0] = nums[0]; // Rob the first house.
        dp[1] = Math.max(nums[0], nums[1]); // Rob either the first or the second house, whichever has more money.

        // Iterate through the houses starting from the third house (index 2).
        for (int i = 2; i < nums.length; i++) {
            // The maximum money that can be robbed at the i-th house is the maximum of two scenarios:
            // 1. Rob the current house (nums[i]) and add it to the money robbed from i-2 houses (dp[i-2]).
            // 2. Skip the current house and take the maximum money robbed up to the previous house (dp[i-1]).
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        // The final element of 'dp' contains the maximum money that can be robbed from all the houses.
        return dp[nums.length - 1];
    }

    //House Robber II
    public static int rob2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums[0];
        }

        // Create two arrays to represent two scenarios:
        int[] skipLastHouse = new int[n - 1];  // Skips the last house
        int[] skipFirstHouse = new int[n - 1]; // Skips the first house

        // Populate the two arrays to create linear rows of houses
        for (int i = 0; i < n - 1; i++) {
            skipLastHouse[i] = nums[i];
            skipFirstHouse[i] = nums[i + 1];
        }

        // Calculate the maximum amount of money by considering two scenarios
        int lootSkippingLast = rob(skipLastHouse);   // Robbing from skipLastHouse
        int lootSkippingFirst = rob(skipFirstHouse); // Robbing from skipFirstHouse

        // Return the maximum of the two scenarios
        return Math.max(lootSkippingLast, lootSkippingFirst);
    }


    //Maximum Product Subarray
    public static int maxProduct(int[] A) {
        int n = A.length;
        int[] dp = new int[n];
        dp[0] = A[0];

        int max = dp[0];
        for(int i = 1; i < n; i++){
            // we are finding the max product so zero will cause the issue
            // anything multiplied by zero is zero, so if previous dp is zero then consider it as 1.
            dp[i] = Math.max(A[i], (dp[i - 1] == 0 ? 1 : dp[i - 1]) * A[i]);
            max = Math.max(dp[i], max);
        }

        return max;
    }


//    public List<String> letterCombinations(String digits) {
//
//    }

}
