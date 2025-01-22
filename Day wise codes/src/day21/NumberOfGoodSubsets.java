package day21;

import java.util.*;

public class NumberOfGoodSubsets {
    private static final int MOD = 1_000_000_007;
    private static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    private Map<String, Long> memo;
    private int[] frequency;
    private List<Integer> validNums;

    public int numberOfGoodSubsets(int[] nums) {
        frequency = new int[31];
        for (int num : nums) {
            frequency[num]++;
        }
        validNums = getValidNumbers();
        memo = new HashMap<>();
        long result = calculateSubsets(0, 0);
        if (frequency[1] > 0) {
            result = (result * modularExponentiation(2, frequency[1])) % MOD;
        }

        return (int) result;
    }

    /**
     * Recursive function to calculate number of valid subsets using memoization.
     * @param index Current position in validNums list
     * @param mask Binary representation of used prime factors
     * @return Number of valid subsets possible from current state
     */
    private long calculateSubsets(int index, int mask) {
        // Base case: reached end of valid numbers list
        if (index == validNums.size()) {
            return (mask == 0) ? 0 : 1;
        }

        // Check if result already calculated
        String key = index + "," + mask;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Initialize result with case where we don't use current number
        long result = calculateSubsets(index + 1, mask);

        // Get current number and its prime factor mask
        int currentNum = validNums.get(index);
        int currentMask = getPrimeMask(currentNum);

        // Try to include current number if prime factors don't overlap
        if ((currentMask & mask) == 0) {
            result = (result + (frequency[currentNum] *
                    calculateSubsets(index + 1, mask | currentMask)) % MOD) % MOD;
        }

        // Store result in memo map and return
        memo.put(key, result);
        return result;
    }

    /**
     * Creates list of valid numbers that can be used in good subsets.
     * @return List of numbers that have no repeated prime factors
     */
    private List<Integer> getValidNumbers() {
        List<Integer> valid = new ArrayList<>();
        Set<Integer> invalid = new HashSet<>(Arrays.asList(
                4,   // 2²
                8,   // 2³
                9,   // 3²
                12,  // 2² × 3
                16,  // 2⁴
                18,  // 2 × 3²
                20,  // 2² × 5
                24,  // 2³ × 3
                25,  // 5²
                27,  // 3³
                28   // 2² × 7
        ));

        for (int num = 2; num <= 30; num++) {
            if (!invalid.contains(num) && isValid(num)) {
                valid.add(num);
            }
        }
        return valid;
    }

    /**
     * Checks if a number has no repeated prime factors.
     * @param num Number to check
     * @return true if number has no repeated prime factors
     */
    private boolean isValid(int num) {
        int temp = num;  // Work with copy of input
        for (int prime : PRIMES) {
            int count = 0;
            while ((temp % prime) == 0) {
                count++;
                temp /= prime;
                if (count > 1) return false;
            }
        }
        return temp == 1;
    }

    /**
     * Creates binary mask representing prime factors of a number.
     * @param num Number to create mask for
     * @return Binary mask where each bit represents a prime factor
     */
    private int getPrimeMask(int num) {
        int mask = 0;
        for (int i = 0; i < PRIMES.length; i++) {
            if ((num % PRIMES[i]) == 0) {
                mask |= (1 << i);
            }
        }
        return mask;
    }

    /**
     * Calculates (base^pow) % MOD efficiently.
     * @param base Base number
     * @param pow Power to raise base to
     * @return Result of modular exponentiation
     */
    private long modularExponentiation(long base, long pow) {
        long result = 1;
        base = base % MOD;
        while (pow > 0) {
            if ((pow & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            pow >>= 1;
        }
        return result;
    }



    public int numberOfGoodSubsets1(int[] nums) {
        // Same initialization as before
        frequency = new int[31];
        for (int num : nums) {
            frequency[num]++;
        }
        validNums = getValidNumbers();

        // Key change: Create our dp table
        // First dimension: index into validNums (0 to validNums.size())
        // Second dimension: mask of prime factors used (0 to 2^10 since we have 10 primes)
        long[][] dp = new long[validNums.size() + 1][1 << PRIMES.length];

        // Base case: empty mask but used some number = 1 valid subset
        for (int mask = 1; mask < (1 << PRIMES.length); mask++) {
            dp[validNums.size()][mask] = 1;
        }

        // Work backwards from the end
        for (int index = validNums.size() - 1; index >= 0; index--) {
            int currentNum = validNums.get(index);
            int currentMask = getPrimeMask(currentNum);

            for (int mask = 0; mask < (1 << PRIMES.length); mask++) {
                // Don't use current number
                dp[index][mask] = dp[index + 1][mask];

                // Try to use current number if prime factors don't overlap
                if ((currentMask & mask) == 0) {
                    dp[index][mask] = (dp[index][mask] +
                            (frequency[currentNum] * dp[index + 1][mask | currentMask]) % MOD) % MOD;
                }
            }
        }

        // Handle ones separately, just like before
        long result = dp[0][0];
        if (frequency[1] > 0) {
            result = (result * modularExponentiation(2, frequency[1])) % MOD;
        }

        return (int) result;
    }



}
