package day18;

import java.util.*;

public class QueryKthSmallestTrimmedNumber {
    public static void main(String[] args) {
        QueryKthSmallestTrimmedNumber obj = new QueryKthSmallestTrimmedNumber();
        String[] nums = {"24","37","96","04"};
        int[][] queries = {{2,1},{2,2}};
        int[] res = obj.smallestTrimmedNumbers(nums, queries);
        for(int i : res){
            System.out.print(i + " ");
        }
    }

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = nums.length , m = queries.length;
        int[] res = new int[m];
        Map<Integer,TreeSet<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < n; i++){
            int len = nums[i].length();
            for(int j = 1; j <= len ; j++){
                int num = Integer.parseInt(nums[i].substring(len - j,len));
                if(!map.containsKey(j)){
                    map.put(j,new TreeSet<>());
                }
                map.get(j).add(num);
            }
        }


        for(int i = 0; i < m ;i++){
            int trim = queries[i][1];
            int index = queries[i][0];
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < n ;j++){
                int len = nums[j].length();
                list.add(Integer.parseInt(nums[j].substring(Math.max(0,len - trim),len)));
            }
            Collections.sort(list);
            res[i] = list.get(index - 1);
        }
        return res;
    }    class Pair {
        char[] num;  // Store as char array for faster access
        int index;

        Pair(String num, int index) {
            this.num = num.toCharArray();
            this.index = index;
        }
    }

    // Radix sort implementation for character arrays
    private void radixSort(Pair[] pairs, int trim, int startPos) {
        // Create output array for temporary storage
        Pair[] output = new Pair[pairs.length];

        // Process each digit from right to left of the trimmed portion
        for(int pos = startPos + trim - 1; pos >= startPos; pos--) {
            // Count array for digits 0-9
            int[] count = new int[10];

            // Count occurrences of each digit
            for(Pair pair : pairs) {
                count[pair.num[pos] - '0']++;
            }

            // Calculate cumulative counts
            for(int j = 1; j < 10; j++) {
                count[j] += count[j-1];
            }

            // Build output array from right to left to maintain stability
            for(int j = pairs.length - 1; j >= 0; j--) {
                int digit = pairs[j].num[pos] - '0';
                output[count[digit] - 1] = pairs[j];
                count[digit]--;
            }

            // Copy output back to pairs
            System.arraycopy(output, 0, pairs, 0, pairs.length);
        }
    }
}
