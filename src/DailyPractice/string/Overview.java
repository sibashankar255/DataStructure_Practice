package DailyPractice.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Overview {
    public static void main(String[] args) {

    }

    /**
     *
     * Character Methods:
     *
     * The Character class in Java provides several static methods for working with characters.
     * java
     * Copy code
     * char myChar = 'A';
     *
     * // Check if a character is a letter
     * boolean isLetter = Character.isLetter(myChar);
     *
     * // Check if a character is a digit
     * boolean isDigit = Character.isDigit(myChar);
     *
     * // Convert a character to lowercase
     * char lowercaseChar = Character.toLowerCase(myChar);
     *
     * // Convert a character to uppercase
     * char uppercaseChar = Character.toUpperCase(myChar);
     * Comparing Characters:
     *
     * You can compare characters using standard comparison operators or by using the compareTo method.
     * java
     * Copy code
     * char char1 = 'A';
     * char char2 = 'B';
     *
     * // Using comparison operators
     * if (char1 < char2) {
     *     // Do something
     * }
     *
     * // Using compareTo method
     * int compareResult = Character.compare(char1, char2);
     * Converting Characters to Strings:
     *
     * You can convert a char to a String using the Character.toString method or by concatenating it with an empty string.
     * java
     * Copy code
     * char myChar = 'A';
     *
     * // Using Character.toString method
     * String charToString = Character.toString(myChar);
     *
     * // Using concatenation with an empty string
     * String charToStringConcat = myChar + "";
     * Checking for Whitespace:
     *
     * The Character class provides methods to check for whitespace characters.
     * java
     * Copy code
     * char myChar = ' ';
     *
     * // Check if a character is whitespace
     * boolean isWhitespace = Character.isWhitespace(myChar);
     * ASCII Values:
     *
     * You can obtain the ASCII value of a character using type casting or by using the Character.getNumericValue method.
     * java
     * Copy code
     * char myChar = 'A';
     *
     * // Using type casting
     * int asciiValue = (int) myChar;
     *
     * // Using Character.getNumericValue method
     * int numericValue = Character.getNumericValue(myChar);
     * Checking for Uppercase/Lowercase:
     *
     * You can check if a character is uppercase or lowercase using the isUpperCase and isLowerCase methods.
     * java
     * Copy code
     * char myChar = 'A';
     *
     * // Check if a character is uppercase
     * boolean isUpperCase = Character.isUpperCase(myChar);
     *
     * // Check if a character is lowercase
     * boolean isLowerCase = Character.isLowerCase(myChar);
     *
     *
     *
     *         // Convert char to digit (integer)
     *         int digitValue = charDigit - '0';
     *
     *         // Convert digit to char
     *         char charDigit = (char) (digitValue + '0');
     */

    //20. Valid Parentheses
    public boolean isValid(String s) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("]","[");
        hashMap.put("}","{");
        hashMap.put(")","(");

        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)== '{'){
                stack.push(s.charAt(i));continue;
            }
            if (stack.size()==0 || !hashMap.get(s.charAt(i)).equals(stack.pop())){
                return false;
            }
        }
        if (stack.size()==0){
            return true;
        }
        return false;
    }

    //22. Generate Parentheses
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        findAll("(",1,0,result,n);
        return result;
    }

    private void findAll(String current, int open, int close, List<String> result, int n) {
        if (current.length()==2*n){
            result.add(current);
            return;
        }

        if (open<n){
            findAll(current+"(", open+1, close,result,n);
        }
        if (close<open){
            findAll(current+")",open, close+1,result,n);
        }
    }

}
