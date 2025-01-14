package day13;

import java.util.Arrays;

public class FriendsOfAppropriateAges {


    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int res = 0;
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] <= 14) continue;

            int lowerBound = binarySearch(ages, 0.5 * ages[i] + 7);
            int upperBound = binarySearchUpper(ages, ages[i]);

            res += (upperBound - lowerBound);
            res -= 1;
        }
        return res;
    }

    private int binarySearch(int[] ages, double target) {
        int low = 0, high = ages.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (ages[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int binarySearchUpper(int[] ages, int target) {
        int low = 0, high = ages.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (ages[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
