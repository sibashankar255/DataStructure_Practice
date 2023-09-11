package Striver.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Easy {
    public static void main(String[] args) {

//        String s = "(()())(())";
//        System.out.println(removeOuterParentheses(s));

        String s = "the sky is blue";
        System.out.println(reverseWords(s));

    }


    //Remove Outermost Parentheses
    public static String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (count != 0) {
                    result.append(c);
                }
                count++;
            } else {
                if (count != 1) {
                    result.append(c);
                }
                count--;
            }
        }

        return result.toString();
    }

    //Reverse Words in a String
    public static String reverseWords(String s) {
        // Trim the input string to remove leading and trailing spaces
        String[] str = s.trim().split("\\s+");

        // Initialize the output string
        String out = "";

        // Iterate through the words in reverse order
        for (int i = str.length - 1; i > 0; i--) {
            // Append the current word and a space to the output
            out += str[i] + " ";
        }

        // Append the first word to the output (without trailing space)
        return out + str[0];
    }

    //Largest Odd Number in String
    public String largestOddNumber(String num) {
        int n = num.length();

        for (int i = n - 1; i >= 0; i--) {
            char digit = num.charAt(i);
            if (digit % 2 == 1) {
                return num.substring(0, i + 1);
            }
        }

        return "";
    }

    //Longest Common Prefix
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length-1].toCharArray();
        StringBuilder result = new StringBuilder();

        for (int i=0; i<first.length; i++){
            if (first[i] != last[i]) {
                break;
            }
            result.append(first[i]);
        }


        return result.toString();
    }


    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // Create a hashmap to store character mappings
        Map<Character, Character> charMappingMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char original = s.charAt(i);
            char replacement = t.charAt(i);

            if (!charMappingMap.containsKey(original)) {
                if (!charMappingMap.containsValue(replacement))
                    charMappingMap.put(original, replacement);
                else
                    return false;
            }
            else {
                char mappedCharacter = charMappingMap.get(original);
                if (mappedCharacter != replacement)
                    return false;
            }
        }

        return true;
    }

    //Rotate String

    //Valid Anagram
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);

    }

    //Sort Characters By Frequency
    public String frequencySort(String s) {
        char[] chara = new char[26];

        char[] string  = s.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();


        for (char c:s.toCharArray()) {

        }

        return stringBuilder.toString();

    }





}
