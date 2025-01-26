package day25;

public class MinimizeTheMaximumOfTwoArrays {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long left = 1, right = (long)2e9;

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (canDistribute(mid, divisor1, divisor2, uniqueCnt1, uniqueCnt2)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return (int)left;
    }

    private boolean canDistribute(long maxVal, int div1, int div2, int cnt1, int cnt2) {
        long validForArr1 = maxVal - maxVal/div1;
        long validForArr2 = maxVal - maxVal/div2;

        long validBoth = maxVal - maxVal/lcm(div1, div2);

        return validForArr1 >= cnt1 &&
                validForArr2 >= cnt2 &&
                validBoth >= cnt1 + cnt2;
    }

    private long lcm(int a, int b) {
        return ((long)a * b) / gcd(a, b);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
