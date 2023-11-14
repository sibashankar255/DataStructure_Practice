package dynamicProgramming.adityaVerma;

public class UnboundedKnap {

    public static void main(String[] args) {
        int[] A = {3, 4, 1, 6, 2};

        System.out.println(rodCutting(A));
    }

    //rod cutting
    //coin changing
    //coin changing 2
    //maximum ribbon cutting

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
