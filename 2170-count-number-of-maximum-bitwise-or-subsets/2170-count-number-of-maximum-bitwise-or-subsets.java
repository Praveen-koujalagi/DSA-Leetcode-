class Solution {
    int max = 0, count = 0;

    public int countMaxOrSubsets(int[] nums) {
        // Step 1: Get the maximum OR possible
        for (int num : nums) {
            max |= num;
        }

        // Step 2: Backtrack to find all subsets
        dfs(nums, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int index, int currentOR) {
        if (index == nums.length) {
            if (currentOR == max) {
                count++;
            }
            return;
        }

        // Include nums[index]
        dfs(nums, index + 1, currentOR | nums[index]);

        // Exclude nums[index]
        dfs(nums, index + 1, currentOR);
    }
}
