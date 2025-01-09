package day8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree {
   static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public String serialize(TreeNode root) {
        if(root == null)return null;
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        sb.append(String.valueOf(root.val));
        sb.append("#");
        while(!q.isEmpty()){
            TreeNode node = q.remove();
            if(node.left != null){
                q.add(node.left);
                sb.append(String.valueOf(node.left.val));
                sb.append("#");
            }else{
                sb.append("N");
                sb.append("#");
            }
            if(node.right != null){
                q.add(node.right);
                sb.append(String.valueOf(node.right.val));
                sb.append("#");
            }else{
                sb.append("N");
                sb.append("#");
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String s) {
        if(s == null)return null;
        String[] data = s.split("#");
        System.out.println(Arrays.toString(data));
        Queue<TreeNode> q = new LinkedList<>();
        int i = 0, n = data.length;
        TreeNode node = new TreeNode(Integer.parseInt(data[i++]));
        q.add(node);
        while(!q.isEmpty()){
            TreeNode cur = q.remove();
            if(i < n && !data[i].equals("N")){
                TreeNode left = new TreeNode(Integer.parseInt(data[i]));
                cur.left = left;
                q.add(left);
            }else{
                cur.left = null;
            }
            i++;
            if(i < n && !data[i].equals("N")){
                TreeNode right = new TreeNode(Integer.parseInt(data[i]));
                cur.right = right;
                q.add(right);
            }else{
                cur.right = null;
            }
            i++;
        }
        return node;
    }
}
