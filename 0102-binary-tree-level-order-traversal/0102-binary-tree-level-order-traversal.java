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
// 
    // ArrayList<Integer> list = new ArrayList<Integer>;

    // public List<List<Integer>> levelOrderEachStage(TreeNode root,TreeNode left, TreeNode right){
        
    // }

    public List<List<Integer>> levelOrder(TreeNode root) {
        // Queue<Integer> q = new Queue<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root==null) return list;

        Queue<TreeNode> queue= new LinkedList<TreeNode>();

        queue.offer(root);

        while(!(queue.isEmpty())){
            List<Integer> tempList = new ArrayList<>();
            int size = queue.size();

            while(size-->0)
            {
                TreeNode currNode = queue.poll();
                if(currNode.left!=null){
                    queue.offer(currNode.left);
                }
                if(currNode.right!=null){
                    queue.offer(currNode.right);
                }
                tempList.add(currNode.val);
            }
            list.add(tempList);
        }
        return list;

    }
}