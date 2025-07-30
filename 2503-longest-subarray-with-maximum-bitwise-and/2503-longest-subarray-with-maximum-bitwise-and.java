class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int maxLen = 0;
        int currLen = 0;

        for (int num : nums) {
            if (num == maxVal) {
                currLen++;
                maxLen = Math.max(maxLen, currLen);
            } else {
                currLen = 0;
            }
        }

        return maxLen;
    }
}
