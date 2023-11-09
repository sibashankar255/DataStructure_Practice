package dynamicProgramming.adityaVerma;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class KnapsackProblem {

    public static void main(String[] args) {
        int[] arr = {2,3,5,6,8,10};
        System.out.println(countSubsetSum(arr,10));

        System.out.print(9);

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        HashMap<Integer,StringBuilder> stringBuilderHashMap = new HashMap<>();
    }

    //subset sum
    public static boolean subsetSum(int arr[], int sum){
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
    public static int countSubsetSum(int arr[], int sum){
        int n = arr.length;
        int dp[][] = new int[n+1][sum+1];

        for (int i=0; i<n+1; i++){
            for (int j=0; j<sum+1; j++){
                if (i==0){
                    dp[i][j]=0;
                }
                if (j==0){
                    dp[i][j]=1;
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++) {
                if (arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][sum];

    }

    //minimum subset sum
    //2035. Partition Array Into Two Arrays to Minimize Sum Difference
    public int minimumDifference(int[] nums) {
        int sum=0;
        for (int i=0; i<nums.length; i++){
            sum+=nums[i];

        }
        ArrayList<Integer> arrayList = subsetSumdiff(nums,sum);
        int min=Integer.MAX_VALUE;
        for (int i=0; i<arrayList.size(); i++){
            min = Math.min(min, sum-2*arrayList.get(i));
        }
        return min;
    }

    public static ArrayList<Integer> subsetSumdiff(int arr[], int sum){
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

    static int min_diff(int arr[], int n){
        int sum=0;
        for (int i=0; i<arr.length; i++){
            sum+=arr[i];
        }

        boolean dp[][] = new boolean[n+1][sum+1];

        for (int i=0; i<n+1; i++){
            for (int j=0; j<sum+1; j++){
                if (i==0) dp[i][j]=false;
                if (j==0) dp[i][j]=true;
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

        int diff= Integer.MAX_VALUE;

        for (int j=sum/2;j>=0; j--){
            if (dp[n][j]==true){
                diff=Math.min(diff,sum-2*j);
            }
        }
        return diff;

    }



    //target sum
    public int findTargetSumWays(int[] nums, int target) {
        int sumOfArr =0;
        for (int i=0; i<nums.length; i++){
            sumOfArr+=nums[i];
        }
        if(sumOfArr<target){
            return 0;
        }
        int sum = (target+sumOfArr)/2;

        return countSubsetSum(nums,sum);
    }


    //number of subset with given difference
    public static int countPartitions(int n, int diff, int[] arr) {

        int sumOfArr =0;
        for (int i=0; i<arr.length; i++){
            sumOfArr+=arr[i];
        }
        int sum = (diff+sumOfArr)/2;

        return countSubsetSum(arr,sum);

    }

}
