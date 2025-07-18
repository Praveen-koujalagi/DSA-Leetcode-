class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        int len = nums.length;

        long[] left = new long[len];
        long[] right = new long[len];

        // Max heap for left n elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        long sumLeft = 0;
        for (int i = 0; i < 2 * n; i++) {
            sumLeft += nums[i];
            maxHeap.add(nums[i]);

            if (maxHeap.size() > n) {
                sumLeft -= maxHeap.poll(); // Remove largest
            }

            if (maxHeap.size() == n) {
                left[i] = sumLeft;
            } else {
                left[i] = Long.MAX_VALUE;
            }
        }

        // Min heap for right n elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sumRight = 0;
        for (int i = len - 1; i >= n; i--) {
            sumRight += nums[i];
            minHeap.add(nums[i]);

            if (minHeap.size() > n) {
                sumRight -= minHeap.poll(); // Remove smallest
            }

            if (minHeap.size() == n) {
                right[i] = sumRight;
            } else {
                right[i] = Long.MIN_VALUE;
            }
        }

        // Now find the minimum difference
        long res = Long.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++) {
            if (left[i] != Long.MAX_VALUE && right[i + 1] != Long.MIN_VALUE) {
                res = Math.min(res, left[i] - right[i + 1]);
            }
        }

        return res;
    }
}
