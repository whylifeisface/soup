public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) return q == null;
        else if (q == null) return p == null;

        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}
