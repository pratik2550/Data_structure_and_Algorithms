package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversal {

    TreeNode root;

    public static void main(String[] args) {
        ReverseLevelOrderTraversal treeLevel = new ReverseLevelOrderTraversal();
        treeLevel.root = new TreeNode(1);
        treeLevel.root.left = new TreeNode(2);
        treeLevel.root.right = new TreeNode(3);
        treeLevel.root.left.left = new TreeNode(4);
        treeLevel.root.left.right = new TreeNode(5);

        treeLevel.printLevelOrder();
    }

    private void printLevelOrder() {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Stack<Integer>stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            stack.add(temp.data);

            if(temp.right!=null) {
                queue.add(temp.right);
            }
            if(temp.left!=null) {
                queue.add(temp.left);
            }
        }
        while (!stack.isEmpty()){
//            ans.add(stack.pop());
            System.out.println(stack.pop());
        }
//        return ans;
    }
}
