class Solution {
    public int minOperations(int[] nums) {
	int ops = 0;

	for (int bit = 0; bit < 32; bit++) {
		boolean nonzero = false;

		for (int i = 0; i < nums.length; i++) {
			ops += nums[i] % 2;
			nums[i] /= 2;
			nonzero |= nums[i] > 0;
		}

		if (nonzero) ops++; else break;
	}

	return ops;
}
}