package me.codezealer.leetcode;

public class _543_DiameterOfBianryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int res = maxDepth(root.left) + maxDepth(root.right);
        return Math.max(res, Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }

}
