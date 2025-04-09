package trees;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        LowestCommonAncestor obj = new LowestCommonAncestor();

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        TreeNode p = root.left;           // Node 2
        TreeNode q = root.left.right;     // Node 4

        TreeNode lca = obj.lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor: " + lca.val);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         int parentVal = root.val;
         int pVal = p.val;
         int qVal = q.val;

         if(pVal>parentVal && qVal>parentVal) {
            return lowestCommonAncestor(root.right, p, q);
         }
         if (pVal<parentVal && qVal < parentVal) {
            return lowestCommonAncestor(root.left, p, q);
         }
         else {
            return root;
         }
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
