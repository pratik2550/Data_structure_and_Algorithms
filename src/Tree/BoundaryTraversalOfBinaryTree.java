package Tree;

import java.util.ArrayList;

public class BoundaryTraversalOfBinaryTree {
    static TreeNode root;

    public static void main(String[] args) {
        BoundaryTraversalOfBinaryTree treeLevel = new BoundaryTraversalOfBinaryTree();
        treeLevel.root = new TreeNode(8);
        treeLevel.root.left = new TreeNode(3);
        treeLevel.root.right = new TreeNode(10);
        treeLevel.root.left.left = new TreeNode(1);
        treeLevel.root.left.right = new TreeNode(6);
        treeLevel.root.left.right.left = new TreeNode(4);
        treeLevel.root.left.right.right = new TreeNode(7);
        treeLevel.root.right.right = new TreeNode(5);
        treeLevel.root.right.right.left = new TreeNode(2);

        treeLevel.boundaryTraversalOfBinaryTree(root);
}

    private void boundaryTraversalOfBinaryTree(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null) {
            return;
        }
        res.add(root.data);
        addLeftBoundary(root, res);
        addLeaves(root.left, res);
        addLeaves(root.right, res);
        addRightBoundary(root, res);
        for (int i: res) {
            System.out.println(i);
        }
    }

    private void addLeaves(TreeNode root, ArrayList<Integer> res) {
        if (root==null)
            return;
        addLeaves(root.left, res);
        if (root.left==null && root.right==null){
            res.add(root.data);
        }
        addLeaves(root.right, res);
    }

    private void addRightBoundary(TreeNode root, ArrayList<Integer> res) {
        TreeNode temp = root.right;
        ArrayList<Integer> tmp = new ArrayList<>();
        while (temp!=null) {
            if (!(temp.left==null && temp.right==null)) {
                tmp.add(temp.data);
            }
            if (temp.right!=null) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
        for (int i=tmp.size()-1; i>=0; i--){
            res.add(tmp.get(i));
        }
    }

    private void addLeftBoundary(TreeNode root, ArrayList<Integer> res) {
        TreeNode temp = root.left;
        while (temp!=null) {
            if (!(temp.left==null && temp.right==null)) {
                res.add(temp.data);
            }
            if (temp.left!=null){
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
    }
}
//17 N 1 N 9 N 2 N 11 N 16 N 8 N 5 N 3 N 10 N 13 N 5 N 13 N 7 N 10 N 4 N 7 N 2 N 12 N 16
//8 3 1 4 7 2 5 10