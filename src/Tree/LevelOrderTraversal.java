package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    TreeNode root;

    public static void main(String[] args) {
        LevelOrderTraversal treeLevel = new LevelOrderTraversal();
        treeLevel.root = new TreeNode(1);
        treeLevel.root.left = new TreeNode(2);
        treeLevel.root.right = new TreeNode(3);
        treeLevel.root.left.left = new TreeNode(4);
        treeLevel.root.left.right = new TreeNode(5);

        treeLevel.printLevelOrder();
    }

    private void printLevelOrder() {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        ArrayList<Integer> ans = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.println(temp.data+" ");
//            ans.add(temp.data);

            if(temp.left!=null) {
                queue.add(temp.left);
            }
            if(temp.right!=null) {
                queue.add(temp.right);
            }
        }
//        return ans;
    }

}