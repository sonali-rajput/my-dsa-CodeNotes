package trees;

public class GoodNodes {

    public static void main(String[] args) {
    // Build the tree [3,1,4,3,null,1,5]
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(1);
    root.right = new TreeNode(4);

    root.left.left = new TreeNode(3);
    // root.left.right is null

    root.right.left = new TreeNode(1);
    root.right.right = new TreeNode(5);

    int result = goodNodes(root);
    System.out.println("Number of good nodes: " + result);
    }


    public static int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }


    
    private static int countGoodNodes(TreeNode root, int maxSoFar) {
        if(root == null) {
            return 0;
        }

        int count = 0;
        if(root.val >= maxSoFar) {
            count = 1; // current node is a good node
            maxSoFar = root.val;
        }

        // Count the good nodes in left and right sub trees
        count = count + countGoodNodes(root.left, maxSoFar);
        count = count + countGoodNodes(root.right, maxSoFar);

        return count;

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
