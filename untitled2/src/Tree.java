
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Logger;

public class Tree {
    public Tree() {

    }

    public static void main(String[] args) {
        Tree tree = new Tree();
//        TreeNode root = tree.new TreeNode(1);
//        root.left = null;
//        TreeNode right = tree.new TreeNode(2);
//        right.left = tree.new TreeNode(3);
//        root.right = right;
//        System.out.println(integers);
//        TreeNode root = tree.new TreeNode(2);
//        TreeNode left = tree.new TreeNode(3);
//        left.right = tree.new TreeNode(1);
//        root.left = left;
//        List<Integer> integers = tree.inorderTraversal(root);
//        System.out.println(integers);
//        TreeNode root = tree.new TreeNode(3);
//        TreeNode left = tree.new TreeNode(1);
//        TreeNode right = tree.new TreeNode(2);
//        root.right = right;
//        List<Integer> integers = tree.inorderTraversal(root);
//        System.out.println(integers);
        TreeNode root = tree.new TreeNode(1);
        TreeNode left = tree.new TreeNode(2);
        TreeNode leftL = tree.new TreeNode(3);
        TreeNode leftR = tree.new TreeNode(4);
        TreeNode leftRl = tree.new TreeNode(5);
        TreeNode leftRr = tree.new TreeNode(6);
        TreeNode leftRlr = tree.new TreeNode(7);
        root.left = left;
        left.left = leftL;
        left.right = leftR;
        leftR.right = leftRr;
        leftR.left = leftRl;
        leftRl.right = leftRlr;
        List<Integer> list = tree.postorderTraversal(root, 1);
        for (Integer i :
                list) {
            System.out.println(i);
        }
        //        List<Integer> integers = tree.postorderTraversal(root);

//        TreeNode root = tree.new TreeNode(1);
//        TreeNode Right = tree.new TreeNode(2);
//        TreeNode Rightr = tree.new TreeNode(3);
//        root.right = Right;
//        Right.right = Rightr;
//        while (cur != null) {
//            System.out.println(cur.val);
//            cur = cur.right;
//        }
//        TreeNode treeNode = tree.reserveTree(root);
//        System.out.println(treeNode.val);
//        List<Integer> list = tree.postorderTraversal(root);
//                for (Integer i : list) {
//            System.out.println(i);
//        }
    }

    //           1
//     1           1
//   1   1        1    1
    public List<Integer> postorderTraversal(TreeNode root, int i) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        do {
            while (root != null && prev != root) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right != null && root.right != prev && root != prev) {
                stack.push(root);
                root = root.right;
//                prevRight = root;
//                if (root.left != null) {
//                    stack.push(root);
//                    root = null;
//                }
//                root = null;
                continue;
            }
                list.add(root.val);
            prev = root;
        } while (root != null && !stack.isEmpty());
        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prevLeft = null, prevRight = null;
        do {
            while (root != null && (!list.contains(root.val) || prevLeft != root)) {
                stack.push(root);
                prevLeft = root;
                root = root.left;
            }
            root = stack.pop();
            if (root.right != null && (root != prevRight)) {
                stack.push(root);
                prevRight = root;
                root = root.right;
                if (root.left != null) {
                    stack.push(root);
                }
                continue;
            }
            list.add(root.val);
//            root = stack.pop();
        } while (root != null && !stack.isEmpty());
        return list;
    }

//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        if (root == null) return list;
//        TreeNode cur = root, mostRight;
//        while (cur != null) {
//            mostRight = cur.left;
//            if (mostRight != null) {
//                while (mostRight.right != null && mostRight.right != cur)
//                    mostRight = mostRight.right;
//                if (mostRight.right == null) {
//                    mostRight.right = cur;
//                    cur = cur.left;
//                    continue;
//                } else {
//                    mostRight.right = null;
//                    addNode(list,cur.left);
//                }
//            }
//            cur = cur.right;
//        }
//        addNode(list,root);
//        return list;
//    }
//
//    public void addNode(List<Integer> list, TreeNode tree) {
//        TreeNode tail = reserveTree(tree);
//        while (tail != null){
//            list.add(tail.val);
//            tail = tail.right;
//        }
//         reserveTree(tail);
//    }
//
//    public TreeNode reserveTree(TreeNode tree) {
//        if (tree == null) System.out.println("error");
//        TreeNode cur = tree, pre = null;
//        while (cur != null) {
//            TreeNode next = cur.right;
//            cur.right = pre;
//            pre = cur;
//            if (next == null) break;
//            cur = next;
//        }
//        return cur;
//    }
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<Integer>();
//        if (root == null) {
//            return res;
//        }
//
//        TreeNode cur = root, mostRight = null;
//
//        while (cur != null) {
//            mostRight = cur.left;
//            if (mostRight != null) {
//                while (mostRight.right != null && mostRight.right != cur) {
//                    mostRight = mostRight.right;
//                }
//                if (mostRight.right == null) {
//                    mostRight.right = cur;
//                    cur = cur.left;
//                    continue;
//                } else {
//                    mostRight.right = null;
//                    addPath(res, cur.left);
//                }
//            }
//            cur = cur.right;
//        }
//        addPath(res, root);
//        return res;
//    }
//    public void addPath(List<Integer> res, TreeNode node) {
//        int count = 0;
//        while (node != null) {
//            ++count;
//            res.add(node.val);
//            node = node.right;
//        }
//        int left = res.size() - count, right = res.size() - 1;
//        while (left < right) {
//            int temp = res.get(left);
//            res.set(left, res.get(right));
//            res.set(right, temp);
//            left++;
//            right--;
//        }
//    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        if (root == null) return l;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            //左子树不为空
            if (!list.contains(root.left) && root.left != null) {
                // 左左未遍历
                root = root.left;
                stack.push(root);
            } else if (!list.contains(root) && (root.right != null || root.left != null)) {
                //未加入中间
                list.add(root);
            } else if (root.right != null && !list.contains(root.right)) {

                // 取右边
                root = root.right;
                stack.push(root);
            } else if (list.contains(root.left) || list.contains(root.right)) {
                if (!list.contains(root)) list.add(root);
                stack.pop();
                if (!stack.isEmpty()) root = stack.peek();
            } else {
                stack.pop();
                list.add(root);
                if (!stack.isEmpty()) root = stack.peek();
            }

        }
        list.forEach(tree -> l.add(tree.val));
        return l;
    }


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
