package Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfBinaryTree {

    static TreeNode root;

    public static void main(String[] args) {
        BottomViewOfBinaryTree treeLevel = new BottomViewOfBinaryTree();
        treeLevel.root = new TreeNode(1);
        treeLevel.root.left = new TreeNode(2);
        treeLevel.root.right = new TreeNode(3);
        treeLevel.root.left.left = new TreeNode(4);
        treeLevel.root.left.right = new TreeNode(5);

        treeLevel.bottomViewOfBinaryTreeIterative(root);
    }

    private void bottomViewOfBinaryTreeIterative(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair d = queue.poll();
            TreeNode temp = d.node;
            int l = d.line;
            map.put(l, temp.data);
            if (temp.left != null) {
                queue.add(new Pair(temp.left, l - 1));
            }
            if (temp.right != null) {
                queue.add(new Pair(temp.right, l + 1));
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    private class Pair {
        TreeNode node;
        Integer line;

        Pair(TreeNode node, Integer line) {
            this.node = node;
            this.line = line;
        }
    }
}
