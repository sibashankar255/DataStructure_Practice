package dynamicProgramming;

import java.util.List;

public class Overview {

    //fibonacci series
//    static int n;
//    static int[] dp = new int[n+1];
//    Arrays.fill(dp,-1);
    public static int findFibonacci(int[] dp,int n){
        if(n<=1){
            return n;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = findFibonacci(dp,n-1)+findFibonacci(dp,n-2);
        return dp[n];
    }

    //climbing stairs
    public int climbStairs(int A) {
        if(A==1){
            return 1;
        }
        int[] dp = new int[A+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3; i<=A; i++){
            dp[i]=(dp[i-1]+dp[i-2]) % 1000000007;
        }
        return dp[A];
    }

    //frog jump


    //House Robber
    public int houseRob1(int[] nums) {
        if (nums.length<2){
            return nums[0];
        }
        int[] dp = new int[nums.length];

        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        for (int i=2; i<nums.length; i++){
            dp[i]=Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }

    //House Robber II
    public int houseRob2(int[] nums) {
        int n=nums.length;
        if (n<2){
            return nums[0];
        }
        int[] skipLastHouse = new int[n-1];
        int[] skipFirstHouse = new int[n-1];

        for (int i=0; i<n-1; i++){
            skipLastHouse[i]=nums[i];
            skipFirstHouse[i]=nums[i+1];
        }

        int lootSkippingLast = houseRob1(skipLastHouse);
        int lootSkippingFirst = houseRob1(skipFirstHouse);

        return Math.max(lootSkippingLast,lootSkippingFirst);
    }


    //House Robber 3
    public int houseRob3(TreeNode root) {
        int[] options = travel(root);
        return Math.max(options[0],options[1]);
    }
    public static int[] travel(TreeNode root){
        if (root==null){
            return new int[2];
        }
        int[] left_node_choices = travel(root.left);
        int[] right_node_choices =travel(root.right);

        int[] options = new int[2];

        options[0] = root.val+ left_node_choices[1]+right_node_choices[1];
        options[1] = Math.max(left_node_choices[0],left_node_choices[1])+
                Math.max(right_node_choices[0],right_node_choices[1]);

        return options;
    }

    // Unique Paths
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

    // Unique Paths II
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

    //Minimum Path Sum
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


    //Triangle
    public int minimumTotal(List<List<Integer>> triangle) {
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


    //Minimum Falling Path Sum
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int dp[][] = new int[n][n];

        dp[0]=matrix[0].clone();

        for (int i=1; i<n; i++){
            for (int j=0;j<n; j++){
                if(j==0){
                    dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j+1])+matrix[i][j];
                }else if(j==n-1){
                    dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-1])+matrix[i][j];
                }else {
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i-1][j+1]))+matrix[i][j];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i=0; i<n; i++){
            min=Math.min(dp[n-1][i],min);
        }
        return min;
    }



}
