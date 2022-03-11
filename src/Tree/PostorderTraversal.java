package Tree;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class PostorderTraversal {

    static TreeNode root;

    public static void main(String[] args) {
        PostorderTraversal treeLevel = new PostorderTraversal();
        treeLevel.root = new TreeNode(1);
        treeLevel.root.left = new TreeNode(2);
        treeLevel.root.right = new TreeNode(3);
        treeLevel.root.left.left = new TreeNode(4);
        treeLevel.root.left.right = new TreeNode(5);

//        treeLevel.postorderTraversalUsingRecursion(root);
        treeLevel.postorderTraversalUsingIteration(root);
    }

    private void postorderTraversalUsingIteration(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr!=null || !stack.isEmpty()) {
            if (curr!=null) {
                stack.add(curr);
                curr = curr.left;
            } else {
                TreeNode temp = stack.peek().right;
                if (temp==null){
                    temp = stack.pop();
                    System.out.println(temp.data);
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        System.out.println(temp.data);
                    }
                } else {
                    curr = temp;
                }
            }
        }
    }

    private void postorderTraversalUsingRecursion(TreeNode root) {
        if (root==null) {
            return;
        }
        postorderTraversalUsingRecursion(root.left);
        postorderTraversalUsingRecursion(root.right);
        System.out.println(root.data);

    }
}
