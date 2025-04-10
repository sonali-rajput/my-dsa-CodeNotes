package trees;

public class IsValidBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        boolean result = isValidBST(root);
        System.out.println("The BST is valid? "+ result);
    }

    public static Integer prev;
    public static boolean isValidBST(TreeNode root) {
        prev = null;
        return inOrder(root);
    }

    

    private static boolean inOrder(TreeNode root) { // in order traversal DFS  ( returns in sorted order)
        if(root == null) {
            return true;
        }

        if(!inOrder(root.left)){
            return false;
        }

        if(prev != null && prev >= root.val) { // if it is not in sorted order
            return false;
        }
        prev = root.val;
        return inOrder(root.right);
    }



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
