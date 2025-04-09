package trees;

public class DiameterBT {

    static int maxDiameter = 0; // global var
    public static int diameterOfBinaryTree(TreeNode root) {

        getHeight(root);
        return maxDiameter;
        
    }



    private static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftheight = getHeight(root.left);
        int rightheight = getHeight(root.right);

        maxDiameter = Math.max(maxDiameter, leftheight + rightheight); // maximum of sub nodes

        return 1+ Math.max(leftheight, rightheight);
        
    }



    // Definition for a binary tree node.
    public class TreeNode {
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
