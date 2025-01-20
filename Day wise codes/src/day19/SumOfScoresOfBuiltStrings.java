package day19;

public class SumOfScoresOfBuiltStrings {
    public long sumScores(String s) {
        int[] z = calculateZ(s);
        long sum = 0;
        for(int num : z){
            sum += num;
        }
        return sum;
    }
    public static int[] calculateZ(String s) {
        int n = s.length();
        int[] z = new int[n];

        // The first element is always the length of the string
        z[0] = n;

        // Initialize the Z-box boundaries
        int left = 0;  // Left boundary of current Z-box
        int right = 0; // Right boundary of current Z-box

        // Process each position starting from index 1
        for (int i = 1; i < n; i++) {
            // CASE 1: i is outside the current Z-box (i > right)
            if (i > right) {
                // We need to match characters explicitly
                left = right = i;

                // Compare characters until we find a mismatch or reach the end
                while (right < n && s.charAt(right - left) == s.charAt(right)) {
                    right++;
                }

                // Store the length of the match
                z[i] = right - left;

                // Adjust right to point to the last matching position
                right--;

            } else {
                // CASE 2: i is inside the current Z-box
                // Calculate the corresponding position in the prefix
                int k = i - left;

                // If the value at k doesn't stretch beyond our Z-box
                if (z[k] < right - i + 1) {
                    // We can directly copy the value
                    z[i] = z[k];
                } else {
                    // The value might be larger, so we need to check explicitly
                    left = i;

                    // Continue matching from the right boundary
                    while (right < n && s.charAt(right - left) == s.charAt(right)) {
                        right++;
                    }

                    z[i] = right - left;
                    right--;
                }
            }
        }

        return z;
    }
}
