package trees;

import java.util.ArrayList;
import java.util.List;

public class BTLevelOrderTraversal {

    public static void main(String[] args) {
        BTLevelOrderTraversal obj = new BTLevelOrderTraversal();

        // Create the root node with value 4
        BTLevelOrderTraversal.TreeNode root = new BTLevelOrderTraversal.TreeNode(4);

        // Create left and right children of root node
        root.left = new BTLevelOrderTraversal.TreeNode(2);
        root.right = new BTLevelOrderTraversal.TreeNode(7);

        // Create left and right children of node 2
        root.left.left = new BTLevelOrderTraversal.TreeNode(1);
        root.left.right = new BTLevelOrderTraversal.TreeNode(3);

        // Create left and right children of node 7
        root.right.left = new BTLevelOrderTraversal.TreeNode(6);
        root.right.right = new BTLevelOrderTraversal.TreeNode(9);

        // Perform level order traversal
        List<List<Integer>> result = obj.levelOrder(root);

        // Print the result
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }

    List<List<Integer>> ans = new ArrayList<>();

    public void order(TreeNode node, int level) {

        if (ans.size() == level) { // new list entry for new  level
            ans.add(new ArrayList<Integer>());
        }

        ans.get(level).add(node.val);

        if(node.left != null) {
            order(node.left, level+1);
        }
        if(node.right != null) {
            order(node.right, level+1);
        }

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if ( root == null ) return ans;
        order(root, 0);
        return ans;
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
