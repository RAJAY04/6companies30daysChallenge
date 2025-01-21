package day20;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodLeafNodesPairs {
    int ans;
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int countPairs(TreeNode root, int distance) {
        ans = 0;
        dfs(root, distance);
        return ans;
    }

    public Map<Integer, Integer> dfs(TreeNode root, int distance) {
        if (root == null)
            return new HashMap<>();
        if (root.left == null && root.right == null) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(1, 1);
            return map;
        }

        Map<Integer, Integer> left = dfs(root.left, distance);
        Map<Integer, Integer> right = dfs(root.right, distance);

        if (!left.isEmpty() && !right.isEmpty()) {
            for (int key1 : left.keySet()) {
                for (int key2 : right.keySet()) {
                    if ((key1 + key2) <= distance) {
                        ans += (left.get(key1) * right.get(key2));
                    }
                }
            }
        }
        Map<Integer, Integer> parentMap = new HashMap<>();
        for (int key : left.keySet()) {
            if (key + 1 < distance) {
                parentMap.put(key + 1, left.get(key));
            }
        }
        for (int key : right.keySet()) {
            if (key + 1 < distance) {
                parentMap.put(key + 1, parentMap.getOrDefault(key + 1, 0) + right.get(key));
            }
        }

        return parentMap;
    }
}
