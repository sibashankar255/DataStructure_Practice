package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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




}
