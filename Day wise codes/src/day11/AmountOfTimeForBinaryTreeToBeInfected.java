package day11;

import javax.swing.tree.TreeNode;
import java.util.*;

public class AmountOfTimeForBinaryTreeToBeInfected {
    public static void main(String[] args) {

    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
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
