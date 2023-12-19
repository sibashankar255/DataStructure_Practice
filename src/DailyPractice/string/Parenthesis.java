package DailyPractice.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Parenthesis {
    public static void main(String[] args) {
        System.out.println("");
    }

    public void main(){

    }

    //https://leetcode.com/problems/generate-parentheses
    /**
     * maximum length of string is n*2
     * n=1 ()
     * n=2 (()) ()()
     * n=3 ((())) ()()() (())() ()(()) (()())
     *
     *
     *
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        findPara("(", 1,0, result,n);
        return result;
    }
    private void findPara(String current, int open, int close, List<String> result, int n) {
        if (current.length()==n*2){
            result.add(current);
            return;
        }

        if (open<n){
            findPara(current+"(", open+1,close, result,n);
        }
        if (close<open){
            findPara(current+")", open,close+1, result,n);
        }
    }

    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int score=0;

        for (char ch : s.toCharArray()){
            if (ch=='('){
                stack.push(score);
                score=0;
            }else {
                score= stack.pop()+ Math.max(score*2,1);
            }
        }
        return score;
    }
}
