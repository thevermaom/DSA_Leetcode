class L_1872 {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        
        // Compute prefix sums in-place or using long values to prevent overflow
        long[] prefixSum = new long[n];
        prefixSum[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i];
        }
        
        // Base case: If the player is forced to take all stones,
        // the score difference is simply the sum of all elements.
        long maxScoreDiff = prefixSum[n - 1];
        
        // Iterate backwards from the second-to-last possible move down to index 1 (at least 2 stones taken)
        for (int i = n - 2; i >= 1; i--) {
            maxScoreDiff = Math.max(maxScoreDiff, prefixSum[i] - maxScoreDiff);
        }
        
        return (int) maxScoreDiff;
    }
}