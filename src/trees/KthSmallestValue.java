package trees;

import java.util.ArrayList;

public class KthSmallestValue {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        int smallest = kthSmallest(root, 1);
        System.out.println(smallest); 
    }


    public static ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) {
            return arr;
        }

        inOrder(root.left, arr);
        arr.add(root.val);
        inOrder(root.right, arr);
        return arr;
    }
    public static int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inOrder(root, new ArrayList<Integer>());
        return nums.get(k-1); // k is 1-indexed
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
