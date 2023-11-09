package DailyPractice;

import java.util.*;

public class Oct30 {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7};
//        for (int a : reverseArray(arr)){
//            System.out.println(a);
//        }

        String name ="siba";
        System.out.println(reverseString(name));



    }

    //Reverse the array
    public static int[] reverseArray(int[] array,int start,int end){
        int n=array.length;
//        int start=0;
//        int end = n-1;
        while (start<end){
            int temp = array[start];
            array[start]=array[end];
            array[end]=temp;
            start++;
            end--;
        }
        return array;
    }
    //rotate an array
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k=k%n;
        reverseArray(nums, 0, n-1);
        reverseArray(nums,0, k-1);
        reverseArray(nums,k,n-1);
    }


    //Reverse a String
    public static String reverseString(String string){
        String reverse ="";
        int end =string.length();

        for (int i=0; i<end; i++){
            char ch = string.charAt(i);
            reverse =ch+reverse;
        }
        return reverse;
    }
    public void reverseString(char[] s) {
        int n = s.length-1;

        // int start =0;
        // int end = n-1;

        for(int i=0; i<n; i++){
            char temp = s[i];
            s[i] = s[n];
            s[n] = temp;
            n--;
        }
    }


    //Find first and last positions of an element in a sorted array
    public int[] searchRange(int[] nums, int target) {
        int[] arr={-1,-1};
        arr[0]=findInd(nums,target,true);
        arr[1]=findInd(nums,target,false);
        return arr;
    }
    public int findInd(int[] nums,int target,boolean flag){
        int left=0;
        int right=nums.length-1;
        int i=-1;
        while(left<=right)
        {
            int mid=(left+right)/2;

            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]==target){
                i=mid;
                if(flag){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
        }
        return i;
    }

    //Reverse a Linked List
    //1->2->3->4->5->null
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode prev =null;
        ListNode curr = head;

        while (curr !=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }

    //level order traversal
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    //Find a value in a Binary Search Tree
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        if(val<root.val){
            return searchBST(root.left,val);
        }
        return searchBST(root.right,val);
    }

//    //Merge Intervals
//    public int[][] mergeInterval(int[][] intervals) {
//        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
//        Stack<int[]> stack = new Stack<>();
//        stack.add(intervals[0]);
//
//        for (int i=1; i<intervals.length; i++){
//            int startPoint2 = intervals[i][0];
//            int endPoint2= intervals[i][1];
//
//            int[] popArray = stack.pop();
//
//            int startPoint1 = popArray[0];
//            int endPoint1 = popArray[1];
//
//            if (endPoint2>=startPoint2){
//                int[] merge =
//            }else {
//                stack.add(popArray);
//                stack.add(intervals[i]);
//            }
//        }
//
//    }

    //meeting room 1
    /*
      0 1
    0 7 10
    1 2 4
    3 5 6
     */
    public static boolean canAttendMeeting(int[][] intervals) {
        if (intervals.length==0){
            return true;
        }
        Arrays.sort(intervals,(a, b) -> Integer.compare(a[0],b[0]));
        Stack<int[]> stack = new Stack<>();

        stack.add(intervals[0]);

        for (int i=1; i<intervals.length; i++){
            int startPoint2 = intervals[i][0];
            int endPoint2 = intervals[i][1];

            int[] popArray = stack.pop();

            int startPoint1 = popArray[0];
            int endPoint1 = popArray[1];

            if (endPoint1 > startPoint2){
                return false;
            }

            stack.add(intervals[i]);
        }
        return true;
    }

//    ///meeting room 2
//    public int minMeetingRooms(int[][] intervals){
//        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//
//        for (intervals[] : intervals){
//
//            if (priorityQueue.isEmpty()){
//                priorityQueue.add(intervals[1]);
//                continue;
//            }
//        }
//
//    }


    //Rat in a maze Problem


    //Implement Stack using Queue


    //Implement Queue using Stack

    //Implement a Maxheap/MinHeap using arrays and recursion.

    //Partition Equal Subset Sum
    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int  i=0; i<nums.length; i++){
            sum+=nums[i];
        }
        if (sum%2!=0){
            return false;
        }else {
            return subsetSum(nums,sum/2);
        }
    }
    public static boolean subsetSum(int arr[], int sum){
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];

        for (int i=0; i<n+1; i++){
            for (int j=0; j<sum+1; j++){
                if (i==0){
                    dp[i][j]=false;
                }
                if (j==0){
                    dp[i][j]=true;
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++) {
                if (arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][sum];

    }

    //backtracking problems in prakhar shukla







}

