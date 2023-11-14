package DailyPractice.dynamicProg;

public class UnboundedKnap {
    public static void main(String[] args) {
        //rod cutting
        //coin changing
        //coin changing 2
        //maximum ribbon cutting
    }

    public int unbounded(int[] wt, int[] value, int weight){
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
                    dp[i][j] = Math.max(value[i-1]+dp[i][j-wt[i-1]],dp[i-1][j]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][weight];
    }

    //rod cutting
    //length array[] -> wt[]
    //price[] -> value[]
    //length -> weight
    public int rodCutting(int[] prices){
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

    //coin change 2
    //int[] coins -> wt[]
    //int amount -> weight
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp = new int[n+1][amount+1];
        for (int i=0; i<n+1;i++){
            for (int j=0; j<amount+1; j++){
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
            for (int j=1; j<amount+1; j++){
                if (coins[i-1]<=j){
                    dp[i][j]= dp[i][j-coins[i-1]] + dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }

    //coin change
    public int coinChange2(int[] coins, int amount) {
        if(amount<1){
            return 0;
        }
        int[] minCoinsDp = new int[amount+1];

        for (int i=1; i<=amount; i++){
            minCoinsDp[i] = Integer.MAX_VALUE;
            for (int coin : coins){
                if (coin<=i && minCoinsDp[i-coin] !=Integer.MAX_VALUE){
                    minCoinsDp[i] = Math.min(minCoinsDp[i], 1+minCoinsDp[i-coin]);
                }
            }
        }
        if (minCoinsDp[amount] == Integer.MAX_VALUE){
            return -1;
        }
        return minCoinsDp[amount];
    }


}
