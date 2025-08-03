class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int fruit : basket1) {
            freq.put(fruit, freq.getOrDefault(fruit, 0) + 1);
        }
        for (int fruit : basket2) {
            freq.put(fruit, freq.getOrDefault(fruit, 0) - 1);
        }

        List<Integer> toSwap = new ArrayList<>();
        for (int fruit : freq.keySet()) {
            int count = freq.get(fruit);
            if (count % 2 != 0) return -1;  // Odd freq → impossible
            for (int i = 0; i < Math.abs(count) / 2; i++) {
                toSwap.add(fruit);
            }
        }

        Collections.sort(toSwap); // Greedy swap with smallest values
        long minFruit = freq.firstKey();
        long cost = 0;
        for (int i = 0; i < toSwap.size() / 2; i++) {
            cost += Math.min(toSwap.get(i), 2 * minFruit);
        }
        return cost;
    }
}
