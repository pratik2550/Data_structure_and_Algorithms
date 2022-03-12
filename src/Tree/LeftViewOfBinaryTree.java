package Tree;

import java.util.ArrayList;

public class LeftViewOfBinaryTree {
    static TreeNode root;

    public static void main(String[] args) {
        LeftViewOfBinaryTree treeLevel = new LeftViewOfBinaryTree();
        treeLevel.root = new TreeNode(1);
        treeLevel.root.left = new TreeNode(2);
        treeLevel.root.right = new TreeNode(3);
        treeLevel.root.left.left = new TreeNode(4);
        treeLevel.root.left.right = new TreeNode(5);

        treeLevel.leftViewOfBinaryTreeRecursive(root);
//        treeLevel.leftViewOfBinaryTreeIterative(root);
}

    private void leftViewOfBinaryTreeRecursive(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        leftViewRecursiveUtil(root, list, 0);
        for (int i: list) {
            System.out.print(i+" ");
        }
    }

    private void leftViewRecursiveUtil(TreeNode root, ArrayList<Integer> list, int level) {
        if (root==null) {
            return;
        }
        if (list.size()==level) {
            list.add(root.data);
        }
        leftViewRecursiveUtil(root.left, list, level+1);
        leftViewRecursiveUtil(root.right, list, level+1);
    }

    private void leftViewOfBinaryTreeIterative(TreeNode root) {

    }

}
