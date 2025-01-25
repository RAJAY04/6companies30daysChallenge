package day24;

import java.util.Arrays;

public class NumberOfWaysToReachAPositionAfterExactlyKSteps {
    public static void main(String[] args) {
        NumberOfWaysToReachAPositionAfterExactlyKSteps obj = new NumberOfWaysToReachAPositionAfterExactlyKSteps();
        int startPos = 1;
        int endPos = 3;
        int k = 3;
        System.out.println(obj.numberOfWays(startPos,endPos,k));
    }

    static int MOD = 1_000_000_007;
    public int numberOfWays(int startPos, int endPos, int k) {
        int[][] dp = new int[3001][1001];
        for(int[] d : dp) Arrays.fill(d,-1);
        return memo(startPos + 1000, endPos + 1000, k, dp);
    }

    public static int memo(int p, int ep, int k, int[][] dp){
        if(k == 0 && p == ep) return 1;
        if(k == 0) return 0;
        if(Math.abs(p - ep) > k)return 0;

        if(dp[p][k] != -1) return dp[p][k];

        int left = memo(p - 1, ep, k - 1, dp);
        int right = memo(p + 1, ep, k - 1, dp);

        return dp[p][k] = (left + right) % MOD;
    }
}
