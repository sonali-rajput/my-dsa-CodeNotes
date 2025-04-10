package trees;

import java.util.HashMap;
import java.util.Map;

public class BuildBinaryTree {

    public static void main(String[] args) {
        BuildBinaryTree builder = new BuildBinaryTree();
        

    //      1
    //     / \
    //    2   3
    //   / \
    //  4   5
 
        int[] preorder = {1, 2, 4, 5, 3};
        int[] inorder = {4, 2, 5, 1, 3};
    
        TreeNode root = builder.buildTree(preorder, inorder);
        printInOrder(root); // Should print: 4 2 5 1 3
    }
    
    // Utility to print inorder and verify tree structure
    public static void printInOrder(TreeNode node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }


    int  preOrderIndex;
    Map<Integer,Integer> inorderIndexMap;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        preOrderIndex = 0;
        inorderIndexMap = new HashMap<>();
        
        for (int i=0; i<inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    public  TreeNode arrayToTree(int[] preorder, int left, int right) {

        if(left>right) {
            return null;
        }

        int rootValue = preorder[preOrderIndex];
        preOrderIndex++;

        TreeNode root = new TreeNode(rootValue);
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue)-1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue)+1, right);

        return root;


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
