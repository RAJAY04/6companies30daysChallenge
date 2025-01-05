package day4;

import java.util.HashMap;
import java.util.Map;

public class MaximumProductoftheLengthofTwoPalindromicSubsequences {
    public static void main(String[] args) {
        String s = "leetcodecom";
        System.out.println(new MaximumProductoftheLengthofTwoPalindromicSubsequences().maxProduct(s));
    }
    public int maxProduct(String s) {
        int n = s.length();
        Map<Integer, Integer> map = new HashMap<>();

        for (int mask = 1; mask < (1 << n); mask++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sb.append(s.charAt(i));
                }
            }

            String subsequence = sb.toString();
            if (isPalindrome(subsequence)) {
                map.put(mask, subsequence.length());
            }
        }

        int maxProduct = 0;
        for (Map.Entry<Integer, Integer> entry1 : map.entrySet()) {
            for (Map.Entry<Integer, Integer> entry2 : map.entrySet()) {
                if ((entry1.getKey() & entry2.getKey()) == 0) {
                    maxProduct = Math.max(maxProduct,
                            entry1.getValue() * entry2.getValue());
                }
            }
        }

        return maxProduct;
    }

    private boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
