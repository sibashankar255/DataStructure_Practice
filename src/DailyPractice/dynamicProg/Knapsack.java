package DailyPractice.dynamicProg;

import java.util.ArrayList;
import java.util.Arrays;

public class Knapsack {
    public static void main(String[] args) {
        /*
     //subset sum
    //equal sum partition
    //count of subset sum b
    //minimum subset sum
    //number of subset with given difference
    //target sum

         */

    }

    //0-1 knapsack recursive code
    //input :-
    //weight[]= {1,3,4,5};
    //value[] = {1,4,5,7};
    //weight=7
    //maximum profit

    //base condition:- think of the smallest valid input
    //wt[]
    //value[]
    //weight:- 10
    //smallest valid input is 0
    //if capacity and n is zero then profit 0

    /* base condition
    if(n==0 || w==0){
       return 0;
    }
     */
    /*choice diagram

    //if the last element included
    if(wt[n-1] <= weight){
    value[n-1]+knapsack(wt,value,weight-wt[n-1], n-1)
    }
    //if its not included
    knapsack(wt,value,weight,n-1)


    //if its bigger than the weight
    if(wt[n-1]>weight){
    return knapsack(wt,value,weight,n-1);
    }
     */

    /*

    w--> wt[n-1] > w -> its not included
     --> wt[n-1] <= w -> its include
                      -> its not included
     */

    /*
    public int knapsack(int[] wt, int[] value, int weight, int n){
        if(n==0 || weight==0){
            return 0;
        }
        if (wt[n-1] <=weight){
            return Math.max(value[n-1]+knapsack(wt,value,weight-wt[n-1], n-1),
                    knapsack(wt,value,weight,n-1));
        }else if (wt[n-1]> weight){
            return knapsack(wt,value,weight,n-1);
        }
    }

     */


    //////////////////////////////////////////////////////////////////////////////////////////////////////
    //knapsack using memoization
    //dp[n+1][weight+1]
    //initialize with -1

    public int knapsackMemo(int[] wt, int[] value, int weight) {
        int n=wt.length;
        int dp[][]= new int[n+1][weight+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);

        return knapsack(wt,value,weight,n,dp);
    }

