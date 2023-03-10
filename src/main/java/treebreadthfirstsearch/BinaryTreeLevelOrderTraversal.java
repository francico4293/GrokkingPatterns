package treebreadthfirstsearch;

import helpers.TreeNode;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> levels = new ArrayList<>();
        Queue<TreeNode> nodesToProcess = new LinkedList<>();

        nodesToProcess.add(root);

        while (!nodesToProcess.isEmpty()) {
            int numberOfNodesToProcess = nodesToProcess.size();
            List<Integer> currLevel = new ArrayList<>();
            while (numberOfNodesToProcess-- > 0) {
                TreeNode node = nodesToProcess.poll();

                currLevel.add(node.val);

                if (node.left != null) {
                    nodesToProcess.offer(node.left);
                }

                if (node.right != null) {
                    nodesToProcess.offer(node.right);
                }
            }

            levels.add(currLevel);
        }

        return levels;
    }
}
