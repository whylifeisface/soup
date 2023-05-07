public class CloneTree {
    public TreeNode cloneTree(TreeNode root) {
        if (root == null) return null;
        return new TreeNode(root.val, cloneTree(root.left), cloneTree(root.right));
    }
}
