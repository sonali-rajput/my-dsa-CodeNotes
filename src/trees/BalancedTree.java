package trees;


public class BalancedTree {

    public static void main(String[] args) {
        // Balanced tree
        BalancedTree.TreeNode root1 = new BalancedTree.TreeNode(1);
        root1.left = new BalancedTree.TreeNode(2);
        root1.right = new BalancedTree.TreeNode(3);
        root1.left.left = new BalancedTree.TreeNode(4);

        boolean result1 = BalancedTree.isBalanced(root1);
        System.out.println("Tree 1 is balanced: " + result1); // true

        // Unbalanced tree
        BalancedTree.TreeNode root2 = new BalancedTree.TreeNode(1);
        root2.left = new BalancedTree.TreeNode(2);
        root2.left.left = new BalancedTree.TreeNode(3);

        boolean result2 = BalancedTree.isBalanced(root2);
        System.out.println("Tree 2 is balanced: " + result2); // false
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
        
    }

     // Definition for a binary tree node.
     public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
