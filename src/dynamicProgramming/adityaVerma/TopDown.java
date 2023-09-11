package dynamicProgramming.adityaVerma;

public class TopDown {


    //base condition ->initialization
    //recursive call ->iterative



    public int knapsackTopDown(int[] values, int[] weight,int w){

        int n = values.length;
        int dp[][]= new int[n+1][w+1];

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
                    dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }}

        return dp[n][w];
    }

}
