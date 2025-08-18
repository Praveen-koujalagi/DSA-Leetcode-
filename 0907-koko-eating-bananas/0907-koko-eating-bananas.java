class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long hours = 0;

            // Calculate hours needed at speed = mid
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;  // ceil(pile / mid)
            }

            if (hours <= h) {
                result = mid; // possible, try smaller
                right = mid - 1;
            } else {
                left = mid + 1; // too slow
            }
        }

        return result;
    }
}
