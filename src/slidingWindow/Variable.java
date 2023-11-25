package slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Variable {

    //Subarray Sum Equals K
    public int subarraySum(int[] nums, int K) {
        int count = 0;
        int sum = 0;
        // Store the cumulative sum and its frequency in a HashMap
        HashMap<Integer, Integer> sumFrequency = new HashMap<>();
        sumFrequency.put(0, 1); // To consider subarrays starting from index 0

        for (int num : nums) {
            sum += num;
            int diff = sum - K;

            if (sumFrequency.containsKey(diff)) {
                // If a cumulative sum (sum - K) exists in the HashMap,
                // it means there are subarrays with the desired sum
                count += sumFrequency.get(diff);
            }

            // Update the frequency of the current cumulative sum
            sumFrequency.put(sum, sumFrequency.getOrDefault(sum, 0) + 1);
        }

        return count;

    }


    //Largest Subarray of sum K
    static int lenOfLongSubArray(int A[], int N, int K) {
        int i = 0, j = 0, sum = 0;
        int maxLen = Integer.MIN_VALUE;

        while (j < N) {
            sum += A[j];
            if (sum < K) {
                j++;
            }
            else if (sum == K) {
                maxLen = Math.max(maxLen, j-i+1);
                j++;
            }
            else if (sum > K) {
                while (sum > K) {
                    sum -= A[i];
                    i++;
                }
                if(sum == K){
                    maxLen = Math.max(maxLen, j-i+1);
                }
                j++;
            }
        }
        return maxLen;
    }



    //Longest Substring Without repeating character
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

    //Minimum Window Substring

}
