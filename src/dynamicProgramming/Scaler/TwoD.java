package dynamicProgramming.Scaler;
import java.util.ArrayList;
import java.util.Arrays;
public class TwoD {

    //Unique Paths
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i=0; i<m; i++){
            dp[i][0]=1;
        }
        for (int i=0; i<n; i++){
            dp[0][i]=1;
        }

        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    //Unique Paths II
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

        if (obstacleGrid[0][0]==1){
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i=0; i<m; i++){
            if (obstacleGrid[i][0]==0){
                dp[i][0]=1;
            }else {
                break;
            }
        }
        for (int i=0; i<n; i++){
            if (obstacleGrid[0][i]==0){
                dp[0][i]=1;
            }else {
                break;
            }
        }

        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                if (obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    //N digit numbers
    final int mod = 1000000007;
    public int digit(int A, int B) {
        int[][] dp = new int[A+1][B+1];
        int i;
        for(i=0;i<=A;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        dp[1][0] = 0;
        for(i=1;i<=Math.min(9,B);i++)
        {
            dp[1][i] = 1;
        }
        for(i=10;i<=B;i++)
        {
            dp[1][i] = 0;
        }
        return countDigit(A,B,dp)%mod;
    }
    int countDigit(int A,int B,int[][] dp)
    {
        if(dp[A][B] != -1)
            return dp[A][B];

        int ans = 0;

        for(int i=0;i<=9;i++)
        {
            if(i<B)
                ans =(ans + countDigit(A-1,B-i,dp)%mod)%mod;
        }
        dp[A][B] = ans;
        return dp[A][B];
    }


    //Min Sum Path in Triangle
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int height =triangle.size();

        int[][] dp = new int[height+1][height+1];

        for (int level=height-1; level>=0;level--){
            for (int i=0; i<=level;i++){
                dp[level][i] =triangle.get(level).get(i)+
                        Math.min(dp[level+1][i], dp[level+1][i+1]);
            }
        }
        return dp[0][0];
    }

    //Dungeon Princess
//    final int mod = 1000000007;
    public int princes(int A, int B) {
        int[][] dp = new int[A+1][B+1];
        int i;
        for(i=0;i<=A;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        dp[1][0] = 0;
        for(i=1;i<=Math.min(9,B);i++)
        {
            dp[1][i] = 1;
        }
        for(i=10;i<=B;i++)
        {
            dp[1][i] = 0;
        }
        return countPrince(A,B,dp)%mod;
    }
    int countPrince(int A,int B,int[][] dp)
    {
        if(dp[A][B] != -1)
            return dp[A][B];

        int ans = 0;

        for(int i=0;i<=9;i++)
        {
            if(i<B)
                ans =(ans + countPrince(A-1,B-i,dp)%mod)%mod;
        }
        dp[A][B] = ans;
        return dp[A][B];
    }

    // Min Sum Path in Matrix
    public int minPathSum(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        if (row==0){
            return 0;
        }
        int[][] dp = new int[row][col];

        dp[0][0]=grid[0][0];

        //first col
        for (int i=1; i<row; i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }

        //first row
        for (int i=1; i<col; i++){
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }

        for (int i=1; i<row; i++){
            for (int j=1; j<col; j++){
                dp[i][j] = grid[i][j]+ Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[row-1][col-1];
    }

    // Max Rectangle in Binary Matrix



}
