package day9;

import java.util.*;

public class AmountofTimeforBinaryTreetoBeInfected {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        root.left = new TreeNode();
        root.left.val = 2;
        root.right = new TreeNode();
        root.right.val = 3;
        root.left.left = new TreeNode();
        root.left.left.val = 4;
        root.left.right = new TreeNode();
        root.left.right.val = 5;
        root.right.left = new TreeNode();
        root.right.left.val = 6;
        root.right.right = new TreeNode();
        root.right.right.val = 7;
        int start = 4;
        System.out.println(new AmountofTimeforBinaryTreetoBeInfected().amountOfTime(root, start));
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] maxNode = new int[1];
        treeToGraph(root, adj, maxNode);
        return bfs(start, adj, maxNode[0]);
    }

    public void treeToGraph(TreeNode root, Map<Integer, List<Integer>> map, int[] maxNode) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        map.putIfAbsent(root.val, new ArrayList<>());
        maxNode[0] = Math.max(maxNode[0], root.val);
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (node.left != null) {
                map.putIfAbsent(node.left.val, new ArrayList<>());
                map.get(node.left.val).add(node.val);
                map.get(node.val).add(node.left.val);
                q.add(node.left);
                maxNode[0] = Math.max(maxNode[0], node.left.val);
            }
            if (node.right != null) {
                map.putIfAbsent(node.right.val, new ArrayList<>());
                map.get(node.right.val).add(node.val);
                map.get(node.val).add(node.right.val);
                q.add(node.right);
                maxNode[0] = Math.max(maxNode[0], node.right.val);
            }
        }
    }

    public int bfs(int start, Map<Integer, List<Integer>> adj, int maxNode) {
        boolean[] vis = new boolean[maxNode + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;
        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.remove();
                for (Integer neighbour : adj.get(node)) {
                    if (!vis[neighbour]) {
                        q.add(neighbour);
                        vis[neighbour] = true;
                    }
                }
            }
            time++;
        }
        return time - 1;
    }
}
