package trees;

public class SameTree {

    public static void main(String[] args) {
        // Create tree p: 1 -> 2, 3
        SameTree.TreeNode p = new SameTree.TreeNode(1);
        p.left = new SameTree.TreeNode(2);
        p.right = new SameTree.TreeNode(3);

        // Create tree q: 1 -> 2, 3
        SameTree.TreeNode q = new SameTree.TreeNode(1);
        q.left = new SameTree.TreeNode(2);
        q.right = new SameTree.TreeNode(3);

        boolean result = SameTree.isSameTree(p, q);
        System.out.println("Are the trees the same? " + result); 

    }
    
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if ( p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
