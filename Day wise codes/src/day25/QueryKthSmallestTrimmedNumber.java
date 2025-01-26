package day25;

public class QueryKthSmallestTrimmedNumber {
    class Pair {
        char[] num;
        int index;

        Pair(String num, int index) {
            this.num = num.toCharArray();
            this.index = index;
        }
    }

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int numLength = nums[0].length();
        int[] result = new int[m];

        Pair[] originalPairs = new Pair[n];
        for(int j = 0; j < n; j++) {
            originalPairs[j] = new Pair(nums[j], j);
        }

        for(int i = 0; i < m; i++) {
            int k = queries[i][0];
            int trim = queries[i][1];

            Pair[] pairs = new Pair[n];
            System.arraycopy(originalPairs, 0, pairs, 0, n);

            radixSort(pairs, trim, numLength - trim);
            result[i] = pairs[k-1].index;
        }

        return result;
    }

    private void radixSort(Pair[] pairs, int trim, int startPos) {
        Pair[] output = new Pair[pairs.length];

        for(int pos = startPos + trim - 1; pos >= startPos; pos--) {
            int[] count = new int[10];

            for(Pair pair : pairs) {
                count[pair.num[pos] - '0']++;
            }

            for(int j = 1; j < 10; j++) {
                count[j] += count[j-1];
            }

            for(int j = pairs.length - 1; j >= 0; j--) {
                int digit = pairs[j].num[pos] - '0';
                output[count[digit] - 1] = pairs[j];
                count[digit]--;
            }

            System.arraycopy(output, 0, pairs, 0, pairs.length);
        }
    }
}
