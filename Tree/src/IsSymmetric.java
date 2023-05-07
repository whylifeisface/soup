public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        System.out.println(root.left.left.val);
        IsSameTree isSameTree = new IsSameTree();
        CloneTree cloneTree = new CloneTree();

        TreeNode cloneTreel = cloneTree.cloneTree(root);

        return isSameTree.isSameTree(root,change(cloneTreel));
    }

    public IsSymmetric() {
    }

    public TreeNode change(TreeNode root) {
        InvertTree invertTree = new InvertTree();
        invertTree.invertTree(root);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(3);
        left.right = new TreeNode(4);
        right.left = new TreeNode(4);
        right.right = new TreeNode(3);

        IsSymmetric isSymmetric = new IsSymmetric();
        boolean symmetric = isSymmetric.isSymmetric(root);
        System.out.println(symmetric);
    }
}
