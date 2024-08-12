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
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        InorderTraversal(root);
        return res;
    }

    public void InorderTraversal( TreeNode root)
    {
        if(root == null){
            return;
        }
        InorderTraversal(root.left);
        res.add(root.val);
        InorderTraversal(root.right);
    }    
}