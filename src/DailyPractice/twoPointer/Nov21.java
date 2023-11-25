package DailyPractice.twoPointer;

import java.util.*;

import static DailyPractice.twoPointer.MyClass.i;

public class Nov21 {

    public static void main(String[] args) {
//        int[] arr= {1,8,6,2,5,4,8,3,7};
//        System.out.println(maxArea(arr));

    }

    //167. Two Sum II - Input Array Is Sorted
    /**
     * Example 1:
     *
     * Input: numbers = [2,7,11,15], target = 9
     * Output: [1,2]
     * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
     * Example 2:
     *
     * Input: numbers = [2,3,4], target = 6
     * Output: [1,3]
     * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
     *
     * use a pointer on 0 from begin and another n-1 from end.
     * move the pointer from beginning and another pointer from the end
     * and start computing these two index elements
     * if it's not equal then proceed further
     * if(sum<target)start++
     * if(sum>target)end--
     *
     */
    public int[] twoSum(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (nums[start] + nums[end] != target) {
            if (nums[start] + nums[end] < target){
                start++;
            }else{
                end--;
            }
        }
        return new int[] {start+1, end+1};
    }

    //15. 3Sum
    /**
     * Example 1:
     *
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     * Explanation:
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
     * The distinct triplets are [-1,0,1] and [-1,-1,2].
     * Notice that the order of the output and the order of the triplets does not matter.
     * Example 2:
     *
     * Input: nums = [0,1,1]
     * Output: []
     * Explanation: The only possible triplet does not sum up to 0.
     *
     *
     * first sort all the elements of the array
     * use 3 pointers
     * first pointer from the for loop (i)
     * if(arr[i] == arr[i-1]) => then continue
     * then take  left = i+1
     * then take right =n-1
     * until left < right
     * sum = arr[i]+arr[left]+arr[right]
     * if sum == target then add into the list
     * if(arr[left]==arr[left+1]) => left++
     * if(arr[right]==arr[right-1]) => right--
     *
     * if(sum<0) => left++
     * if(sum>0) => right--
     *
     *
     *
     *
     */

