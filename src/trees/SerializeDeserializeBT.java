package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeDeserializeBT {

    public static void main(String[] args) {
        SerializeDeserializeBT serDeser = new SerializeDeserializeBT();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
    
        String serialized = serDeser.serialize(root);
        System.out.println("Serialized Tree: " + serialized); // Should match input format
    
        TreeNode deserialized = serDeser.deserialize(serialized);
    
        // Level-order output to confirm structure
        printLevelOrder(deserialized); // Expected: [1, 2, 3, null, null, 4, 5]
    }

    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        List<String> output = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                output.add("null");
            } else {
                output.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        System.out.println("Level Order (with nulls): " + output);
    }


    public String recserialize(TreeNode root, String str) { // pre-order traversal (recursive)
        if (root == null) {
            str += "null,";
        } else {
            str += String.valueOf(root.val) + ",";
            str = recserialize(root.left, str);
            str = recserialize(root.right, str);
        }

        return str;

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return recserialize(root, "");
    }

    public TreeNode recdeserialize(List<String> str) {
        if (str.get(0).equals("null")) {
            str.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(str.get(0))); // root node of BT
        str.remove(0);
        root.left = recdeserialize(str);
        root.right = recdeserialize(str);

        return root;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] stArray = data.split(",");
        List<String> strList = new LinkedList<String>(Arrays.asList(stArray));
        return recdeserialize(strList);

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
