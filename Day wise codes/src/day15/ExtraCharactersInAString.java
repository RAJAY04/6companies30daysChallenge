package day15;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExtraCharactersInAString {
    public static void main(String[] args) {
        String s = "abc";
        String[] dictionary = {"ab","bc"};
        System.out.println(new ExtraCharactersInAString().minExtraChar(s,dictionary));
    }

    int[] dp;
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        dp = new int[n];
        Arrays.fill(dp,-1);
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        return n - memo(s,set,0);
    }

    public int memo(String s, Set<String> set, int i) {
        if(i == s.length()) return 0;
        if(dp[i] != -1) return dp[i];

        StringBuilder sb = new StringBuilder();
        int ans = 0;

        for(int idx = i; idx < s.length(); idx++) {
            sb.append(s.charAt(idx));
            int count = memo(s,set,idx + 1);
            if(set.contains(sb.toString())) {
                count += sb.length();
            }
            ans = Math.max(count, ans);
        }

        return dp[i] = ans;
    }
}
