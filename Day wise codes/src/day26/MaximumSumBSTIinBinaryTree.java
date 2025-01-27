package day26;

public class MaximumSumBSTIinBinaryTree {
    public static void main(String[] args) {
        MaximumSumBSTIinBinaryTree obj = new MaximumSumBSTIinBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(6);
        System.out.println(obj.maxSumBST(root));
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        findMaxSum(root);
        return maxSum;
    }

    private NodeWrapper findMaxSum(TreeNode root) {
        if (root == null) {
            return null;
        }

        NodeWrapper leftTree = findMaxSum(root.left);
        NodeWrapper rightTree = findMaxSum(root.right);

        NodeWrapper curNode = new NodeWrapper(root);
        if (leftTree != null) {
            curNode.sum += leftTree.sum;
            curNode.max = Math.max(root.val, leftTree.max);
            curNode.min = Math.min(root.val, leftTree.min);
            curNode.validBST = leftTree.validBST && leftTree.max < root.val;
        }
        if (rightTree != null) {
            curNode.sum += rightTree.sum;
            curNode.max = Math.max(curNode.max, rightTree.max);
            curNode.min = Math.min(curNode.min, rightTree.min);
            curNode.validBST &= rightTree.validBST && rightTree.min > root.val;
        }

        if (curNode.validBST) {
            maxSum = Math.max(maxSum, curNode.sum);
        }
        return curNode;
    }

    static class NodeWrapper {
        final TreeNode node;
        int sum;
        int max;
        int min;
        boolean validBST = true;
        public NodeWrapper(TreeNode node) {
            this.node = node;
            this.sum = node.val;
            this.max = node.val;
            this.min = node.val;
        }
    }
}
