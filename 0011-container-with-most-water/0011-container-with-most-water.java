class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int area = width * h;
            maxWater = Math.max(maxWater, area);

            // Move the shorter height pointer inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--; 
            }
        }

        return maxWater;
    }
}
