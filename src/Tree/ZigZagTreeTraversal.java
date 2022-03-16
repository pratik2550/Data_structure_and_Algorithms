package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTreeTraversal {

    static TreeNode root;

    public static void main(String[] args) {
        ZigZagTreeTraversal treeLevel = new ZigZagTreeTraversal();
        treeLevel.root = new TreeNode(1);
        treeLevel.root.left = new TreeNode(2);
        treeLevel.root.right = new TreeNode(3);
        treeLevel.root.left.left = new TreeNode(4);
        treeLevel.root.left.right = new TreeNode(5);

        treeLevel.zigZagTreeTraversal(root);
    }

    private void zigZagTreeTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        queue.add(root);
        boolean ltr = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int arr[] = new int[size];
            for (int i=0; i<size; i++) {
                TreeNode temp = queue.poll();

                int index = ltr?i:(size-1-i);

                arr[index] = temp.data;
                if (temp.left!=null) {
                    queue.add(temp.left);
                }
                if (temp.right!=null) {
                    queue.add(temp.right);
                }
            }
            ltr = !ltr;
            for (int i:arr) {
                ans.add(i);
            }
        }
        for (int i:ans) {
            System.out.println(i);
        }
    }
}
