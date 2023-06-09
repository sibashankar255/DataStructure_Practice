package backtracking;

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






}
