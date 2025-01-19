package day18;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
    public static void main(String[] args) {
        RussianDollEnvelopes obj = new RussianDollEnvelopes();
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        System.out.println(obj.maxEnvelopes(envelopes));
    }
    public int maxEnvelopes(int[][] envelopes) {

        Comparator<int[]> comparator = (a, b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        };
        Arrays.sort(envelopes, comparator);

        int[] dp = new int[envelopes.length];
        int length = 0;

        for(int[] envelope : envelopes) {
            int index = lowerBound(dp, envelope[1], length);
            dp[index] = envelope[1];

            if(index == length) length++;
        }

        return length;
    }

    public int lowerBound(int[] arr, int target, int right) {
        int left = 0;

        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
