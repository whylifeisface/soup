public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left) - height(root.right)) >= 1;
    }

    public static int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        TreeNode leftRight = new TreeNode(2);
        left.left = new TreeNode(3);
        left.right = leftRight;
        leftRight.left = new TreeNode(3);
        TreeNode right = new TreeNode(4);
        TreeNode rightr = new TreeNode(4);
        right.right = rightr;
        root.right = right;
        IsBalanced isBalanced = new IsBalanced();
        boolean balanced = isBalanced.isBalanced(root);
        System.out.println(balanced);
    }

}
