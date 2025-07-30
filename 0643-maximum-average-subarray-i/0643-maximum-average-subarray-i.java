class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;

        for(int i = 0; i < k; i++){
            sum += nums[i];
        }

        int maxSum = sum;

        // Slide the window
        for(int i = k; i < n; i++){
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }
}
