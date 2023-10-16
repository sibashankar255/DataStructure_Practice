package dynamicProgramming.Scaler;
import java.util.ArrayList;
import java.util.Arrays;

public class Knapsack {
    //0-1 Knapsack
    public int knapsackSolve(int[] A, int[] B, int C) {
        int n=A.length;
        int dp[][]= new int[n+1][C+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);

        return knapsack(A,B,C,n,dp);
    }

    public int knapsack(int[] values, int[] weights, int w,int n, int[][] dp) {

        if (n==0 || w==0){
            return 0;
        }

        if (dp[n][w]!=-1){
            return dp[n][w];
        }

        if(weights[n-1]<=w){
            return dp[n][w] =Math.max(values[n-1]+knapsack(values,weights,w-weights[n-1],n-1,dp),
                    knapsack(values,weights,w,n-1,dp));
        }else if(weights[n-1]>w){
            return dp[n][w]=knapsack(values,weights,w,n-1,dp);
        }

        return dp[n][w];
    }

    // Unbounded Knapsack
    public int unbounded(int w, int[] values, int[] weight) {
        int n = values.length;

        int dp[][] = new int[n+1][w+1];

        for (int i=0; i<n+1; i++){
            for (int j=0; j<w+1; j++){
                if (i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<w+1; j++) {
                if (weight[i - 1] <= j) {
                    dp[i][j] = Math.max(values[i - 1] + dp[i][j - weight[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][w];
    }

    //Fractional Knapsack



    //0-1-KNAPSACK-II
    public int knapsack2(ArrayList<Integer> values, ArrayList<Integer> weights, int capacity) {
        int n = values.size();
        int[] dp = new int[capacity + 1];

        for (int i = 0; i < n; i++) {
            for (int w = capacity; w >= weights.get(i); w--) {
                dp[w] = Math.max(dp[w], dp[w - weights.get(i)] + values.get(i));
            }
        }

        return dp[capacity];
    }


    //Cutting a Rod
    public static int rodCutting(int[] prices){
        int n= prices.length;

        int length[] =new int[n];
        for (int i=0; i<n; i++){
            length[i]=i+1;
        }

        int dp[][] = new int[n+1][n+1];

        for (int i=0; i<n+1; i++){
            for (int j=0; j<n+1; j++){
                if (i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++) {
                if (length[i-1] <= j) {
                    dp[i][j] = Math.max(prices[i - 1] + dp[i][j - length[i-1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][n];

    }


    //518. Coin Change II
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];

        for (int i=0; i<n+1; i++){
            for (int j=0; j<amount+1; j++){
                if (i==0){
                    dp[i][j]=0;
                }
                if (j==0){
                    dp[i][j]=1;
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<amount+1; j++) {
                if (coins[i-1]<=j){
                    dp[i][j]=dp[i][j-coins[i-1]] + dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][amount];
    }


    //322. Coin Change
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];

        for (int i=0; i<n+1; i++){
            for (int j=0; j<amount+1; j++){
                if (i==0){
                    dp[i][j]=Integer.MAX_VALUE-1;
                }
                if (j==0){
                    dp[i][j]=0;
                }
            }
        }

        for (int i=1, j=0; j<amount+1; j++){
            if (j%coins[0] ==0){
                dp[i][j]=j/coins[0];
            }else {
                dp[i][j] = Integer.MAX_VALUE-1;
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<amount+1; j++) {
                if (coins[i-1]<=j){
                    dp[i][j]=Math.min(dp[i][j-coins[i-1]]+1 , dp[i-1][j]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][amount];
    }
}
