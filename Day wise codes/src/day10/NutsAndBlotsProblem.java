package day10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NutsAndBlotsProblem {
    public static void main(String[] args) {

    }
    void matchPairs(int n, char nuts[], char bolts[]) {
        String order = "!#$%&*@?^";

        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        Character[] nutsArr = new Character[n];
        Character[] boltsArr = new Character[n];
        for (int i = 0; i < n; i++) {
            nutsArr[i] = nuts[i];
            boltsArr[i] = bolts[i];
        }

        Arrays.sort(nutsArr, (a, b) -> orderMap.get(a) - orderMap.get(b));
        Arrays.sort(boltsArr, (a, b) -> orderMap.get(a) - orderMap.get(b));

        for (int i = 0; i < n; i++) {
            nuts[i] = nutsArr[i];
            bolts[i] = boltsArr[i];
        }
    }
}
