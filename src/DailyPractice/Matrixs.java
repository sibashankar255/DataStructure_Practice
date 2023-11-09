package DailyPractice;

import java.util.ArrayList;
import java.util.List;

public class Matrixs {

    public static void main(String[] args) {
    }

    //Spiral traversal on a Matrix
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix.length == 0 || matrix[0].length == 0)
            return res;

        int rowBegin=0;
        int rowEnd=matrix.length-1;
        int colBegin=0;
        int colEnd=matrix[0].length-1;

        while (rowBegin<=rowEnd && colBegin<=colEnd){
            //traverse right
            for (int j=colBegin; j<=colEnd; j++){
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            //traverse down
            for (int j=rowBegin;j<=rowEnd;j++){
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            //traverse left
            if (rowBegin<=rowEnd){
                for (int j=colEnd; j>=colBegin; j--){
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            //traverse up
            if (colBegin<=colEnd){
                for (int j=rowEnd; j>=rowBegin; j--){
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin++;
        }
        return res;
    }

    //Search an element in a matrix
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIdx = searchPotentialRow(matrix,target);
        if (rowIdx!=-1){
            return binarySearchOverRow(rowIdx,matrix,target);
        }else {
            return false;
        }
    }
    private boolean binarySearchOverRow(int rowIdx, int[][] matrix, int target) {
        int low=0;
        int high = matrix[rowIdx].length-1;
        while (low<=high){
            int mid = low+(high-low)/2;
            if (matrix[rowIdx][mid]==target){
                return true;
            } else if (matrix[rowIdx][mid]>target) {
                high=mid-1;
            }else {
                low=mid+1;
            }
        }
        return false;
    }

    private static int searchPotentialRow(int[][] matrix, int target) {
        int low =0;
        int high = matrix.length-1;
        while (low<=high){
            int mid = low+(high-low)/2;
            if (matrix[mid][0]<=target && target<=matrix[mid][matrix[0].length-1]) {
                return mid;
            }else if (matrix[mid][0]<target){
                low=mid+1;
            }else if (matrix[mid][0]>target){
                high=mid-1;
            }
        }
        return -1;
    }



    //Find median in a row wise sorted matrix
    //sort all the elements in the matrix and return the middle element
//    static int binaryMedian(int matrix[][], int row, int col){
//
//    }

    //Find row with maximum no. of 1's

}
