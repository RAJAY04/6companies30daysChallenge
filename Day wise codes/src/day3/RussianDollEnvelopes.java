package day3;

import java.util.Arrays;

public class RussianDollEnvelopes
{
    //couldnt pass last 2 test case need to upsolve with binary serch + dp
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(b[1], a[1]);
            }
        });

        int[][] dp = new int[envelopes.length][envelopes.length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return memo(envelopes, 0, -1, dp);
    }

    private int memo(int[][] envelopes, int index, int prevIndex, int[][] dp) {
        if (index == envelopes.length) {
            return 0;
        }

        if (dp[index][prevIndex + 1] != -1) {
            return dp[index][prevIndex + 1];
        }

        int noPick = memo(envelopes, index + 1, prevIndex, dp);

        int pick = 0;
        if (prevIndex == -1 ||
                (envelopes[prevIndex][0] < envelopes[index][0] &&
                        envelopes[prevIndex][1] < envelopes[index][1])) {
            pick = 1 + memo(envelopes, index + 1, index, dp);
        }

        return dp[index][prevIndex + 1] = Math.max(pick, noPick);
    }
}
