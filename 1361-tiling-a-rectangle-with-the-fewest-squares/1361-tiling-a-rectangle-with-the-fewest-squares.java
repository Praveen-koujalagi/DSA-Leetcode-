class Solution {
    private int ans = Integer.MAX_VALUE;

    public int tilingRectangle(int n, int m) {
        if (n == m) return 1;
        dfs(new int[m], n, 0);
        return ans;
    }

    private void dfs(int[] heights, int n, int count) {
        if (count >= ans) return;

        boolean full = true;
        for (int h : heights) {
            if (h != n) {
                full = false;
                break;
            }
        }
        if (full) {
            ans = count;
            return;
        }

        int minH = Integer.MAX_VALUE, idx = -1;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] < minH) {
                minH = heights[i];
                idx = i;
            }
        }

        int right = idx;
        while (right < heights.length && heights[right] == minH) right++;
        int maxSize = Math.min(right - idx, n - minH);

        for (int size = maxSize; size >= 1; size--) {
            int[] newHeights = heights.clone();
            for (int k = idx; k < idx + size; k++) {
                newHeights[k] += size;
            }
            dfs(newHeights, n, count + 1);
        }
    }
}
