package greedy;

public class Overview {
    //jump game
    public boolean canJump(int[] nums) {
        int finalPosition =nums.length-1; // initial final position

        //start with the second last position
        for (int idx = nums.length-2; idx>=0; idx--){
            //if you reach the final position from this index
            //update the final position flag
            if (idx+nums[idx] >=finalPosition){
                finalPosition=idx;
            }
        }
        //if we reach the first position
        //make jump possible
        return finalPosition==0;
    }

    //jump game 2
    public int jump(int[] nums) {
        int totalJump=0;
        int destination = nums.length-1;
        int coverage=0;
        int lastJumpIdx=0;

        if (nums.length==1){
            return 0;
        }
        for (int i=0; i<nums.length; i++){
            coverage= Math.max(coverage, i+nums[i]);
            if (i==lastJumpIdx){
                lastJumpIdx=coverage;
                totalJump++;
                if (coverage>=destination){
                    return totalJump;
                }
            }

        }
        return totalJump;
    }
}
