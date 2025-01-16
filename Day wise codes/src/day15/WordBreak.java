package day15;

import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        System.out.println(new WordBreak().wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        for(int i = n - 1; i >= 0; i--){
            for(String word : wordDict){
                int curSize = word.length();

                if((i + curSize) <= n){
                    if (s.substring(i, i + curSize).equals(word) && dp[i + curSize]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[0];
    }
}
