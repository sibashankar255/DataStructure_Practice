package Striver.graph;

import java.util.*;
import java.lang.*;


public class ProblemsDFSBFS {

    //	Number of provinces
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // Found a new province, perform DFS to mark all connected cities
                dfs(isConnected, visited, i);
                provinces++;
            }
        }

        return provinces;
    }

    private static void dfs(int[][] isConnected, boolean[] visited, int city) {
        visited[city] = true;

        for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
            if (isConnected[city][neighbor] == 1 && !visited[neighbor]) {
                dfs(isConnected, visited, neighbor);
            }
        }
    }


    //number of island
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int numIslands = 0;

        char[][] visited=grid;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(visited, i, j);
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



    //Flood Fill
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int target = image[sr][sc];
        if(target == newColor){
            return image;
        }
        dfs(sr,sc,target,newColor,image);
        return image;
    }

    private static void dfs(int row,int col,int target,int newColor,int[][] image) {
        if (row < image.length && row >= 0 && col < image[0].length && col >= 0 && image[row][col] == target) {
            image[row][col] = newColor;
            dfs(row - 1, col, target, newColor, image);
            dfs(row, col - 1, target, newColor, image);
            dfs(row + 1, col, target, newColor, image);
            dfs(row, col + 1, target, newColor, image);
        }
    }

//    //Rotten Oranges
//    public int orangesRotting(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//        int[][] visited = grid;
//        Queue<Pair> q = new LinkedList<>();
//
//        int total = 0, rotten=0,time=0;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (visited[i][j] == 2) {
//                    q.offer(new Pair(i,j));
//                }
//                if (visited[i][j] == 1 || visited[i][j]==2) {
//                    total++;
//                }
//            }
//        }
//
//        if (total == 0)
//            return 0;
//
//        while (! q.isEmpty()){
//            int size =q.size();
//            rotten+=size;
//
//            if (rotten==total){
//                return time;
//            }
//
//            time++;
//
//            for (int i=0; i<size; i++){
//                Pair p = q.peek();
//            }
//
//        }
//
//    }


    //Detect Cycle in an Undirected Graph -> DFS
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

    //0/1 Matrix (Bfs Problem)


    //Surrounded Regions
    public void surroundedRegion(char[][] board) {
        if (board.length==0){ return;}

        for (int i=0; i<board[0].length; i++){
            if (board[0][i]=='O'){
                dfsSurrounded(board,0,i);
            }
            if (board[board.length-1][i]=='O'){
                dfsSurrounded(board,board.length-1,i);
            }
        }

        for (int i=0; i<board.length; i++){
            if (board[i][0]=='O'){
                dfsSurrounded(board,i,0);
            }
            if (board[i][board.length-1]=='O'){
                dfsSurrounded(board,i,board.length-1);
            }
        }

        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (board[i][j]=='#'){
                    board[i][j]='O';
                }else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }

    }

    private static void dfsSurrounded(char[][] board, int i, int j) {
        if (i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] !='O'){
            return;
        }
        board[i][j]='#';

        dfsSurrounded(board,i+1,j);
        dfsSurrounded(board,i-1,j);
        dfsSurrounded(board,i,j+1);
        dfsSurrounded(board,i,j-1);

    }


    //Number of Enclaves
    public int numEnclaves(int[][] board) {
        if (board.length==0){ return 0;}

        int count_one_before=0;
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if(board[i][j]==1){
                    count_one_before++;
                }
            }
        }

        for (int i=0; i<board[0].length; i++){
            if (board[0][i]==1){
                dfsNumEnclaves(board,0,i);
            }
            if (board[board.length-1][i]==1){
                dfsNumEnclaves(board,board.length-1,i);
            }
        }

        for (int i=0; i<board.length; i++){
            if (board[i][0]==1){
                dfsNumEnclaves(board,i,0);
            }
            if (board[i][board.length-1]==1){
                dfsNumEnclaves(board,i,board.length-1);
            }
        }

        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (board[i][j]==9){
                    board[i][j]=1;
                }else if(board[i][j]==1){
                    board[i][j]=0;
                }
            }
        }

        int count_one_after=0;
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if(board[i][j]==1){
                    count_one_after++;
                }
            }
        }

        return count_one_before-count_one_after;
    }

    private static void dfsNumEnclaves(int[][] board, int i, int j) {
        if (i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] !=1){
            return;
        }
        board[i][j]=9;

        dfsNumEnclaves(board,i+1,j);
        dfsNumEnclaves(board,i-1,j);
        dfsNumEnclaves(board,i,j+1);
        dfsNumEnclaves(board,i,j-1);

    }


    //Word Ladder
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if ( !wordList.contains(endWord)){
            return 0;
        }
        HashMap<String,Boolean> hashMap = new HashMap<String, Boolean>();

        for (int i=0; i<wordList.size(); i++){
            hashMap.put(wordList.get(i),false);
        }

        Queue<String> queue = new LinkedList<>();
        int length=1;
        queue.add(beginWord);
        hashMap.put(beginWord,true);

        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i=0; i<size; i++){
                String w= queue.poll();
                if (w.equals(endWord)){
                    return length;
                }
                wordMatch(w,hashMap,queue);
            }
            length++;
        }
        return 0;
    }

    private static void wordMatch(String w, HashMap<String, Boolean> hashMap, Queue<String> queue) {
        for (int i=0; i<w.length(); i++){
            char[] words = w.toCharArray();
            for (int j=0; j<26; j++){
                char c = (char) ('a' +j);
                words[i]=c;
                String s = String.valueOf(words);
                if (hashMap.containsKey(s) && hashMap.get(s)==false){
                    queue.add(s);
                    hashMap.put(s,true);
                }
            }
        }
    }


}
