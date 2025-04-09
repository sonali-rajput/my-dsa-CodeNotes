package trees;

public class MaxDepth {

    public static void main(String[] args) {
        MaxDepth obj = new MaxDepth();

        // Building the tree level-wise:
        MaxDepth.TreeNode root = obj.new TreeNode(4);
        root.left = obj.new TreeNode(2);
        root.right = obj.new TreeNode(7);
    
        root.left.left = obj.new TreeNode(1);
        root.left.right = obj.new TreeNode(3);
        root.right.left = obj.new TreeNode(6);
        root.right.right = obj.new TreeNode(9);
    
        root.left.left.left = obj.new TreeNode(0);
        root.left.left.left.right = obj.new TreeNode(2);
    
        // Get max depth
        int max = obj.maxDepth(root);
        System.out.println("Max depth of the tree: " + max);
    }

    

    public static int maxDepth(TreeNode root) {
        
        if(root == null) {
            return 0;
        }

        else {
            int leftmax = maxDepth(root.left);
            int rightmax = maxDepth(root.right);
            return Math.max(leftmax, rightmax) + 1;
        }
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
