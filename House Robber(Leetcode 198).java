/*/ Solution - DP Based */
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return compute(nums, 0, dp);
    }

    private int compute(int[] nums, int index, int[] dp) {
        if (index >= nums.length)
            return 0;
        if (dp[index] != -1)
            return dp[index];
        int include = nums[index] + compute(nums, index + 2, dp);
        int notInclude = compute(nums, index + 1, dp);
        return dp[index] = Math.max(include, notInclude);
    }
}

/* Solution - Tabulation */

class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            int take = nums[i];
            if(i > 1)
                take += dp[i-2];
            int nontake = dp[i-1];
            dp[i] = Math.max(take, nontake);  
        }
        return dp[nums.length-1];
        
    }
}

/* Solution - Tabulation + Space optimized */

class Solution {
    public int rob(int[] nums) {
        int last = 0;
        int secondLast = nums[0];
        for(int i=1; i<nums.length; i++){
            int take = nums[i];
            if(i > 1)
                take += last;
            int nontake = secondLast;
            int curr = Math.max(take, nontake);  
            last = secondLast;
            secondLast = curr;
        }
        return secondLast;
        
    }
}