    public int knapsack(int[] wt, int[] value, int weight, int n, int[][] dp){
        if(n==0 || weight==0){
            return 0;
        }
        if (dp[n][weight] !=-1){
            return dp[n][weight];
        }
        if (wt[n-1] <=weight){
            return dp[n][weight]=Math.max(value[n-1]+knapsack(wt,value,weight-wt[n-1], n-1,dp),
                    knapsack(wt,value,weight,n-1,dp));
        }else if (wt[n-1]> weight){
            return dp[n][weight]=knapsack(wt,value,weight,n-1,dp);
        }
        return dp[n][weight];
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    //topdown approach
    //int[][] dp = new int[n+1][weight+1]
    //initialize the 0th row and column with 0
    //iterate call

    public int knapsackTopDown(int[] wt, int[] value, int weight){
        int n = wt.length;
        int[][] dp = new int[n+1][weight+1];

        for (int i=0; i<n+1; i++){
            for (int j=0; j<weight+1; j++){
                if (i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        //n -> i
        //weight -> j
        for (int i=1; i<n+1; i ++){
            for (int j=1; j<weight+1; j++){
                if (wt[i-1]<=j){
                    dp[i][j] = Math.max(value[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][weight];
    }

    //subset sum
    //arr[]= {2,3,7,8,10}
    //sum=11
    public static boolean subsetSum(int[] arr, int sum){
        int n=arr.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        for (int i=0; i<n+1;i++){
            for (int j=0; j<sum+1; j++){
                if (i==0){
                    dp[i][j]=false;
                }
                if(j==0){
                    dp[i][j]=true;
                }
            }
        }
        //i->n
        //j->sum
        for (int i=1; i<n+1; i++){
            for (int j=1; j<sum+1; j++){
                if (arr[i-1]<=j){
                    dp[i][j]= dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    //equal sum partition
    public boolean canPartition(int[] nums) {
        int sum=0;

        for (int  i=0; i<nums.length; i++){
            sum+=nums[i];
        }
        if (sum%2!=0){
            return false;
        }else {
            return subsetSum(nums,sum/2);
        }
    }

    //count of subset sum
    //int[] nums = {2,3,5,6,8,10};
    //target=10;
    public static int countSubsetSum(int[] arr, int sum) {
        int n=arr.length;
        int[][] dp = new int[n+1][sum+1];
        for (int i=0; i<n+1;i++){
            for (int j=0; j<sum+1; j++){
                if (i==0){
                    dp[i][j]=0;
                }
                if(j==0){
                    dp[i][j]=1;
                }
            }
        }
        //i->n
        //j->sum
        for (int i=1; i<n+1; i++){
            for (int j=1; j<sum+1; j++){
                if (arr[i-1]<=j){
                    dp[i][j]= dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    //minimum subset sum difference
    //Array ={1,6,11,5};
    //2 subsets
    //s1-s2 = minimize
    //range-2*s1 = minimize
    //

    public static int subsetSumD(int[] nums){
        int sum=0;
        for (int i=0; i<nums.length; i++){
            sum+=nums[i];

        }
        ArrayList<Integer> arrayList = subsetSumDiff(nums,sum);
        int min=Integer.MAX_VALUE;
        for (int i=0; i<arrayList.size(); i++){
            min = Math.min(min, sum-2*arrayList.get(i));
        }
        return min;
    }
    public static ArrayList<Integer> subsetSumDiff(int arr[], int sum){
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];

        for (int i=0; i<n+1; i++){
            for (int j=0; j<sum+1; j++){
                if (i==0){
                    dp[i][j]=false;
                }
                if (j==0){
                    dp[i][j]=true;
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++) {
                if (arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i=0; i<n+1; i++){
            for (int j=0; j<(sum+1)/2; j++){
                if (i==n+1 && dp[i][j]==true){
                    arrayList.add(j);
                }
            }
        }
        return arrayList;
    }

    //number of subset with given difference
    /*
    Let sum of subset 1 be s1 and subset 2 with s2
s1 - s2 = diff (given)
s1 + s2=sum of array (logical)
Therefore adding both eq we get :
2s1= diff + sum of array
s1= (diff + sum of array)/2;
Problem reduces to find no of subsets with given sum**
     */
    public static int countSubsetWithDiff(int n, int diff, int[] arr) {

        int sumOfArr =0;
        for (int i=0; i<arr.length; i++){
            sumOfArr+=arr[i];
        }
        int sum = (diff+sumOfArr)/2;

        return countSubsetSum(arr,sum);

    }

    //target sum
    public int findTargetSumWays(int[] nums, int target) {
        int sumOfArr =0;
        for (int i=0; i<nums.length; i++){
            sumOfArr+=nums[i];
        }
        if(sumOfArr<target || (sumOfArr-target)%2==1){
            return 0;
        }
        int sum = (target+sumOfArr)/2;

        int count = 0;
         for(int x : nums)
             if(x == 0)
                 count++;

        return (int)(Math.pow(2,count)) *countSubsetSum(nums,sum);
    }

    public int findTargetSumWaysOther(int[] nums, int target) {

        int sum = 0;
        for(int x : nums)
            sum += x;
        if(((sum - target) % 2 == 1) || (target > sum))
            return 0;

        int n = nums.length;
        int s2 = (sum - target)/2;
        int[][] t = new int[n + 1][s2 + 1];
        t[0][0] = 1;

        for(int i = 1; i < n + 1; i++) {
            for(int j = 0; j < s2 + 1; j++) {
                if(nums[i - 1] <= j)
                    t[i][j] = t[i-1][j] + t[i - 1][j - nums[i - 1]];
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][s2];
    }

















}