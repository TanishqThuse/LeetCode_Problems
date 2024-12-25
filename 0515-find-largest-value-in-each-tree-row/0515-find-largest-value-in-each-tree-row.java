/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null) queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            // TreeNode curr = queue.poll();
            // List<Integer> tempList = new ArrayList<>();
            int max = Integer.MIN_VALUE;;
            while(size-->0){
                TreeNode curr = queue.poll();
                // tempList.add(curr.val);
                max = Math.max(curr.val, max);
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
            list.add(max);
        }
        return list;
    }
}