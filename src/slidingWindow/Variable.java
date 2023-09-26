package slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Variable {
    //Largest Subarray of sum K


    public int lengthOfLongestSubstring(String s) {
        int left=0,right=0;
        Set<Character> set = new HashSet<>();
        int max=0;
        while (right<s.length()){
            char c = s.charAt(right);
            if (set.add(c)){
                max = Math.max(right-left+1,max);
                right++;
            }else {
                while (s.charAt(left) != c){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(c);
                left++;
            }
        }
        return max;
    }

    public static int longestSubstringLengthWithKDistinctCharacters(String str, int k) {
        if(str == null || str.length() == 0 || k <= 0 || k > str.length()) {
            return -1;
        }

        int maxLength = 0;
        int start, end;
        start = end = 0;

        Map<Character, Integer> map = new HashMap<>();

        while(end < str.length()) {
            char currentChar = str.charAt(end);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

            while(map.size() > k) {
                char charFromFront = str.charAt(start);
                map.put(charFromFront, map.get(charFromFront) - 1);

                if(map.get(charFromFront) == 0) {
                    map.remove(charFromFront);
                }
                start++;
            }

            maxLength = Math.max(end - start + 1, maxLength);
            end++;
        }

        return maxLength;
    }
}
