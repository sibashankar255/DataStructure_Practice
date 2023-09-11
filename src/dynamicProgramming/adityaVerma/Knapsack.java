package dynamicProgramming.adityaVerma;

import java.util.Arrays;

public class Knapsack {

    //subset sum
    //equal sum partition
    //count of subset sum
    //minimum subset sum
    //target sum
    //number of subset with given difference


    //optimal -> max, min, greatest
    //choice

    //weight ->1 3 4 5
    //value -> 1 4 5 7

    //DP -> recursion -> memoization -> top down

    //solution:-
    //base condition
    //choice diagram

    //base condition:-
    //think of the smallest valid input



    //weight ->1 3 4 5
    //value -> 1 4 5 7
    //W -> 7
    //o/p -> maximum profit
    //

    public int solve(int[] A, int[] B, int C) {
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



    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //memoization
    //int t[n+1][w+1]
    //insert(t,-1, size(t))
    // which ever is changing take the dp[][] of those values
    public static void main(String[] args) {

    }








}
