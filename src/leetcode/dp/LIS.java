package leetcode.dp;

import java.util.Arrays;
import java.util.List;

public class LIS {
    //300. Longest Increasing Subsequence
    public int lengthOfLIS(int[] arr) {
        int n= arr.length;

        //take a dp array to store, how many previous elements smaller than arr[i]
        int[] dp = new int[n];

        int overall_max=0;

        for (int i=0; i<n; i++){
            //at every element need to check the maximum how many elements smaller than itself
            //initialize max
            int max=0;
            //check how many elements(0 to i) smaller than arr[i], running another loop
            for (int j=0; j<i; j++){
                if (arr[j]<arr[i]){
                    //if arr[i] is greater than arr[j] then check if dp[j] > max and update it
                    if (dp[j]>max){
                        max=dp[j];
                    }
                }
            }
            //if no element is smaller than this element then update it with 1
            dp[i] = max+1;

            //overall maximum subsequence
            overall_max = Math.max(dp[i],overall_max);
        }

        return overall_max;
    }

    public int LIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int maxAns=1;
        for (int i=0; i<dp.length; i++){
            for (int j=0; j<i; j++){
                if (nums[i]>nums[j]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
            maxAns = Math.max(maxAns,dp[i]);
        }
        return maxAns;

    }

//    public List<Integer> largestDivisibleSubset(int[] nums) {
//        int n=nums.length;
//        Arrays.sort(nums);
//
//        for (int i=0; i<n; i++){
//            int max=0;
//            for (int j=0; j<i; j++){
//                if (nums[i]%nums[j]==0){
//
//                }
//            }
//        }
//
//
//
//
//    }



    //354. Russian Doll Envelopes
    public int maxEnvelopes(int[][] envelopes) {

        //sort based on second value if its equal or second value
        Arrays.sort(envelopes,(a,b) ->a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);

        int[] dp = new int[envelopes.length];
        Arrays.fill(dp,1);

        int result=1;
        for (int i=1; i<envelopes.length; i++){
            for (int j=0; j<i; j++){
                if (envelopes[i][0]>envelopes[j][0] && envelopes[i][1]>envelopes[j][1]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
                result = Math.max(result,dp[i]);
            }
        }
        return result;
    }

    //646. Maximum Length of Pair Chain
    public int findLongestChain(int[][] envelopes) {
        //sort based on second value if its equal or second value
        Arrays.sort(envelopes,(a,b) ->a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);

        int n = envelopes.length;

        int[] dp = new int[n];
        Arrays.fill(dp,1);

        for (int i=1; i<envelopes.length; i++){
            for (int j=0; j<i; j++){

                //
                if (envelopes[j][1] < envelopes[i][0]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }

            }
        }
        return dp[n-1];
    }
}