    public List<List<Integer>> threeSum(int[] num) {
        if (num==null || num.length<3){
            return new ArrayList<>();
        }
        Arrays.sort(num);

        Set<List<Integer>> result = new HashSet<>();

        //fix the first element and find the other 2 elements
        for (int i=0; i<num.length-2; i++){
            if (i>0 && num[i]==num[i-1]){
                continue;
            }

            int left = i+1;
            int right = num.length-1;

            while (left<right){
                int sum= num[i] + num[left] + num[right];

                if (sum==0){
                    result.add(Arrays.asList(num[i],num[left],num[right]));

                    while (left<right && num[left]==num[left+1]){
                        left++;
                    }
                    while (left<right && num[right]==num[right-1]){
                        right--;
                    }

                    left++;
                    right--;
                }else if(sum<0){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return new ArrayList<>(result);
    }

    //18. 4Sum
    /**
     * Example 1:
     *
     * Input: nums = [1,0,-1,0,-2,2], target = 0
     * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     * Example 2:
     *
     * Input: nums = [2,2,2,2,2], target = 8
     * Output: [[2,2,2,2]]
     *
     * use 4 pointers to solve the problem
     * start with 1 for loop i. if(arr[i]==arr[i-1]) => continue
     * another for loop j=i+1. if(arr[j]==arr[j-1]) => continue
     * use another 2 pointers
     * k=j+1
     * l=n-1
     * until(k<l)
     * sum = arr[i]+arr[j]+arr[k]+arr[l];
     * if(sum ==target) then add it to the list
     * if(arr[k]==arr[k-1]) => k++
     * if(arr[l]==arr[l+1]) => l--
     *
     * if(sum<target) => k++
     * if(sum>target) => l--
     *
     *
     *
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if (n<4){
            return ans;
        }
        Arrays.sort(nums);
        // calculating the quadruplets:
        for (int i = 0; i < n; i++) {
            // avoid the duplicates while moving i:
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                // avoid the duplicates while moving j:
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                // 2 pointers:
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = nums[i]+nums[j]+nums[k]+nums[l];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        k++;
                        l--;
                        // skip the duplicates:
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) k++;
                    else l--;
                }
            }
        }
        return ans;
    }

    //633. Sum of Square Numbers
    /**
     * Example 1:
     * Input: c = 5
     * Output: true
     * Explanation: 1 * 1 + 2 * 2 = 5
     *
     * Example 2:
     * Input: c = 3
     * Output: false
     *
     * use 2 pointers
     * left =0, right =Math.sqrt(number)
     * until left <=right
     * sum = left*left + right*right
     * if(sum ==number) => return true
     * if(sum<number) => left++
     * if(sum > right) => right--
     *
     */
    public boolean judgeSquareSum(int c) {
        long left = 0, right = (long) Math.sqrt(c);
        while (left <= right) {
            long cur = left * left + right * right;
            if (cur < c) {
                left++;
            } else if (cur > c) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }

    //881. Boats to Save People
    /**
     * Example 1:
     *
     * Input: people = [1,2], limit = 3
     * Output: 1
     * Explanation: 1 boat (1, 2)
     * Example 2:
     *
     * Input: people = [3,2,2,1], limit = 3
     * Output: 3
     * Explanation: 3 boats (1, 2), (2) and (3)
     * Example 3:
     *
     * Input: people = [3,5,3,4], limit = 5
     * Output: 4
     * Explanation: 4 boats (3), (3), (4), (5)
     *
     *
     */
    public int numRescueBoats(int[] people, int limit) {
        int boatCount = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        while(left <= right){
            int sum = people[left] + people[right];
            if(sum <= limit){
                left++;
            }
            right--;
            boatCount++;
        }
        return boatCount;
    }

    //1877. Minimize Maximum Pair Sum in Array
    /**
     * Example 1:
     *
     * Input: nums = [3,5,2,3]
     * Output: 7
     * Explanation: The elements can be paired up into pairs (3,3) and (5,2).
     * The maximum pair sum is max(3+3, 5+2) = max(6, 7) = 7.
     * Example 2:
     *
     * Input: nums = [3,5,4,2,4,6]
     * Output: 8
     * Explanation: The elements can be paired up into pairs (3,5), (4,4), and (6,2).
     * The maximum pair sum is max(3+5, 4+4, 6+2) = max(8, 8, 8) = 8.
     */
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        int i = 0;
        int j = nums.length - 1;
        while(i < j){
            max = Math.max(max, (nums[i++] + nums[j--]));
        }
        return max;
    }

    //923. 3Sum With Multiplicity
    public int threeSumMulti(int[] arr, int target) {
        long result = 0;
        long count[] = new long[101];
        long mod = 1000000007;

        //Couting the occurrence of each number
        for(int i: arr) count[i]++;

        for(int i=0;i<101;i++){
            for(int j=i;j<101;j++){
                int k = target - i -j;
                if(k<0 || k>100)
                    continue;
                // if all number are same than use nC3
                if(i==j && j==k){
                    result += (count[i]*(count[i]-1)*(count[i]-2))/6;
                }

                //if first two are same than use nC2 * occurence of k
                else if(i==j && j!=k){
                    result += ((count[i]*(count[i]-1))/2)*count[k];
                }
                //Last condition if all number ar different
                else if(i<j && j<k){
                    result += (count[i]*count[j]*count[k]);
                }
                result %= mod;
            }
        }
        return (int)result;
    }

    //42. Trapping Rain Water
    /**
     * Example 1:
     *
     * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
     *
     * Example 2:
     *
     * Input: height = [4,2,0,3,2,5]
     * Output: 9
     *
     * iterate from left and calculate the maximum between height[i],leftMax[i-1]
     * iterate from right and calculate the maximum between height[i],rightMax[i+1]
     * then compare between leftMax and rightMax and calculate the min = waterLevel
     * then trapWater += waterLevel - height[i]
     *
     */
    public int trap(int[] height) {
        int n=height.length;

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i=1; i<n; i++){
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n-1]=height[n-1];
        for (int i=n-2;i>=0; i--){
            rightMax[i]=Math.max(rightMax[i+1],height[i]);
        }

        int trapWater = 0;
        for (int i=0; i<n; i++){
            int waterLevel =Math.min(leftMax[i],rightMax[i]);
            trapWater += waterLevel-height[i];
        }

        return trapWater;
    }

    //11. Container With Most Water

    /**
     *Example 1:
     * Input: height = [1,8,6,2,5,4,8,3,7]
     * Output: 49
     * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
     *
     * Example 2:
     * Input: height = [1,1]
     * Output: 1
     *
     * left =0, right = array length-1
     * until left < right
     *
     *
     *
     */

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while(left < right){
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            int area = h * w;
            max = Math.max(max, area);
            if(height[left] < height[right]) left++;
            else if(height[left] > height[right]) right--;
            else {
                left++;
                right--;
            }
        }
        return max;
    }

    //31. Next Permutation
    /**
     * Example 1:
     *
     * Input: nums = [1,2,3]
     * Output: [1,3,2]
     * Example 2:
     *
     * Input: nums = [3,2,1]
     * Output: [1,2,3]
     * Example 3:
     *
     * Input: nums = [1,1,5]
     * Output: [1,5,1]
     *
     * iterate from num.length-1 to 0 and check which element is greater
     * if num[i] < num[i+1]
     * take that index =idx1
     *
     * if didn't find the index then reverse whole array
     *
     * then find the next greater element which is greater than num[idx1] from end
     * num[idx1]<num[i]
     * i=idx2
     *
     * swap the element between indices in array
     * swap(num[idx1], num[idx2])
     *
     * then reverse the elements in right half
     *
     * -> 1 5 8 5 7 6 4 3 1
     * -> 5 is the first element and idx1=3
     * -> 6 is the next greater element which is grater then 5 and idx2=5
     * -> after swapping
     * -> 1 5 8 6 7 5 4 3 1
     * -> reverse the right half from idx1+1=4 to num.length-1
     * -> 1 5 8 6 1 3 4 5 7
     *
     */
    // 1 5 8 5 7 6 4 3 1
    public void nextPermutation(int[] nums) {
        int idx1 = -1;
        int idx2 = -1;

        for(int i= nums.length-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                idx1=i;
                break;
            }
        }
        if(idx1==-1){
            reverse(nums,0);
        }else{
            for(int i=nums.length-1; i>=0; i--){
                if(nums[i]>nums[idx1]){
                    idx2=i;
                    break;
                }
            }
            swap(nums, idx1, idx2);
            reverse(nums, idx1+1);
        }
    }

