class Solution {
    public boolean canPartition(int[] nums) {
        int totalsum = 0;

        // Calculate the total sum of the array
        for (int i = 0; i < nums.length; i++) {
            totalsum += nums[i];
        }

        // If the total sum is odd, we cannot divide it into two equal subsets
        if (totalsum % 2 != 0) {
            return false;
        }

        int target = totalsum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // We can always make sum 0 using an empty subset

        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }

        return dp[target];
    }
}
