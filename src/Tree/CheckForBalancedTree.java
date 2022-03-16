package Tree;

public class CheckForBalancedTree {
    static TreeNode root;

    public static void main(String[] args) {
        CheckForBalancedTree treeLevel = new CheckForBalancedTree();
        treeLevel.root = new TreeNode(1);
        treeLevel.root.left = new TreeNode(2);
        treeLevel.root.right = new TreeNode(3);
        treeLevel.root.left.left = new TreeNode(4);
        treeLevel.root.left.right = new TreeNode(5);

        System.out.println(treeLevel.checkForBalance1(root));
        System.out.println(treeLevel.checkForBalance2(root));
    }

    private boolean checkForBalance2(TreeNode root) {
        return  (dHeight(root)!=-1);


    }

    private int dHeight(TreeNode root) {
        if (root==null)
            return 0;
        int lHeight = dHeight(root.left);
        if (lHeight==-1) return -1;
        int rHeight = dHeight(root.right);
        if (rHeight==-1) return -1;
        if (Math.abs(lHeight-rHeight)>1) {
            return -1;
        }
        return (Math.max(lHeight,rHeight)+1);
    }

    private boolean checkForBalance1(TreeNode root) {
        if (root==null) {
            return true;
        }
        int l = heightOfTree(root.left);
        int r = heightOfTree(root.right);
        if (Math.abs(l-r)>1) {
            return false;
        }
        boolean left =checkForBalance1(root.left);
        boolean right = checkForBalance1(root.right);
        if (!left||!right) {
            return false;
        }
        return true;
    }

    private int heightOfTree(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int lHeight = heightOfTree(root.left);
        int rHeight = heightOfTree(root.right);
        if (lHeight>rHeight) {
            return lHeight+1;
        } else {
            return rHeight+1;
        }
    }
}
