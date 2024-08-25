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
        ArrayList<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        /**Revision : 
            1)Preorder : Root, left, right
            2)Inorder : left, root, right
            3)PostOrder : left,right,Root
         */
        if(root == null){
            return list;
        }
        
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);

        return list;
    }
}