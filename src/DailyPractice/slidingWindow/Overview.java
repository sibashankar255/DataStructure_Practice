package DailyPractice.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class Overview {
    public static void main(String[] args) {
        String s = "geeksofgeeks";
        System.out.println(lengthOfLongestSubstring(s));

    }

    //3. Longest Substring Without Repeating Characters
    public static int lengthOfLongestSubstring(String s) {
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

    //159. Longest Substring with At Most Two Distinct Characters
}
