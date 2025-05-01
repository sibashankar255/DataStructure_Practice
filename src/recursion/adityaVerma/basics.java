package recursion.adityaVerma;


import java.util.Stack;



public class basics {
    public static void main(String[] args) {

//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(3);
//        treeNode1.left=treeNode2;
//        treeNode1.right= treeNode3;
//        TreeNode treeNode4 = new TreeNode(4);
//        TreeNode treeNode5 = new TreeNode(5);
//        treeNode2.left=treeNode4;
//        treeNode2.right=treeNode5;
//        TreeNode treeNode6 = new TreeNode(6);
//        TreeNode treeNode7 = new TreeNode(7);
//        treeNode3.left=treeNode6;
//        treeNode3.right=treeNode7;
//
//        printN(5);
//        System.out.println(factorial(5));
//        System.out.println(heightTree(treeNode4));


//        int numDiscs = 5;
//        char source = 'A', auxiliary = 'B', destination = 'C';
//
//        // Solve Tower of Hanoi problem
//        solveTowerOfHanoi(numDiscs, source, auxiliary, destination);

//        System.out.println(power(0,5));

//        System.out.println(isPalindrome("raceca",0,5));

        powerSet("abc",0,"_");


    }
    /**
     *  how to solve recursion problems
     *  1.Induction based Hypothesis
     *  2.recursion tree
     *  3.choice diagram
     *
     *
     */

    //print 1 to n using recursion
    static void printN(int n){
        if (n==1){
            System.out.println(n);
            return;
        }
        printN(n-1);
        System.out.println(n);
    }

    //factorial of a number
    static int factorial(int n){
        if (n==0 || n==1){
            return 1;
        }else {
            return n* factorial(n-1);
        }
    }

    //height of a binary tree
    static int heightTree(TreeNode root){

        if (root==null){
            return 0;
        }

        int left = heightTree(root.left);
        int right = heightTree(root.right);

        return 1 + Math.max(left,right);
    }

    //sort an array
    //i/p = 2,3,7,6,5,4,9
    //o/p = 2,3,4,5,6,7,9
    //merge sort -> nlogn
    // recursion ->
    //choice + decisions
    // decision ->
    // smaller input ->


    //sort a stack


    //delete a middle element of a stack
    public static void deleteMiddleElement(Stack<Integer> stack, int n, int current) {
        // Base condition
        if (stack.isEmpty() || current == n)
            return;

        // Pop the current element from stack
        int x = stack.pop();

        // Delete middle element
        if (current != n/2)
            deleteMiddleElement(stack, n, current+1);

        // Push all other elements back into the stack
        if (current != n/2)
            stack.push(x);
    }

    public static void reverseStack(Stack<Integer> stack) {
        // Base condition
        if (!stack.isEmpty()) {
            // Remove the top element
            int x = stack.pop();

            // Reverse the remaining stack
            reverseStack(stack);

            // Insert the top element at the bottom
            insertAtBottom(stack, x);
        }
    }
    public static void insertAtBottom(Stack<Integer> stack, int x) {
        // Base condition
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }

        // Pop all elements and insert x at the bottom
        int temp = stack.pop();
        insertAtBottom(stack, x);
        stack.push(temp);
    }


    public static void solveTowerOfHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + source + " to rod " + destination);
            return;
        }

        // Move top n-1 disks from A to B using C as auxiliary
        solveTowerOfHanoi(n - 1, source, destination, auxiliary);

        // Move remaining disk from A to C
        System.out.println("Move disk " + n + " from rod " + source + " to rod " + destination);

        // Move n-1 disks from B to C using A as auxiliary
        solveTowerOfHanoi(n - 1, auxiliary, source, destination);
    }

    // a^b
    public static int power(int a , int b){
        if (b==0){
            return 1;
        }
        return a*power(a,b-1);
    }

    //Josephus Problem


    //palindrome
    static boolean isPalindrome(String str, int start, int end){
        if (start>=end){
            return true;
        }
        if (str.charAt(start) != str.charAt(end)){
            return false;
        }
        return isPalindrome(str,start+1,end-1);
    }

    //superset of a string
    static void powerSet(String str, int i, String cur){
        if (i==str.length()){
            System.out.println(cur);
            return;
        }
        powerSet(str,i+1, cur+str.charAt(i));
        powerSet(str,i+1, cur);
    }

    //all permutation of a given string
    static void permutation(String str, int l, int r){
        if (l==r){
            System.out.println(str);
            return;
        }
        for (int i=l; i<=r; i++){
            str=swap(str,l,i);
            permutation(str,l+1,r);
            str = swap(str,l,i);
        }
    }

    private static String swap(String str, int l, int i) {
        return null;
    }


}

