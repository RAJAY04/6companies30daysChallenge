package day10;

import java.util.HashMap;
import java.util.Stack;

public class BracketsInMatrixChainMultiplication {
    public static void main(String[] args) {

    }

    static String convertToStringRecursive(int i, int j, int[][] store) {
        if (i == j) {
            return "" + (char) (i + 64); //'A' + i - 1
        }
        return '(' + convertToStringRecursive(i, store[i][j], store) +
                convertToStringRecursive(store[i][j] + 1, j, store) + ')';
    }

    static String convertToStringIterative(int i, int j, int[][] store) {
        Stack<int[]> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();

        stack.push(new int[]{i, j});

        while (!stack.isEmpty()) {
            int[] pair = stack.pop();
            i = pair[0];
            j = pair[1];
            if (i == j) {
                result.append((char) (i + 64));
                int t = map.getOrDefault(j, 0);
                while (t-- > 0) {
                    result.append(')');
                }
            } else {
                result.append('(');

                stack.push(new int[]{store[i][j] + 1, j});
                stack.push(new int[]{i, store[i][j]});

                map.put(j, map.getOrDefault(j, 0) + 1);
            }
        }
        return result.toString();
    }
}