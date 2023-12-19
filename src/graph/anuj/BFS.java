package graph.anuj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BFS {
    //find the minimum distance from source to destination
    //find the number of connected components

    public static void main(String[] args) {



    }
    public static int[][] emptyArray() {
        return new int[0][];
    }



    public static boolean bfs(ArrayList<ArrayList<Integer>> adj, int src, int dest, int v, int pred[], int dist[]){

        LinkedList<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[v];
        for (int i=0; i<v; i++){
            visited[i]=false;
            dist[i]=Integer.MAX_VALUE;
            pred[i]=-1;
        }

        visited[src]=true;
        dist[src]=0;
        queue.add(src);

        while (!queue.isEmpty()){
            int curr = queue.remove();
            for (int i=0; i<adj.get(curr).size(); i++){
                int neighbour = adj.get(curr).get(i);
                if (visited[neighbour]==false){
                    visited[neighbour]=true;
                    dist[neighbour]=dist[curr]+1;
                    pred[neighbour]=curr;
                    queue.add(neighbour);

                    if (neighbour==dest){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //01 Matrix
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

                //if r < 0  (r value can't be -ve)
                //if r>=row (r value can't be greater than row)
                //if c<0 (c value can't be -ve)
                //if c>=col (col value can't be greater than col)
                //if mat[r][c] !=-1 (if its zero) then continue
                if (r<0 || r>=row || c<0 || c>=col || mat[r][c] !=-1){
                    continue;
                }

                //else add that particular row,col value to queue
                queue.add(new int[]{r,c});

                //increase the value of matrix cell value +1;
                mat[r][c] = mat[cell[0]][cell[1]] +1;
            }
        }
        return mat;
    }


    //1162. As Far from Land as Possible
    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];
        int result =-1;

        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (grid[i][j]==1){
                    visited[i][j]=true;
                    queue.offer(new int[]{i,j});
                }
            }
        }

        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- >0){
                int[] cell = queue.poll();

                for (int[] dir : direction){
                    int r = cell[0] +dir[0];
                    int c = cell[1] +dir[1];

                    if (r<0 || c<0 || r>=row || c>=col || visited[r][c]){
                        continue;
                    }

                    visited[r][c] =true;
                    grid[r][c] = grid[cell[0]][cell[1]] + 1;
                    result = Math.max(result, grid[r][c]);
                    queue.add(new int[] {r,c});
                }
            }
        }
        return result<0 ? -1 : result-1;
    }

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        // Enqueue all rotten oranges and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        int minutes = 0;

        // Perform BFS to simulate rotting process
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            minutes = current[2];

            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                    grid[newRow][newCol] = 2; // Mark the fresh orange as rotten
                    freshOranges--;
                    queue.offer(new int[]{newRow, newCol, minutes + 1});
                }
            }
        }

        // Check if there are any remaining fresh oranges
        return (freshOranges == 0) ? minutes : -1;
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int ans = 0;

        int row = grid.length;
        int col = grid[0].length;

        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
            return -1;
        }

        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        boolean[][] visited = new boolean[row][col];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;

            for (int i = 0; i < size; i++) {
                int[] curPos = queue.poll();

                if (curPos[0] == row - 1 && curPos[1] == col - 1) {
                    return ans;
                }

                for (int[] dir : dirs) {
                    int nextX = curPos[0] + dir[0];
                    int nextY = curPos[1] + dir[1];

                    if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col
                            || visited[nextX][nextY] || grid[nextX][nextY] == 1) {
                        continue;
                    }

                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }

        return -1;
    }

    public static class DirectionValue{
        int x;
        int y;
        int dist;
        DirectionValue(int x, int y, int dist){
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }

    public static int shortestPathBinaryMatrix1(int[][] grid) {
        int row=grid.length;
        int col = grid[0].length;

        if (grid[0][0]==1 || grid[row-1][col-1]==1){
            return -1;
        }

        int[][] direction = {{-1,-1,},{-1,0},{1,-1},{0,1},{1,1},{1,0},{-1,1},{0,-1}};

        Queue<DirectionValue> queue = new LinkedList<>();
        queue.add(new DirectionValue(0,0,1));
        grid[0][0]=1;

        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i=0; i<size; i++){
                DirectionValue temp = queue.poll();
                int x = temp.x;
                int y =temp.y;
                int value = temp.dist;

                if (x==row-1 && y==col-1){
                    return value;
                }
                for (int[] way : direction){
                    int newX = x+way[0];
                    int newY = y+way[1];

                    if (newX>=0 && newY>=0 && newX<row && newY<col && grid[newX][newY]==0){
                        queue.add(new DirectionValue(newX,newY,value+1));
                        grid[newX][newY]=1;
                    }
                }
            }
        }
        return -1;

    }


}

