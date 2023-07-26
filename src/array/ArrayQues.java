package array;

import java.util.*;

public class ArrayQues {
    public static void main(String[] args) {
        int[] A ={1,2,3,1,1};
        int[] B={-5,-4,-2,-6,-1};
        int[] C ={1,2};
        System.out.println(stockBuySell1(C));
        String a = "asaf";

    }

    //merge 2 sorted arrays
    public static int[] merge(int[] A,int[] B){
        int n=A.length;
        int m=B.length;
        int[] mergedArray = new int[n+m];
        int p1=0;
        int p2=0;
        int k=0;
        while (p1<n && p2<m){
            if (A[p1]<B[p2]){
                mergedArray[k]=A[p1];
                p1++;
            }else {
                mergedArray[k]=B[p2];
                p2++;
            }
            k++;
        }
        while (p1<n){
            mergedArray[k]=A[p1];
            k++;p1++;
        }
        while (p2<m){
            mergedArray[k]=B[p2];
            k++;p2++;
        }
        return mergedArray;
    }


    //majority element
    public static int majorityElement(int[] arr){
        int ansIndex=0;
        int count=0;
        for (int i=0; i<arr.length; i++){
            if (arr[i]==arr[ansIndex]){
                count++;
            }else {
                count--;
            }
            if (count==0){
                ansIndex=i;
                count=1;
            }
        }
        int countMajority=0;
        for (int i=0; i<arr.length; i++){
            if (arr[ansIndex]==arr[i]){
                countMajority++;
            }
        }
        if (countMajority>arr.length/2){
            return arr[ansIndex];
        }
        return 0;
    }

    //maximum sum subarray
    public static int maxSubArraySum(int[] arr){
        int maxSum =0;
        int currSum =0;
        for (int i=0; i<arr.length;i++){
            currSum = currSum+arr[i];
            if (currSum>maxSum){
                maxSum=currSum;
            }
            if (currSum<0){
                currSum=0;
            }
        }
        return maxSum;
    }

    //stock buy and sell
    public static int stockBuySell1(int[] arr){
        int maxProfit=0;
        int minSoFar=arr[0];
        for (int i=1; i<arr.length; i++){
            minSoFar = Math.min(minSoFar,arr[0]);
            int Profit = arr[i]-minSoFar;
            maxProfit = Math.max(maxProfit,Profit);
        }
        return maxProfit;
    }
    public static int stockBuySell2(int[] arr){
        int profit=0;
        for (int i=1; i<arr.length; i++){
            if (arr[i]>arr[i-1]){
                profit += arr[i]-arr[i-1];
            }
        }
        return profit;
    }

    //trapping of water
//    public static int trappingWater(int[] arr){
//
//    }

    public static void setZeros(int[][] matrix){
        int n=matrix.length;
        int m=matrix[0].length;

        int[] row = new int[n];
        int[] col = new int[m];

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (matrix[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (row[i] == col[j]){
                    matrix[i][j]=0;
                }
            }
        }



//        for (int i=0; i<n; i++){
//            for (int j=0; j<m; j++){
//                if (matrix[i][j]==0){
//                    makeRow(matrix,i);
//                    makeCol(matrix,j);
//                }
//            }
//        }
//        for (int i=0; i<n; i++){
//            for (int j=0; j<m; j++){
//                if (matrix[i][j]==-1){
//                    matrix[i][j]=0;
//                }
//            }
//        }


    }
    public static void makeRow(int[][] matrix, int i){
        for (int j=0; j<matrix.length; j++){
            if (matrix[i][j] !=0){
                matrix[i][j]=-1;
            }
        }
    }
    public static void makeCol(int[][] matrix, int j){
        for (int i=0; i<matrix[0].length; i++){
            if (matrix[i][j] !=0){
                matrix[i][j]=-1;
            }
        }
    }

    //rotate a matrix by 90
    public static void transpose(int[][] A){
        int n=A.length;
        int[][] X = new int[n][n];
        for(int i=0; i<n;i++){
            int y=0;
            for(int j=n-1; j>=0;j--){
                X[i][y]=A[j][i];
                y++;
            }
        }
    }

    //count of subArray sum equals to k
    public static int countSubArray(int[] nums,int K){
        int count = 0;
        int sum = 0;
        // Store the cumulative sum and its frequency in a HashMap
        HashMap<Integer, Integer> sumFrequency = new HashMap<>();
        sumFrequency.put(0, 1); // To consider subarrays starting from index 0

        for (int num : nums) {
            sum += num;
            int diff = sum - K;

            if (sumFrequency.containsKey(diff)) {
                // If a cumulative sum (sum - K) exists in the HashMap,
                // it means there are subarrays with the desired sum
                count += sumFrequency.get(diff);
            }

            // Update the frequency of the current cumulative sum
            sumFrequency.put(sum, sumFrequency.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static List<List<Integer>> generatePascle(int numRows) {
        List<List<Integer>> pascel = new ArrayList<>();
        for (int i=1; i<numRows; i++){
            pascel.add(generateRow(i));
        }
        return pascel;
    }

    public static List<Integer> generateRow(int row){
        int ans=1;
        List<Integer> list = new ArrayList<>();
        list.add(ans);
        for (int col=1; col<row; col++){
            ans = ans*(row-col);
            ans = ans/col;
            list.add(ans);
        }
        return list;
    }

    public static List<List<Integer>> threeSum(int[] num){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(num);
        for (int i=0; i<num.length; i++){
            if (i>0 && num[i]==num[i-1]){
                continue;
            }
            int j=i+1;
            int k=num.length-1;
            while (j<k){
                int sum=num[i]+num[j]+num[k];
                if (sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }else {
                    List<Integer> list = new ArrayList<>();
                    list.add(num[i]);
                    list.add(num[j]);
                    list.add(num[k]);
                    ans.add(list);
                    j++;
                    k--;
                    while (j<k && num[j]==num[j-1]){j++;}
                    while (j<k && num[k]==num[k-1]){k++;}
                }
            }
        }
        return ans;
    }


    //Merge Overlapping Intervals
    public static int[][] mergeOverlapping(int[][] intervals) {

        if (intervals.length <= 1)
            return intervals;

        // Sort by ascending starting point
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();

        int[] newInterval = intervals[0];
        result.add(newInterval);

        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1])
                // Overlapping intervals,
                // update the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            else {
                // Disjoint intervals,
                // add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }


}
