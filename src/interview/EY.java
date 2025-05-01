package interview;

import java.util.*;

public class EY {
    public static void main(String[] args) {

        int[][] events = {{1, 3, 3}, {3, 4, 4}, {4, 6, 6}, {1, 7, 9}};
        int k = 3;
        int result = maxValue(events, k);
        System.out.println(result); // Output: 7
    }


    //https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/solutions/1052727/solution-using-dynamic-programming-time-o-n-k-logn-space-o-nk/
    public static int maxValue(int[][] events, int k) {
        Arrays.sort(events, (e1, e2) -> (e1[0] == e2[0] ? e1[1]-e2[1] : e1[0]-e2[0]));
        return maxValue(events, 0, k, 0, new int[k+1][events.length]);
    }
    private static int maxValue(int[][] events, int index, int remainingEvents, int lastEventEndDay, int[][] dp) {
        // Return 0 if no events are left or maximum choice is reached
        if (index >= events.length || remainingEvents == 0)
            return 0;

        // An Event cannot be picked if the previous event has not completed before current event
        if (lastEventEndDay >= events[index][0])
            return maxValue(events, index+1, remainingEvents, lastEventEndDay, dp);

        // Return the value if the solution is already available
        if (dp[remainingEvents][index] != 0)
            return dp[remainingEvents][index];

        // There are 2 choices that we can make,
        // SKIP this meeting or PICK this meeting
        return dp[remainingEvents][index] = Math.max(
                maxValue(events, index+1, remainingEvents, lastEventEndDay, dp), // skip
                maxValue(events, index+1, remainingEvents-1, events[index][1], dp) + events[index][2] // pick
        );
    }

    public int minSubArrayLen(int target, int[] nums) {
        int result=Integer.MAX_VALUE;
        int value_sum=0;
        int left=0;

        for (int i=0; i<nums.length; i++){
            value_sum +=nums[i];

            while (value_sum >=target){
                result = Math.min(result, i-left+1);
                value_sum -= nums[left];
                left++;
            }
        }
        return result !=Integer.MAX_VALUE ? result :0;
    }

    int path[][];
    int mod=(int)Math.pow(10,9)+7;
    public int countPaths(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int ans=0;
        path=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                ans=(ans%mod+ dfs(grid,i,j,m,n,-1)%mod)%mod;

            }
        }
        return ans;
    }

    public int dfs(int[][] grid,int x,int y,int m,int n,int pre){
        if(x<0 || y<0 || x>=n || y>=m)return 0;
        if(grid[x][y]<=pre)return 0;
        if(path[x][y]!=0)return path[x][y];

        int l1=dfs(grid,x+1,y,m,n,grid[x][y]);
        int l2=dfs(grid,x-1,y,m,n,grid[x][y]);
        int l3=dfs(grid,x,y+1,m,n,grid[x][y]);
        int l4=dfs(grid,x,y-1,m,n,grid[x][y]);

        return  path[x][y]=(1+l1+l2+l3+l4)%mod;
    }



    public int[] asteroidCollision(int[] a) {
        int n = a.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (st.size() == 0 || (st.peek() < 0 && a[i] > 0) || samesign(st.peek(), a[i])) {
                st.push(a[i]);
            } else {
                while (st.size() > 0 && st.peek() > 0 && st.peek() < Math.abs(a[i]))
                    st.pop();

                if (st.size() == 0 || st.peek() < 0) {
                    st.push(a[i]);
                } else if (st.peek() == Math.abs(a[i])) {
                    st.pop();
                }
            }
        }

        int[] ans = new int[st.size()];
        int i = st.size() - 1;
        while (!st.isEmpty()) {
            ans[i] = st.peek();
            i--;
            st.pop();
        }
        return ans;
    }
    public boolean samesign(int x, int y) {
        if (x < 0 && y < 0)
            return true;
        else if (x > 0 && y > 0)
            return true;
        return false;
    }

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

    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i=0;i<row; i++){
            for (int j=0; j<col; j++){
                if (mat[i][j]==0){
                    queue.offer(new int[]{i,j});
                }else {
                    mat[i][j]=-1;
                }
            }
        }

        int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};

        while (!queue.isEmpty()){
            int[] cell = queue.poll();

            for (int dir[]: direction){
                //lets take mat[1][1]
                //cell[0] = 1, cell[1] =1
                //{r,c}={1,1}+{-1,0} = {0,1} = {1,1}'s up
                //{r,c}={1,1}+{1,0} = {2,1} = {1,1}'s down
                //{r,c}={1,1}+{0,-1} ={1,0} = {1,1}'s left
                //{r,c}={1,1}+{0,1} ={1,2} = {1,1}'s right

                int r = cell[0] +dir[0];
                int c = cell[1] +dir[1];

                //if r < 0  (r value cann't be -ve)
                //if r>=row (r value cann't be greater than row)
                //if c<0 (c value cann't be -ve)
                //if c>=col (col value cann't be greater than col)
                //if mat[r][c] !=-1 (if its zero) then continue
                if (r<0 || r>=row || c<0 || c>=col || mat[r][c] !=-1){
                    continue;
                }

                //else add that perticular row,col value to queue
                queue.add(new int[]{r,c});

                //increase the value of matrix cell value +1;
                mat[r][c] = mat[cell[0]][cell[1]] +1;
            }
        }
        return mat;
    }

    public String reorganizeString(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        maxHeap.addAll(freqMap.keySet());

        if (freqMap.get(maxHeap.peek()) > (s.length() + 1) / 2) {
            return "";
        }

        StringBuilder res = new StringBuilder();
        char[] result = new char[s.length()];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            for (int j = 0; j < freqMap.get(c); j++) {
                if (i >= s.length()) i = 1;
                result[i] = c;
                i += 2;
            }
        }

        return new String(result);
    }

    public String longestDiverseString(int a, int b, int c) {
        int a_count = 0;
        int b_count = 0;
        int c_count = 0;

        int total = a + b + c;
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ;i < total; i++) {
            if( (a >= b && a >= c && a_count < 2) || (b_count == 2 && a > 0) || (c_count == 2 && a > 0) ){
                sb.append('a');
                a--;
                a_count++;
                b_count=0;
                c_count=0;
            }
            else if( (b >= a && b >= c && b_count < 2) || (a_count == 2 && b > 0) || (c_count == 2 && b > 0) ){
                sb.append('b');
                b--;
                b_count++;
                a_count=0;
                c_count=0;
            }
            else if( (c >= b && c >= a && c_count<2) || (b_count == 2 && c > 0) || (a_count == 2 && c > 0) ){
                sb.append('c');
                c--;
                c_count++;
                b_count=0;
                a_count=0;
            }
        }
        return sb.toString();
    }
}

