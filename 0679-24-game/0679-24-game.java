class Solution {
    private static final double TARGET = 24.0;
    private static final double EPSILON = 1e-6; // tolerance for floating point comparison

    public boolean judgePoint24(int[] cards) {
        // Convert int[] to List<Double> for calculations
        List<Double> nums = new ArrayList<>();
        for (int card : cards) {
            nums.add((double) card);
        }
        return solve(nums);
    }

    private boolean solve(List<Double> nums) {
        // Base case: if only one number is left, check if it's 24
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - TARGET) < EPSILON;
        }

        // Try every pair of numbers
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i == j) continue;

                // Create a new list without nums[i] and nums[j]
                List<Double> next = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) {
                        next.add(nums.get(k));
                    }
                }

                // Try all 4 operations
                for (double result : compute(nums.get(i), nums.get(j))) {
                    next.add(result);
                    if (solve(next)) return true;
                    next.remove(next.size() - 1); // backtrack
                }
            }
        }
        return false;
    }

    // Return all possible results of applying an operator to a and b
    private List<Double> compute(double a, double b) {
        List<Double> results = new ArrayList<>();
        results.add(a + b);
        results.add(a - b);
        results.add(b - a);
        results.add(a * b);
        if (Math.abs(b) > EPSILON) results.add(a / b);
        if (Math.abs(a) > EPSILON) results.add(b / a);
        return results;
    }
}
