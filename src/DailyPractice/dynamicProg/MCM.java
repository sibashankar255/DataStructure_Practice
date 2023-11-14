package DailyPractice.dynamicProg;
import java.util.*;

public class MCM {
    public static void main(String[] args) {
        /*
        Matrix chain multiplication
        printing MCM
        evaluate expression to true/boolean parenthesization
        min/max value of an expression
        palindrome partitioning
        scramble string
        egg dropping problem
         */

        //find i and j
        //find base condition
        //find k loop
        //calculate the temp min ans
    }


    //recursive code
    public static int mcmRec(int[] arr, int i , int j){
        if (i>=j){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k=i;k<=j-1; k++){
            int tempAns = mcmRec(arr,i,k)+mcmRec(arr,k+1,j) + arr[i-1]*arr[k]*arr[j];

            if (tempAns<min){
                min=tempAns;
            }
        }
        return min;
    }

    public static int mcmMemoGlobal(int arr[]){
        int[][] dp = new int[1001][1001];
        for (int i=1; i<=1001; i++){
            for (int j=1; j<=1001; j++){
                dp[i][j]=-1;
            }
        }
        return mcmMemo(arr,1,arr.length-1,dp);
    }
    public static int mcmMemo(int[] arr, int i, int j, int[][] dp){
        if (i>=j){
            return 0;
        }
        if (dp[i][j] != -1){
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k=i;k<=j-1; k++){
            int tempAns = mcmMemo(arr,i,k,dp)+mcmMemo(arr,k+1,j,dp) + arr[i-1]*arr[k]*arr[j];

            if (tempAns<min){
                min=tempAns;
            }
        }
        return dp[i][j]=min;
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;

        // Extend the input array with 1s at both ends
        int[] newArr = new int[n + 2];
        newArr[0] = 1;
        newArr[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            newArr[i] = nums[i - 1];
        }

        int m = newArr.length;

        int[][] dp = new int[m][m];

        // Initialize dp array with -1 to indicate that values have not been computed yet.
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Call the recursive function to find the maximum coins.
        return matrixChainMultiplication(1, m - 1, newArr, dp);
    }

    private int matrixChainMultiplication(int left, int right, int[] nums, int[][] mem) {
        // If left index is greater than or equal to right, there are no matrices to multiply, return 0.
        if (left >= right)
            return 0;

        // If this subproblem has already been solved, return the previously computed result.
        if (mem[left][right] != -1)
            return mem[left][right];

        int max_cost = Integer.MIN_VALUE;

        for (int k = left; k < right; k++) {
            // Calculate the total cost for multiplying matrices from left to right through index k.
            int total_cost = matrixChainMultiplication(left, k, nums, mem) +
                    matrixChainMultiplication(k + 1, right, nums, mem) +
                    nums[left - 1] * nums[k] * nums[right];

            // Update the maximum cost found so far.
            max_cost = Math.max(max_cost, total_cost);
        }

        // Store the result in the memoization table for future reference.
        mem[left][right] = max_cost;
        return mem[left][right];
    }


}
