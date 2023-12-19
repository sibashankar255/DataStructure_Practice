package backtracking;

import java.util.*;

public class Backtracking {
    //recursion-> solving a problem based on sub problems
    //backtracking-> trying all possibilities using recursion

    //rate in a maze
    //check if it is possible to go from top left(0,0) of grid to bottom
    // right in a maze with blocked cells
    //A[n][n] ->0(empty)
    //        ->1(blocked)

    public static boolean check(int[][] A, int i, int j){
        int n =A.length;
        int m =A[0].length;
        if (i<0 || j<0 || i>=n || j>=m){
            return false;
        }
        if (A[i][j]==1 || A[i][j]==2){
            return false;
        }
        if (i==n-1 && i==m-1){
            return true;
        }
        A[i][j]=2;

        return check(A, i-1, j ) || check(A, i+1, j) || check(A, i,j-1) || check(A, i, j+1);

    }

    //given a character array with all the distinct elements,
    // print all permutation of it without modifying it
    //A->{a b c} -> {a b c}, {b a c}, {c a b}, {a c b}, {b c a}, {c b a}
    //no of permutation -> n!



    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> arr) {
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        generateSubset(0,arr, new ArrayList<>(),result);
        return result;
    }

    private void generateSubset(int index, ArrayList<Integer> arr, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> result) {
        result.add(new ArrayList<>(curr));

        for (int i=index; i<arr.size(); i++){
            curr.add(arr.get(i));
            generateSubset(i+1,arr,curr,result);
            curr.remove(curr.size()-1);
        }
    }


//    private void backTrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> arrayList, ArrayList<Integer> arr, int start) {
//        result.add(new ArrayList<>(arrayList));
//
//        for (int i=start; i<arr.size(); i++){
//            arrayList.add(arr.get(i));
//
//            backTrack(result,arrayList,arr,i+1);
//
//            arrayList.remove(arrayList.size()-1);
//        }
//    }

    public ArrayList<ArrayList<Integer>> subsetsIterative(ArrayList<Integer> arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i=0; i<arr.size(); i++){
            int n=result.size();
            for (int j=0; j<n; j++){
                ArrayList<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(arr.get(i));
                result.add(temp);
            }
        }
        return result;
    }


    //permutation
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(res, nums, new ArrayList(), visited);

        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, List<Integer> curr, boolean[] visited) {
        if (curr.size() ==nums.length){
            res.add(new ArrayList(curr));
            return;
        }

        for (int i=0 ; i<nums.length; i++){
            if (visited[i]==true){
                continue;
            }

            curr.add(nums[i]);
            visited[i]=true;
            backtrack(res,nums,curr,visited);
            curr.remove(curr.size()-1);
            visited[i]=false;
        }
    }


    //valid sudoku?
    public boolean isValidSudoku(char[][] board) {
        HashSet seen = new HashSet<>();
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                if (board[i][j] != '.'){
                    if (!seen.add("row" + i + board[i][j]) || !seen.add("col" + j + board[i][j])){
                        return false;
                    }
                    if (!seen.add("box" + (i/3)*3 + j/3 + board[i][j])){
                        return false;
                    }
                }

            }
        }
        return true;
    }

    //n-queen
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoard = new ArrayList<>();
        char[][] board = new char[n][n];
        helper(board,allBoard,0);
        return allBoard;
    }

    public void helper (char[][] board, List<List<String>> allBoard, int col){
        if (col==board.length){
            saveBoard(board,allBoard);
            return;
        }
        for (int row=0; row<board.length; row++){
            if (isSafe(row,col,board)){
                board[row][col]='Q';
                helper(board,allBoard,col+1);
                board[row][col]='.';
            }
        }
    }

    private void saveBoard(char[][] board, List<List<String>> allBoard) {
        String row = "";
        List<String> board1 = new ArrayList<>();
        for (int i=0; i<board.length; i++){
            row="";
            for (int j=0; j<board[0].length; j++){
                if (board[i][j] =='Q'){
                    row +='Q';
                }else {
                    row +='.';
                }
            }
            board1.add(row);
        }
        allBoard.add(board1);
    }

    private boolean isSafe(int row, int col, char[][] board) {
        //horizontal
        for (int j=0; j<board.length; j++){
            if (board[row][j]=='Q'){
                return false;
            }
        }
        //vertical
        for (int i=0; i<board[0].length; i++){
            if (board[i][col]=='Q'){
                return false;
            }
        }
        //upper left
        int r=row;
        for (int c=col; c>=0 && r>=0; c--,r--){
            if (board[r][c]=='Q'){
                return false;
            }
        }
        //upper right
        r=row;
        for (int c=col; c<board.length && r>=0; r--,c++){
            if (board[r][c]=='Q'){
                return false;
            }
        }
        //lower left
        r=row;
        for (int c=col; c>=0 && r<board.length; r++,c--){
            if (board[r][c]=='Q'){
                return false;
            }
        }
        //lower right
        for (int c=col; c<board.length && r<board.length; r++,c++){
            if (board[r][c]=='Q'){
                return false;
            }
        }

        return true;
    }


}
