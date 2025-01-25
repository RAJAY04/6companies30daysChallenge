package day24;

public class NumberOfPeopleAwareOfASecret {
    public static void main(String[] args) {
        NumberOfPeopleAwareOfASecret obj = new NumberOfPeopleAwareOfASecret();
        int n = 10;
        int delay = 1;
        int forget = 1;
        System.out.println(obj.peopleAwareOfSecret(n, delay, forget));
    }

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[1] = 1;

        long sharePeople = 0;
        long totalPeople = 1;

        for (int day = 2; day <= n; day++) {
            if (day - delay >= 1) {
                sharePeople += dp[day - delay];
            }

            if (day - forget >= 1) {
                sharePeople -= dp[day - forget];
            }

            sharePeople = (sharePeople + MOD) % MOD;

            dp[day] = sharePeople;

            totalPeople += dp[day];
            totalPeople -= (day - forget >= 1) ? dp[day - forget] : 0;

            totalPeople = (totalPeople + MOD) % MOD;
        }

        return (int)totalPeople;
    }
}
