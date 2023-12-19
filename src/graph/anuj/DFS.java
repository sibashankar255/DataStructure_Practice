package graph.anuj;

import java.util.*;

public class DFS {

    public ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[v];
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i=0; i<v; i++){
            if (!visited[i]){
                dfs(i, adj, visited, ans);
            }
        }
        //dfs(0, adj, visited, ans);
        return ans;
    }

    private void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> ans) {
        visited[v] =true;
        ans.add(v);

        for (Integer neighbour : adj.get(v)){
            if (!visited[neighbour]){
                dfs(neighbour, adj, visited, ans);
            }
        }
    }


    //detect cycle in undirected graph
    public boolean isCycleUndirected(int v,ArrayList<ArrayList<Integer>> adj ){
        boolean visited[] = new boolean[v];
        for (int i=0; i<v; i++){
            if (!visited[i]){
                if (dfsCycleUndirected(i,adj,visited,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfsCycleUndirected(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent) {
        visited[v]=true;

        for (Integer neighbor : adj.get(v)){
            if (!visited[neighbor]){
                if (dfsCycleUndirected(neighbor,adj,visited,v)){
                    return true;
                }
            }else if(parent !=neighbor){
                return true;
            }
        }
        return false;
    }


    //detect cycle in directed graph
    public boolean isCycleDirected(int v,ArrayList<ArrayList<Integer>> adj ){
        boolean visited[] = new boolean[v];
        boolean recs[] = new boolean[v];
        for (int i=0; i<v; i++){
            if (!visited[i]){
                if (dfsCycleDirected(i,adj,visited,recs)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean dfsCycleDirected(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] recs) {
        visited[v]=true;
        recs[v] =true;

        for (Integer neighbor : adj.get(v)){
            if (!visited[neighbor]){
                if (dfsCycleDirected(neighbor,adj,visited,recs)){
                    return true;
                }
            }else if(recs[neighbor]){
                return true;
            }
        }
        recs[v]=false;
        return false;
    }

    //topological Sort
    public int[] topSort(int v, ArrayList<ArrayList<Integer>> adj){
        boolean visited[] = new boolean[v];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<v; i++){
            if (!visited[i]){
                dfsTop(adj,i, stack,visited);
            }
        }

        int ans[] = new int[v];
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i=0;
        while (!stack.isEmpty()){
            ans[i++]=stack.pop();


        }
        return ans;
    }

    private static void dfsTop(ArrayList<ArrayList<Integer>> adj, int v, Stack<Integer> stack, boolean[] visited) {
        visited[v]=true;

        for (int neighbour : adj.get(v)){
            if (!visited[neighbour]){
                dfsTop(adj,neighbour,stack,visited);
            }
        }
        stack.push(v);
    }

    //130. Surrounded Regions
    /**
     *
     * traverse around the border area and check if any cell is having '0'
     * if any cell found with '0' then check the four direction of that cell and
     * make it to '#'.
     * again traverse the whole board and check any '0' found then make it to '*'
     * and '#' to '0' again.
     *
     */
    public void surroundedRegion(char[][] board) {
        if (board.length==0){ return;}
        for (int i=0; i<board[0].length; i++){
            if (board[0][i]=='O'){ //checking the first row
                dfsSurrounded(board,0,i);
            }
            if (board[board.length-1][i]=='O'){ // checking the last row
                dfsSurrounded(board,board.length-1,i);
            }
        }
        for (int i=0; i<board.length; i++){
            if (board[i][0]=='O'){ //checking the first col
                dfsSurrounded(board,i,0);
            }
            if (board[i][board[0].length-1]=='O'){ // checking the last col
                dfsSurrounded(board,i,board[0].length-1);
            }
        }
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (board[i][j]=='#'){ // if # found then make it to 0
                    board[i][j]='O';
                }else if(board[i][j]=='O'){ // if 0 found make it to x
                    board[i][j]='X';
                }
            }
        }
        return;
    }

    private static void dfsSurrounded(char[][] board, int i, int j) {
        if (i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] !='O'){
            //if the row or col value less than 0 or greater than col then return
            //if the cell value not equal to 0 then also return
            return;
        }
        //else make the cell value to #
        //then check every direction i+1, i-1, j+1, j-1
        board[i][j]='#';
        dfsSurrounded(board,i+1,j);
        dfsSurrounded(board,i-1,j);
        dfsSurrounded(board,i,j+1);
        dfsSurrounded(board,i,j-1);
    }

    //1020. Number of Enclaves
    /**
     *
     *traverse around the border area of the board.
     * check any cell is having 1.
     * if found 1 then check the 4 direction of that 1 and make it to 9
     *
     * Then traverse the board and count the cells having 1
     */
    public int numEnclaves(int[][] board) {
        if (board.length==0){ return 0;}

        for (int i=0; i<board[0].length; i++){
            if (board[0][i]==1){
                dfsSurrounded(board,0,i);
            }
            if (board[board.length-1][i]==1){
                dfsSurrounded(board,board.length-1,i);
            }
        }

        for (int i=0; i<board.length; i++){
            if (board[i][0]==1){
                dfsSurrounded(board,i,0);
            }
            if (board[i][board[0].length-1]==1){
                dfsSurrounded(board,i,board[0].length-1);
            }
        }

        int count=0;
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if(board[i][j]==1){
                    count++;
                }
            }
        }

        return count;

    }
    private static void dfsSurrounded(int[][] board, int i, int j) {
        if (i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] !=1){
            return;
        }
        board[i][j]=9;

        dfsSurrounded(board,i+1,j);
        dfsSurrounded(board,i-1,j);
        dfsSurrounded(board,i,j+1);
        dfsSurrounded(board,i,j-1);
    }

    //1376. Time Needed to Inform All Employees
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, Integer> times = new HashMap<>();
        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, dfs(i, manager, informTime, times));
        }

        return max;
    }
    private int dfs(int e_id, int[] manager, int[] informTime, Map<Integer, Integer> times) {
        if(manager[e_id] == -1) return 0;

        if(times.containsKey(e_id)) return times.get(e_id);

        times.put(e_id, informTime[manager[e_id]] + dfs(manager[e_id], manager, informTime, times));

        return times.get(e_id);
    }


    //200. Number of Islands
    /**
     * traverse the grid and find the 1's
     * if 1 found, increase the count of number of island
     * then check the four directions of the 1 and
     * make the cells from 1 to 0
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int numIslands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    private void dfs(char[][] visited,int i, int j) {

        int m = visited.length;
        int n = visited[0].length;

        // Check for invalid indices and for sites that aren't land
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] != '1') return;

        // Mark the site as visited
        visited[i][j] = '0';

        // Check all adjacent sites
        dfs(visited,i + 1, j);
        dfs(visited,i - 1, j);
        dfs(visited,i, j + 1);
        dfs(visited,i, j - 1);
    }

    //1254. Number of Closed Islands
    public int closedIsland(int[][] grid) {
        int m = grid.length; //row
        int n=grid[0].length; //col
        int count=0; // to count number of island
        boolean[][] visited = new boolean[m][n]; // to keep track of the visited cell

        //loop through all cells and skipping the boarder cell
        for (int i=1; i<m-1; i++){
            for (int j=1; j<n-1; j++){
                if (grid[i][j]==0 && !visited[i][j]){ // if this is a unvisited land cell
                    boolean isClosed = dfs(grid,visited,i,j); // check if it is closed island
                    if (isClosed){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean dfs(int[][] grid, boolean[][] visited, int i, int j) {
        int m= grid.length;
        int n=grid[0].length;
        if (i<0 || j<0 || i>=m || j>=n){ //if out of bound not closed island
            return false;
        }

        if (visited[i][j]){// if already visited not a closed island
            return true;
        }

        visited[i][j]=true; // mark as visited

        if (grid[i][j]==1){ //if water , not a closed island
            return true;
        }

        boolean isClosed = true; //flag to check all the adjacent cells are water
        isClosed &= dfs(grid,visited,i-1,j); //check the cell to left
        isClosed &= dfs(grid,visited,i+1,j); //right
        isClosed &= dfs(grid,visited,i,j-1); //above
        isClosed &= dfs(grid,visited,i,j+1); //below
        return isClosed;
    }

    //841. Keys and Rooms
    /**
     * input -> array of list
     * create a queue and a boolean visited array
     * add all elements of 0th array elements into the queue and make all of them as visited
     * while queue is not empty traverse
     * remove the elements(ith) from the queue and
     * go to the ith array elements and add them into the queue and mark them visited
     *
     * then traverse the visited[] array and check any element has false value
     * it means some room has left not visited then return false
     */
    public boolean canVisitAllRooms(ArrayList<ArrayList<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[rooms.size()];

        visited[0] =true;
        for (int i : rooms.get(0)){
            queue.add(i);
            visited[i]=true;
        }

        while (!queue.isEmpty()){
            int temp =queue.poll();
            for (int i: rooms.get(temp)){
                if (visited[i]==false){
                    queue.add(i);
                    visited[i]=true;
                }
            }
        }

        for (int i=1; i<visited.length; i++){
            if (visited[i]==false){
                return false;
            }
        }

        return true;
    }


    //695. Max Area of Island
    /**
     * traverse the grid and check the if cell is having value 1
     * if 1 is found then check other 1's adjacent to the 1
     *
     * make the visited grid cells as -1
     * using DFS check the left, right, up, down 1's
     * return the total area = 1(itself) + left+right+up+down
     *
     * calculate the max area found
     *
     */
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea=0;

        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (grid[i][j]==1){
                    maxArea = Math.max(maxArea,getCurrentArea(grid,i,j));
                }
            }
        }
        return maxArea;
    }

    private int getCurrentArea(int[][] grid, int i, int j) {
        if (i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]<=0){
            return 0;
        }
        grid[i][j]=-1;

        int leftArea = getCurrentArea(grid,i,j-1);
        int rightArea = getCurrentArea(grid,i,j+1);
        int upArea = getCurrentArea(grid,i-1,j);
        int downArea =getCurrentArea(grid,i+1,j);

        int totalArea =1+leftArea+rightArea+upArea+downArea;

        return totalArea;
    }

    //733. Flood Fill
    /**
     * target = image[sr][sc] (this cell is being targeted )
     * need to change the targeted cell's color as per the given color
     * and the adjacent cells
     *
     * do a dfs on the targeted cell and check every direction if the corresponding cell is same as targeted
     * then change the cell value to given color
     */

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int target = image[sr][sc];
        if(target == color){
            return image;
        }
        dfs(sr,sc,target,color,image);
        return image;
    }
    private static void dfs(int i, int j, int target, int color, int[][] image) {
        if (i>=0 && j>=0 && i<image.length && j<image[0].length && image[i][j]==target){
            image[i][j] = color;
            dfs(i-1,j,target,color,image);
            dfs(i+1,j,target,color,image);
            dfs(i,j-1,target,color,image);
            dfs(i,j+1,target,color,image);
        }
    }


    //
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int n = grid.length;
        int m = grid[0].length;
        int target = grid[row][col];

        if (target == color)
            return grid;

        boolean[][] visited = new boolean[n][m];
        dfs(grid, row, col, target, visited, color);

        return grid;
    }

    private void dfs(int[][] grid, int i, int j, int target, boolean[][] visited, int color) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != target || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        boolean border = false;

        if (i == 0 || j == 0 || j == grid[0].length - 1 || i == grid.length - 1 ||
                grid[i + 1][j] != target || grid[i - 1][j] != target || grid[i][j - 1] != target || grid[i][j + 1] != target)
            border = true;

        dfs(grid, i + 1, j, target, visited, color);
        dfs(grid, i - 1, j, target, visited, color);
        dfs(grid, i, j + 1, target, visited, color);
        dfs(grid, i, j - 1, target, visited, color);

        if (border) {
            grid[i][j] = color;
        }
    }


    //word search-i
    public boolean exist(char[][] board, String word) {
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (board[i][j]==word.charAt(0) && dfsWordSearch(board,i,j,0,word)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsWordSearch(char[][] board, int i, int j, int count, String word) {
        if (count == word.length()){
            return true;
        }
        if (i==-1 || i==board.length || j==-1 || j==board[0].length || board[i][j] != word.charAt(count)){
            return false;
        }
        char temp =board[i][j];
        board[i][j]='*';
        boolean found = dfsWordSearch(board,i+1,j,count+1,word) ||
                        dfsWordSearch(board,i-1,j,count+1,word) ||
                        dfsWordSearch(board,i,j+1,count+1,word) ||
                        dfsWordSearch(board,i,j-1,count+1,word) ;
        board[i][j]=temp;
        return found;
    }

}
