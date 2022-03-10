package Tree;

import java.util.Stack;

public class InorderTraversal {

    static TreeNode root;

    public static void main(String[] args) {
        InorderTraversal treeLevel = new InorderTraversal();
        treeLevel.root = new TreeNode(1);
        treeLevel.root.left = new TreeNode(2);
        treeLevel.root.right = new TreeNode(3);
        treeLevel.root.left.left = new TreeNode(4);
        treeLevel.root.left.right = new TreeNode(5);

        treeLevel.inorderTraversalUsingRecursion(root);
        treeLevel.inorderTraversalUsingIteration(root);
    }

    private void inorderTraversalUsingIteration(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            if (cur!=null) {
                stack.add(cur);
                cur = cur.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                cur = stack.pop();
                System.out.println(cur.data);
                cur = cur.right;
            }
        }




    }

    private void inorderTraversalUsingRecursion(TreeNode root) {
        if (root==null) {
            return;
        }
        inorderTraversalUsingRecursion(root.left);
        System.out.println(root.data);
        inorderTraversalUsingRecursion(root.right);
    }

}
