// import java.util.Arrays;

// class L_3116 {
//     public long findKthSmallest(int[] coins, int k) {
//         // Sort coins to prune unnecessary multiples early
//         Arrays.sort(coins);
        
//         int n = coins.length;
//         // Binary search bounds
//         long low = 1;
//         long high = (long) coins[0] * k;
//         long ans = high;

//         while (low <= high) {
//             long mid = low + (high - low) / 2;
            
//             if (countMultiples(mid, coins) >= k) {
//                 ans = mid;
//                 high = mid - 1; // Try to find a smaller valid value
//             } else {
//                 low = mid + 1;  // Not enough multiples, expand range
//             }
//         }

//         return ans;
//     }

//     // Counts how many distinct multiples of any coin in `coins` are <= target
//     private long countMultiples(long target, int[] coins) {
//         int n = coins.length;
//         long totalCount = 0;

//         // Iterate through all subsets using bitmasking (1 to 2^n - 1)
//         int numSubsets = 1 << n;
//         for (int mask = 1; mask < numSubsets; mask++) {
//             long currentLcm = 1;
//             int bitsCount = Integer.bitCount(mask);
//             boolean overflow = false;

//             for (int i = 0; i < n; i++) {
//                 if ((mask & (1 << i)) != 0) {
//                     currentLcm = lcm(currentLcm, coins[i]);
//                     // Avoid unnecessary processing if LCM exceeds target
//                     if (currentLcm > target) {
//                         overflow = true;
//                         break;
//                     }
//                 }
//             }

//             if (!overflow) {
//                 // Inclusion-Exclusion Principle
//                 if (bitsCount % 2 == 1) {
//                     totalCount += target / currentLcm;
//                 } else {
//                     totalCount -= target / currentLcm;
//                 }
//             }
//         }

//         return totalCount;
//     }

//     private long gcd(long a, long b) {
//         while (b != 0) {
//             long temp = b;
//             b = a % b;
//             a = temp;
//         }
//         return a;
//     }

//     private long lcm(long a, long b) {
//         return (a / gcd(a, b)) * b;
//     }
// }




import java.util.Arrays;

public class L_3116 {

    public long findKthSmallest(int[] coins, int k) {
        // Sort coins to prune unnecessary multiples early
        Arrays.sort(coins);
        
        int n = coins.length;
        // Binary search bounds
        long low = 1;
        long high = (long) coins[0] * k;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (countMultiples(mid, coins) >= k) {
                ans = mid;
                high = mid - 1; // Try to find a smaller valid value
            } else {
                low = mid + 1;  // Not enough multiples, expand range
            }
        }

        return ans;
    }

    // Counts how many distinct multiples of any coin in `coins` are <= target
    private long countMultiples(long target, int[] coins) {
        int n = coins.length;
        long totalCount = 0;

        // Iterate through all subsets using bitmasking (1 to 2^n - 1)
        int numSubsets = 1 << n;
        for (int mask = 1; mask < numSubsets; mask++) {
            long currentLcm = 1;
            int bitsCount = Integer.bitCount(mask);
            boolean overflow = false;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    currentLcm = lcm(currentLcm, coins[i]);
                    // Avoid unnecessary processing if LCM exceeds target
                    if (currentLcm > target) {
                        overflow = true;
                        break;
                    }
                }
            }

            if (!overflow) {
                // Inclusion-Exclusion Principle
                if (bitsCount % 2 == 1) {
                    totalCount += target / currentLcm;
                } else {
                    totalCount -= target / currentLcm;
                }
            }
        }

        return totalCount;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    public static void main(String[] args) {
        L_3116 solver = new L_3116();

        // Test Case 1
        int[] coins1 = {3, 6, 9};
        int k1 = 3;
        System.out.println("Test Case 1 Output: " + solver.findKthSmallest(coins1, k1)); // Expected: 9

        // Test Case 2
        int[] coins2 = {5, 2};
        int k2 = 7;
        System.out.println("Test Case 2 Output: " + solver.findKthSmallest(coins2, k2)); // Expected: 12
    }
}