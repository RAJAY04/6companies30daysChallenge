package day23;

public class MinimumNonZeroProductOfTheArrayElements {
    public static void main(String[] args) {
        MinimumNonZeroProductOfTheArrayElements obj = new MinimumNonZeroProductOfTheArrayElements();
        int p = 3;
        System.out.println(obj.minNonZeroProduct(p));
    }

    public final static int MOD = 1_000_000_007;

    public int minNonZeroProduct(int p) {
        if (p == 1) return 1;
        long maxNum = ((1L << p) - 1);
        long power = pow(maxNum - 1, (maxNum - 1L) / 2);
        return (int) ((maxNum % MOD * power % MOD) % MOD);
    }

    public long pow(long base, long power) {
        base %= MOD;
        long ans = 1;
        while (power > 0) {
            if ((power & 1) == 1) {
                ans = (ans * base) % MOD;
            }
            base = (base * base) % MOD;
            power >>= 1;
        }
        return ans;
    }
}
