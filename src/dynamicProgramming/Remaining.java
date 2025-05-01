package dynamicProgramming;

import java.util.HashMap;

public class Remaining {

    //174. Dungeon Game
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon==null || dungeon.length==0 || dungeon[0].length==0){
            return 0;
        }
        HashMap<String ,Integer> hashMap = new HashMap<>();
        return calculateMinimumHP(0,0,dungeon,hashMap);
    }
    private static int calculateMinimumHP(int i, int j, int[][] dungeon, HashMap<String ,Integer> hashMap){
        if (i>=dungeon.length || j>=dungeon[0].length){
            return Integer.MAX_VALUE;
        }

        String key =i+"hash"+j;
        if (hashMap.containsKey(key)){
            return hashMap.get(key);
        }

        int next =    Math.min(calculateMinimumHP(i+1,j,dungeon,hashMap),
                calculateMinimumHP(i,j+1,dungeon,hashMap));

        if (next==Integer.MAX_VALUE){
            next= 1;
        }

        int result = Math.max(next-dungeon[i][j],1);
        hashMap.put(key,result);

        return result;
    }

    //221. Maximal Square
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int dp[][] = new int[matrix.length][matrix[0].length];

        int h = matrix.length;
        int l = matrix[0].length;
        int max = 0;

        int curMax = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                curMax = findSquare(matrix, i, j, dp);
                if (max < curMax) {
                    max = curMax;
                }
            }
        }
        return max * max;
    }
    private int findSquare(char[][] matrix, int i, int j, int[][] dp) {
        if (i >= matrix.length || j >= matrix[0].length || matrix[i][j] == '0') {
            return 0;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int sum = 1 + Math.min(findSquare(matrix, i + 1, j + 1, dp), Math.min(findSquare(matrix, i + 1, j, dp), findSquare(matrix, i, j + 1, dp)));
        return dp[i][j] = sum;
    }

}
