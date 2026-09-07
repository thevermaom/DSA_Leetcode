class L_940 {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        
        // lastCount[c] stores the number of distinct subsequences ending with character c
        long[] lastCount = new long[26];
        long totalCount = 0; // Total distinct subsequences seen so far
        
        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            
            // New distinct subsequences formed by appending 'ch':
            // 1. Appending 'ch' to all existing subsequences: totalCount
            // 2. The single character subsequence "ch": +1
            long newSubseqs = (totalCount + 1) % MOD;
            
            // Update the global total count by adding new ones and removing 
            // previously counted subsequences ending with the same character
            totalCount = (totalCount + newSubseqs - lastCount[idx] + MOD) % MOD;
            
            // Record the total subsequences that now end with this character
            lastCount[idx] = newSubseqs;
        }
        
        return (int) totalCount;
    }
}