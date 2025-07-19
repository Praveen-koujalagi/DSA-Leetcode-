class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] years = new int[101]; // Representing years from 1950 to 2050

        for (int[] log : logs) {
            years[log[0] - 1950]++;   // Person born → increase population
            years[log[1] - 1950]--;   // Person died → decrease population
        }

        int maxPopulation = 0;
        int maxYear = 1950;
        int currPopulation = 0;

        for (int i = 0; i < 101; i++) {
            currPopulation += years[i];
            if (currPopulation > maxPopulation) {
                maxPopulation = currPopulation;
                maxYear = 1950 + i;
            }
        }

        return maxYear;
    }
}
