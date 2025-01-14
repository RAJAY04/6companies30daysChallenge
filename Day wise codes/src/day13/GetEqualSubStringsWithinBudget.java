package day13;

public class GetEqualSubStringsWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int i = 0 , j = 0;
        int max = 0;
        while(j < n){
            maxCost -= Math.abs(s.charAt(j) - t.charAt(j));
            while(i < n && maxCost < 0){
                maxCost += Math.abs(s.charAt(i) - t.charAt(i));
                i++;
            }
            max = Math.max(max,j - i + 1);
            j++;
        }
        return max;
    }
}
