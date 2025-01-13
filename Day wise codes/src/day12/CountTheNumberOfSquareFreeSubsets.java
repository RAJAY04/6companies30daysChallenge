package day12;

import java.util.Arrays;

public class CountTheNumberOfSquareFreeSubsets {
    public static void main(String[] args) {
        CountTheNumberOfSquareFreeSubsets obj = new CountTheNumberOfSquareFreeSubsets();
        int[] nums = { 2, 2, 2, 2, 2 };
        System.out.println(obj.squareFreeSubsets(nums));
    }

    static int MOD = (int) 1e9 + 7;

    public int squareFreeSubsets(int[] nums) {
        int[][] dp = new int[1001][1 << 11];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };

        int[] numsPrimeMask = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsPrimeMask[i] = computeMask(nums[i], primes);
        }

        return (dfs(0, 1, numsPrimeMask, dp) - 1 + MOD) % MOD;
    }

    public int dfs(int pos, int productMask, int[] numsPrimeMask, int[][] dp) {
        if (pos >= numsPrimeMask.length)
            return 1;

        if (dp[pos][productMask] != -1)
            return dp[pos][productMask];

        int take = 0, noTake = 0;
        noTake = dfs(pos + 1, productMask, numsPrimeMask, dp);

        if ((productMask & numsPrimeMask[pos]) == 0)
            take = dfs(pos + 1, productMask | numsPrimeMask[pos], numsPrimeMask, dp);

        return dp[pos][productMask] = (take + noTake) % MOD;
    }

    public int computeMask(int x, int[] primes) {
        int mask = 0;

        for (int i = 0; i < primes.length; i++) {
            int p = primes[i];

            int cnt = 0;
            while (x % p == 0) {
                x /= p;
                cnt++;
            }

            if (cnt == 0)
                continue;

            if (cnt == 1)
                mask |= (1 << (i + 1));

            if (cnt >= 2)
                return -1;
        }
        return mask;
    }
}
