package stack;

import java.util.ArrayList;
import java.util.Stack;

public class StackQues {
    public static void main(String[] args) {

        int[] A={4,2,1,5,6,3,2,4,2};

        //System.out.println(maxHistogram(A));

        int[][] B = {{0, 0, 1},{0, 1, 1},{1,1,1}};

        System.out.println(largestArea(B));
//        for (int x:pSmaller(A)) {
//            System.out.print(x);
//        }
//        System.out.println();
//        for (int x:nSmaller(A)) {
//            System.out.print(x);
//        }
    }

    //Balanced Paranthesis
    public static int balancedParenthesis(String string) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<string.length(); i++){
            char ch = string.charAt(i);
            if (ch =='(' || ch=='{' || ch=='['){
                stack.push(ch);
            }else if(ch ==')'){
                if (!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                }else {
                    return 0;
                }
            }else if(ch =='}'){
                if (!stack.isEmpty() && stack.peek()=='{'){
                    stack.pop();
                }else {
                    return 0;
                }
            }else if(ch ==']'){
                if (!stack.isEmpty() && stack.peek()=='['){
                    stack.pop();
                }else {
                    return 0;
                }
            }
        }
        return stack.isEmpty() ? 1 :0;
    }

    //Double Character Trouble
    public static String removeDoubleChar(String A){
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<A.length(); i++){
            char ch = A.charAt(i);
            if (!stack.isEmpty() && stack.peek()==ch){
                stack.pop();
            }else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.insert(0,stack.pop());
        }


        return sb.toString();
    }

    //previous Smaller Element
    public static void previousSmaller(int[] arr){
        ArrayList<Integer> near = new ArrayList<Integer>();

        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<arr.length; i++){
            while (!stack.isEmpty() && stack.peek()>=arr[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                System.out.println(-1);
            }else {
                System.out.println(stack.peek());
            }
            stack.push(arr[i]);
        }
    }

    //next smaller element
    public static void nextSmaller(int[] arr){
        Stack<Integer> stack = new Stack<>();

        for (int i=arr.length-1; i>=0; i--){
            while (!stack.isEmpty() && stack.peek()>=arr[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                System.out.println(-1);
            }else {
                System.out.println(stack.peek());
            }
            stack.push(arr[i]);
        }
    }

//    //largest area submatrix with all 1's
//    public static int largestArea(int[][] a){
//        int curRow[] =a[0];
//        int maxAns=maxHistogram(curRow);
//
//        for (int i=1; i<a.length; i++){
//            for (int j=0; j<a[0].length; j++){
//                if (a[i][j]==1){
//                    curRow[j] +=1;
//                }else {
//                    curRow[j]=0;
//                }
//            }
//            int curAns= maxHistogram(curRow);
//            maxAns = Math.max(maxAns,curAns);
//        }
//        return maxAns;
//    }

    //largest rectangle in histogram
    public static int maxHistogram(int[] A){
        int maxAns =0;
        int ps[] = pSmaller(A);
        int ns[] = nSmaller(A);
        for (int i=0; i<A.length; i++){
            int curr = (ns[i]-ps[i])*A[i];
            maxAns=Math.max(maxAns,curr);
        }
        return maxAns;
    }
    public static int[] pSmaller(int[] A) {
        //ArrayList<Integer> prevSmaller = new ArrayList<Integer>();
        int[] ps = new int[A.length];
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<A.length; i++){
            while (!stack.isEmpty() && A[stack.peek()]>=A[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                ps[i]=-1;
            }else {
                ps[i] = stack.peek();
            }
            stack.push(i);
        }
        return ps;
    }
    public static int[] nSmaller(int[] arr){
        int[] ns = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i=arr.length-1; i>=0; i--){
            while (!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                ns[i]= arr.length;
            }else {
                ns[i]=stack.peek();
            }
            stack.push(i);
        }
        return ns;
    }

    //Maximum Rectangle
    public static int largestArea(int[][] A){
        int currRow[] =A[0];
        int maxAns = maxHistogram(currRow);

        for (int i=1; i<A.length; i++){
            for (int j=0; j<A[0].length; j++){
                if(A[i][j]==1){
                    currRow[j]+=1;
                }else {
                    currRow[j]=0;
                }
            }
            int currAns=maxHistogram(currRow);
            maxAns = Math.max(maxAns, currAns);
        }
        return maxAns;
    }

}
