package greedy;

import java.util.Arrays;

public class Greedy {
    public static void main(String[] args) {

    }

    //there is a limited time sale going on for toys,
    //A[i] -> sale end time for ith toy
    //B[i] -> beauty of ith toy
    //it takes 1 unit of time to buy a toy
    //toys can be bought if current time < A[i]
    //buy toys such that sum of beauty maximized

    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here

        //res to store the result (maximum number of non-overlapping activities) and set it to 0
        int res = 0;
        //2D array arr to store the start time, end time, and index of each activity
        int arr[][] = new int[n][3];

        //Iterate through the activities (indexed by i) and fill the arr array with the start time, end time, and index (i+1) of each activity
        for(int i=0; i<n; i++){
            arr[i][0] = i+1;
            arr[i][1] = start[i];
            arr[i][2] = end[i];
        }
        //Sort the arr array based on the end times of the activities in ascending order
        //sorting is crucial for the greedy approach used to solve the problem
        Arrays.sort(arr,(a, b) ->Integer.compare(a[2],b[2]));
        res++;   //done because at least one activity can be performed by the person

        //Initialize a variable r with the end time of the first activity (arr[0][2])
        //This variable represents the current end time of the last selected activity
        int r = arr[0][2];
        for(int i=1; i<n; i++){

            //If the start time of the current activity (arr[i][1]) is greater than the current end time (r)
            //it means that this activity can be performed without overlapping with the previously selected activity
            if(arr[i][1] > r){
                // System.out.println(arr[i][1]+"  , "+r);
                //update the r variable to the end time of the current activity (arr[i][2]) and increment the res counter
                r = arr[i][2];
                res++;
            }
        }
        //After the loop, the res variable will hold the maximum number of non-overlapping activities that can be performed by the person
        return res;
    }


}
