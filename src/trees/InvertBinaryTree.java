package trees;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    public static void main(String[] args) {
        InvertBinaryTree obj = new InvertBinaryTree();


        // Build the tree:       4
        //                     /   \
        //                    2     7
        //                   / \   / \
        //                  1   3 6   9

        TreeNode root = obj.new TreeNode(4,
        obj.new TreeNode(2,
        obj.new TreeNode(1),
        obj.new TreeNode(3)),
        obj.new TreeNode(7,
        obj.new TreeNode(6),
        obj.new TreeNode(9))
        );

        // Invert the tree
        TreeNode invertedTree = obj.invertTree(root);

        // Print the tree in level-order
        System.out.println("Level-order of inverted tree: ");
        printLevelOrder(invertedTree);


    }


    // level-order (BFS) traversal to print the tree 
    private static void printLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);

        while(!qu.isEmpty()) {
            TreeNode current = qu.poll();
            System.out.print(current.val + " ");
        
            if (current.left != null) qu.add(current.left);
            if(current.right !=null) qu.add(current.right);

        }
    }

    public static TreeNode invertTree(TreeNode root) {

        if(root == null) {
            return null;
        }

        TreeNode right = invertTree(root.right); // childs acting like rootNode and called recursively
        TreeNode left = invertTree(root.left);
        
        root.right = left; // swapping happens
        root.left = right;

        return root; // return the inverted tree

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
