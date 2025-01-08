package day7;

import java.util.ArrayList;
import java.util.Collections;

public class Phonedirectory {
    public static void main(String[] args) {

    }
    static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s) {
        // Result list to store results for each prefix
        ArrayList<ArrayList<String>> res = new ArrayList<>();

        // Process each prefix of the query string 's'
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i); // Current prefix
            ArrayList<String> list = new ArrayList<>();

            // Check each contact for matching prefix
            for (String name : contact) {
                if (name.startsWith(prefix)) {
                    list.add(name);
                }
            }

            // Sort results only if matches are found
            if (list.isEmpty()) {
                list.add("0"); // No match case
            } else {
                Collections.sort(list); // Sort results for this prefix
            }

            res.add(list); // Add to result
        }

        return res;
    }
}
