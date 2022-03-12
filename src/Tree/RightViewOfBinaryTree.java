package Tree;

import java.util.ArrayList;

public class RightViewOfBinaryTree {

    static TreeNode root;

    public static void main(String[] args) {
        RightViewOfBinaryTree treeLevel = new RightViewOfBinaryTree();
        treeLevel.root = new TreeNode(1);
        treeLevel.root.left = new TreeNode(2);
        treeLevel.root.right = new TreeNode(3);
        treeLevel.root.left.left = new TreeNode(4);
        treeLevel.root.left.right = new TreeNode(5);

        treeLevel.rightViewOfBinaryTreeRecursive(root);
//        treeLevel.rightViewOfBinaryTreeIterative(root);
    }

    private void rightViewOfBinaryTreeRecursive(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        rightViewRecursiveUtil(root, list, 0);
        for (int i: list) {
            System.out.print(i+" ");
        }
    }

    private void rightViewRecursiveUtil(TreeNode root, ArrayList<Integer> list, int level) {
        if (root==null) {
            return;
        }
        if (list.size()==level) {
            list.add(root.data);
        }
        rightViewRecursiveUtil(root.right, list, level+1);
        rightViewRecursiveUtil(root.left, list, level+1);
    }

    private void leftViewOfBinaryTreeIterative(TreeNode root) {

    }

}
