package Tree;

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
    }

    void mirrorInorder(TreeNode node)
    {
        if (node == null)
            return;

        mirrorInorder(node.right);

        System.out.print(node.data + " ");

        mirrorInorder(node.left);
    }
}
