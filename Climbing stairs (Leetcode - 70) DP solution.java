class Solution {
    public int climbStairs(int n) {
        if(n < 4) return n;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        for(int i=0; i<4; i++)
            dp[i] = i;
        return compute(n, dp);
        
    }

    private int compute(int n, int[] dp){
        if(n == 0) return 1;
        if(n<0) return 0;

        if(dp[n] != -1) return dp[n];
        
        return dp[n] = compute(n-1, dp) + compute(n-2, dp);
    }
}