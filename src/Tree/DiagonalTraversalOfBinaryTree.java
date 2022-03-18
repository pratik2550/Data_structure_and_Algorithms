package Tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DiagonalTraversalOfBinaryTree {

    static TreeNode root;

    public static void main(String[] args) {
        DiagonalTraversalOfBinaryTree treeLevel = new DiagonalTraversalOfBinaryTree();
        treeLevel.root = new TreeNode(8);
        treeLevel.root.left = new TreeNode(3);
        treeLevel.root.right = new TreeNode(10);
        treeLevel.root.left.left = new TreeNode(1);
        treeLevel.root.left.right = new TreeNode(6);
        treeLevel.root.left.right.left = new TreeNode(4);
        treeLevel.root.left.right.right = new TreeNode(7);
        treeLevel.root.right.right = new TreeNode(5);
        treeLevel.root.right.right.left = new TreeNode(2);

        treeLevel.printDiagonal1(root);
        treeLevel.printDiagonal2(root);
}

    private void printDiagonal2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp==null && list.size()>0) {
                ans.add(list);
                list = new ArrayList<>();
            }
            while (temp!=null) {
                if (temp.left!=null) {
                    queue.add(temp.left);
                }
                list.add(temp.data);
                temp = temp.right;
                if (temp==null) {
                    queue.add(null);
                }
            }
        }
        for (ArrayList<Integer> i : ans){
            for (int j: i) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    private void printDiagonal1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            while (temp!=null) {
                if (temp.left!=null) {
                    queue.add(temp.left);
                }
                System.out.println(temp.data);
                ans.add(temp.data);
                temp = temp.right;
            }
        }
    }
}
