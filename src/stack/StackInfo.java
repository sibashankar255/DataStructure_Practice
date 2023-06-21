package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StackInfo {
    public static void main(String[] args) {
        //Stack<Integer> stack = new Stack<>();

        //push(x) -> insert x at the top of stack
        //pop() -> remove top element from stack
        //top()/peck() -> get the top element from stack
        //isEmpty() ->check if stack is empty
        //size() -> return the no of elements in the stack

//        push(1);
//        push(2);
//        System.out.println(arrayList);
//        System.out.println(pop());
//        push(3);
//        System.out.println(arrayList);

//        Character[] characters1 = {'{', '}', '{', '}', '{', '}', '{', '}'};
//        Character[] characters2 = {'(', ')', '[', ']', '{', '}'};
//        System.out.println(checkBrackets(characters2));
        int[] arr = { 3,  10,  6,  1,  4};
        //System.out.println(nearestElement(arr));
        Arrays.stream(arr).forEach(System.out::print);
        Arrays.stream(nearestElement(arr)).forEach(System.out::println);

    }

    //implement stack using dynamic array
    public static ArrayList<Integer> arrayList = new ArrayList<>();
    public static int top = -1;

    public static void push(int x) {
        top += 1;
        if (arrayList.size() == top) {
            arrayList.add(x);
        } else {
            arrayList.set(top, x);
        }
    }

    public static boolean isEmpty() {
        return (top == -1);
    }

    public static int pop() {
        if (isEmpty()) {
            return -1;
        }
        int x = arrayList.get(top);
        top -= 1;
        return x;
    }

    public static int peck() {
        if (isEmpty()) {
            return -1;
        }
        return arrayList.get(top);
    }

    //implement stack using linked list

    //check weather the given sequence of parentheses is valid or not
    //stack -> keep storing opening bracket from L to R.
    //if you face a closing bracket, try it with the last opening bracket in stack (top)
    //if no -> return false
    //if yes -> delete that opening bracket from stack
    public static boolean checkBrackets(Character[] str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')') {
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            } else if (ch == '}') {
                if (!stack.isEmpty() && stack.peek() == '{')
                    stack.pop();
                else
                    return false;
            } else {
                if (!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty() ? true : false;
    }

    //given a character array s, remove equal pair of consecutive characters multiple times,
    // as long as possible. return the final string


    //infix expression

    //postfix expression

    //given an integer array A, find the index of nearest smaller elements on the left for A[i]
    //for every i, find max j such that A[j] < A[i] and j<i
    // A =  { 3  10  6  1  4}
    //o/p -> -1  3   3 -1  1
    //B =  {8  2  4  9  7  5  3 10 3}
    //o/p->-1 -1  2  4  4  4  2  3 2
    //C =  {6  4  8  11  9  20  15  17  25  12  11 5}
    //o/p->-1 -1  4   8  8  9   9   15  17   9  9  4
    //T.C -> n(O)
    //S.C -> n(O)
    public static int[] nearestElement(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        for (int i=0; i<n; i++){
            while (!stack.isEmpty() && arr[stack.peek()] >=arr[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                ans[i]=-1;
            }else {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    //for every i nearest greater element for the left of i.
    // pop -> arr[stack.peek()] <= arr[i]


    //given an integer array A, A[i]= stack of ith rectangle width of each rectangle=1; find
    //the area of largest rectangle formed by the histogram

    //brute force -> for every (i,j) go from i to j and find min h.
    // h*(j-i+1)-> area

    //for every i, find the max length




    
}
