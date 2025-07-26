class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        List<Integer>[] conflicts = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            conflicts[i] = new ArrayList<>();
        }

        for (int[] pair : conflictingPairs) {
            int a = Math.min(pair[0], pair[1]);
            int b = Math.max(pair[0], pair[1]);
            conflicts[b].add(a);
        }
        
        long[] gain = new long[n + 1];
        long totalValid = 0;
        int maxLeft = 0, secondMax = 0;  
        
        for (int right = 1; right <= n; right++) {
            for (int left : conflicts[right]) {
                if (left > maxLeft) {
                    secondMax = maxLeft;
                    maxLeft = left;
                } else if (left > secondMax) {
                    secondMax = left;
                }
            }
            
            totalValid += right - maxLeft;
            
            if (maxLeft > 0) {
                gain[maxLeft] += maxLeft - secondMax;
            }
        }
        
        long maxGain = 0;
        for (long g : gain) {
            if (g > maxGain) {
                maxGain = g;
            }
        }
        
        return totalValid + maxGain;
    }
}