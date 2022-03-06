package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfBinaryTree {
    static TreeNode root;

    public static void main(String[] args) {
        HeightOfBinaryTree treeLevel = new HeightOfBinaryTree();
        treeLevel.root = new TreeNode(1);
        treeLevel.root.left = new TreeNode(2);
        treeLevel.root.right = new TreeNode(3);
        treeLevel.root.left.left = new TreeNode(4);
        treeLevel.root.left.right = new TreeNode(5);

        System.out.println(treeLevel.heightOfTree1(root));
        System.out.println(treeLevel.heightOfTree2(root));
    }

    private int heightOfTree2(TreeNode root) {
        if(root==null) {
            return 0;
        } else {
            int ldepth = heightOfTree2(root.left);
            int rdepth = heightOfTree2(root.right);

            if(ldepth>rdepth) {
                return (ldepth+1);
            } else {
                return (rdepth+1);
            }
        }
    }

    private int heightOfTree1(TreeNode head) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        queue.add(null);
        int h = 0;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if(temp==null) {
                h++;
            }
            if(temp!=null) {
                if(temp.left!=null) {
                    queue.add(temp.left);
                }
                if(temp.right!= null) {
                    queue.add(temp.right);
                }
            } else if(!queue.isEmpty()){
                queue.add(null);
            }
        }
        return h;
    }
}