    private static void reverse(int[] nums, int start){
        int length = nums.length-1;
        while(start<length){
            swap(nums, start,length);
            start++;
            length--;
        }
    }
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //556. Next Greater Element III

    /**
     *
     * same as next permutation but need to convert number to array of integer
     */
    public int nextGreaterElement(int n) {
        //Converting integer to an array of digits
        String s = Integer.toString(n);
        int arr[] = new int[s.length()];
        for(int i=0;i<s.length();i++){
            arr[i] = s.charAt(i) - '0';
        }

        //Finding the first decreasing element(i-1) from behind
        int i = arr.length - 1;
        while(i > 0 && arr[i-1] >= arr[i]){
            i--;
        }
        //If no element is decreasing and the array is all increasing from behind then return -1 as no solution possible
        if(i-1 < 0) return -1;

        //Finding the next bigger element(j) than (i-1) from behind
        int j = arr.length-1;
        while(j > (i-1) && arr[j] <= arr[i-1]){
            j--;
        }

        //Swap the elements
        swap(arr, i-1, j);
        //Reverse the array from i to end
        reverse(arr, i);

        //Convert the array to an integer but make sure to check that if does not exceed the 32 bit integer as mentioned in the question
        int ans = 0;
        for(i=0;i<arr.length;i++){
            if(ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && arr[i] > 7))
                return -1;
            if(ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && arr[i] < -8))
                return -1;
            ans = ans * 10 + arr[i];
        }
        //If the same integer is formed then return -1
        return ans == n ? -1 : ans;
    }


    //125. Valid Palindrome
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while(start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);
            if (!Character.isLetterOrDigit(currFirst )) {
                start++;
            } else if(!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }

    //344. Reverse String
    public void reverseString(char[] s) {

        int start = 0, end = s.length - 1;
        while(start < end) {
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }

    //345. Reverse Vowels of a String
    public String reverseVowels(String s) {
        if(s == null || s.length()==0) return s;
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length()-1;
        while(start<end){

            while(start<end && !vowels.contains(chars[start]+"")){
                start++;
            }

            while(start<end && !vowels.contains(chars[end]+"")){
                end--;
            }

            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
        return new String(chars);
    }


    //680. Valid Palindrome II
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while(i <= j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
        }
        return true;
    }
    public boolean isPalindrome(String s, int i, int j){
        while(i <= j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else return false;
        }
        return true;
    }

    //917. Reverse Only Letters
    public String reverseOnlyLetters(String s) {
        char temp[] = s.toCharArray();
        int low = 0 , high = s.length()-1;
        while(low < high){
            if(Character.isAlphabetic(temp[low]) && Character.isAlphabetic(temp[high]))
            {
                char i = temp[low];
                temp[low] = temp[high];
                temp[high] = i;
                low++;
                high--;
            }else if(!Character.isAlphabetic(temp[low]))  low++;
            else if(!Character.isAlphabetic(temp[high]))  high--;
        }
        return String.valueOf(temp);
    }

    //27. Remove Element





}
