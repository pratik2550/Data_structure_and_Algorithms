package Tree;

public class DiameterOfBinaryTree {

    static TreeNode root;

    public static void main(String[] args) {
        DiameterOfBinaryTree treeLevel = new DiameterOfBinaryTree();
        treeLevel.root = new TreeNode(1);
        treeLevel.root.left = new TreeNode(2);
        treeLevel.root.right = new TreeNode(3);
        treeLevel.root.left.left = new TreeNode(4);
        treeLevel.root.left.right = new TreeNode(5);

        System.out.println(treeLevel.diameter(root));
    }

    private int diameter(TreeNode root) {
        if(root == null)
                return 0;
        int le = diameter(root.left);
        int ri = diameter(root.right);
        int f = height(root.left)+height(root.right)+1;
        return Math.max(f,Math.max(le,ri));
    }
    int height(TreeNode node){
        if(node == null) return 0;
        int le = height(node.left);
        int ri = height(node.right);
        return Math.max(le,ri)+1;
    }
}
