package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
        treeLevel.rightViewOfBinaryTreeIterative(root);
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

    private void rightViewOfBinaryTreeIterative(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(root);
        queue.add(null);
        int h=0;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (list.size()==h && temp!=null){
                list.add(h, temp.data);
//            }else if (list.size()>=h && temp!=null) {
//                list.set(h, temp.data);
            }
            if (temp==null) {
                h++;
            }
            if (temp!=null) {
                if (temp.right!=null){
                    queue.add(temp.right);
                }
                if (temp.left!=null){
                    queue.add(temp.left);
                }
            } else if(!queue.isEmpty()){
                queue.add(null);
            }
        }
        for (int i: list) {
            System.out.print(i+" ");
        }
    }

}
