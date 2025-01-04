package day3;

import java.util.*;

public class RepeatedDNASequences {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences(s));
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        if (n < 10) return new ArrayList<>();

        // Correct mapping for DNA letters
        Map<Character, Integer> hashTable = new HashMap<>();
        hashTable.put('A', 0);
        hashTable.put('C', 1);
        hashTable.put('G', 2);
        hashTable.put('T', 3);

        int mask = (1 << 20) - 1;
        int hash = 0;
        Set<Integer> set = new HashSet<>();
        Set<String> res = new HashSet<>();

        for (int j = 0; j < n; j++) {
            hash = ((hash << 2) | hashTable.get(s.charAt(j))) & mask;

            if (j >= 9) {
                if (set.contains(hash)) {
                    res.add(s.substring(j - 9, j + 1));
                } else {
                    set.add(hash);
                }
            }
        }

        return new ArrayList<>(res);
    }
}
