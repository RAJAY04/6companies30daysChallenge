package day29;

import java.util.ArrayList;
import java.util.List;

public class FindBeautifulIndicesInTheGivenArrayI {
    public static void main(String[] args) {
        FindBeautifulIndicesInTheGivenArrayI obj = new FindBeautifulIndicesInTheGivenArrayI();
        System.out.println(obj.beautifulIndices("abcabc", "abc", "abc", 1));
    }


    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> aPositions = findPattern(s, a);
        List<Integer> bPositions = findPattern(s, b);
        List<Integer> result = new ArrayList<>();

        if (aPositions.isEmpty() || bPositions.isEmpty()) {
            return result;
        }

        for (int aPos : aPositions) {
            int index = binarySearch(bPositions, aPos - k);
            if (index < bPositions.size() && bPositions.get(index) <= aPos + k) {
                result.add(aPos);
            }
        }

        return result;
    }

    private int binarySearch(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private List<Integer> findPattern(String s, String pattern) {
        List<Integer> positions = new ArrayList<>();
        if (s.length() < pattern.length()) return positions;

        String combined = pattern + "#" + s;
        int[] lps = kmp(combined);

        for (int i = pattern.length() + 1; i < combined.length(); i++) {
            if (lps[i] == pattern.length()) {
                positions.add(i - 2 * pattern.length());
            }
        }

        return positions;
    }

    public static int[] kmp(String s) {
        int n = s.length();
        int[] lps = new int[n];
        for (int i = 1; i < n; i++) {
            int prev_index = lps[i - 1];
            while (prev_index > 0 && s.charAt(prev_index) != s.charAt(i)) {
                prev_index = lps[prev_index - 1];
            }
            lps[i] = prev_index + ((s.charAt(i) == s.charAt(prev_index)) ? 1 : 0);
        }
        return lps;
    }
}
