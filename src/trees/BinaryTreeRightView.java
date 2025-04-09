package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightView {

    public static void main(String[] args) {
        BinaryTreeRightView obj = new BinaryTreeRightView();

        // Build the tree manually
        BinaryTreeRightView.TreeNode root = new BinaryTreeRightView.TreeNode(1);

        root.left = new BinaryTreeRightView.TreeNode(2);
        root.right = new BinaryTreeRightView.TreeNode(3);

        root.left.right = new BinaryTreeRightView.TreeNode(5);
        root.right.right = new BinaryTreeRightView.TreeNode(4);

        // Get the right view of the tree
        List<Integer> rightView = obj.rightSideView(root);

        // Print the right view
        System.out.println(rightView); // Output: [1, 3, 4]
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currenNode = queue.poll();

                // Add the last node's value of each level to the result list
                if (i == levelSize - 1) {
                    result.add(currenNode.val);
                }

                // Add child node to the queue for the next level
                if (currenNode.left != null) {
                    queue.add(currenNode.left);
                }
                if (currenNode.right != null) {
                    queue.add(currenNode.right);
                }
            }

        }
        return result;
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
