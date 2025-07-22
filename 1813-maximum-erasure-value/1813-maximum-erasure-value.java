class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int left = 0, right = 0;
        int sum = 0, maxSum = 0;

        while (right < nums.length) {
            if (!set.contains(nums[right])) {
                sum += nums[right];
                set.add(nums[right]);
                maxSum = Math.max(maxSum, sum);
                right++;
            } else {
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
        }

        return maxSum;
    }
}
