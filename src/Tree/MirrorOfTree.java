package Tree;

import sun.reflect.generics.tree.Tree;

public class MirrorOfTree {

    static TreeNode root;

    public static void main(String[] args) {
        MirrorOfTree treeLevel = new MirrorOfTree();
        treeLevel.root = new TreeNode(5);
        treeLevel.root.left = new TreeNode(3);
        treeLevel.root.right = new TreeNode(6);
        treeLevel.root.left.left = new TreeNode(2);
        treeLevel.root.left.right = new TreeNode(4);

        treeLevel.mirrorInorder(root);
        System.out.println();
        TreeNode mirror1 = mirrorify1(root);
        printTree(mirror1);
        System.out.println();
        TreeNode mirror2 = mirrorify2(root);
        printTree(root);

    }

    private static void printTree(TreeNode root) {
        if (root == null)
            return;

        printTree(root.left);
        System.out.print(root.data + " ");
        printTree(root.right);
    }

    void mirrorInorder(TreeNode node)
    {
        if (node == null)
            return;

        mirrorInorder(node.right);

        System.out.print(node.data + " ");

        mirrorInorder(node.left);
    }

    static TreeNode mirrorify1(TreeNode root)
    {
        if (root == null)
        {
            return null;

        }

        TreeNode mirror = new TreeNode(root.data);
        mirror.right = mirrorify1(root.left);
        mirror.left = mirrorify1(root.right);
        return mirror;
    }

    public static TreeNode mirrorify2(TreeNode root)
    {
        if (root == null)
            return null;

        TreeNode left = mirrorify2(root.left);
        TreeNode right = mirrorify2(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
