package treebreadthfirstsearch;

import helpers.TreeNode;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class ReverseLevelOrderTraversal {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> levels = new LinkedList<>();
        Queue<TreeNode> nodesToProcess = new LinkedList<>();

        nodesToProcess.offer(root);

        while (!nodesToProcess.isEmpty()) {
            int numNodesToProcess = nodesToProcess.size();
            List<Integer> level = new ArrayList<>();

            while (numNodesToProcess-- > 0) {
                TreeNode currNode = nodesToProcess.poll();

                level.add(currNode.val);

                if (currNode.left != null) {
                    nodesToProcess.offer(currNode.left);
                }

                if (currNode.right != null) {
                    nodesToProcess.offer(currNode.right);
                }
            }

            levels.add(0, level);
        }

        return levels;
    }
}
