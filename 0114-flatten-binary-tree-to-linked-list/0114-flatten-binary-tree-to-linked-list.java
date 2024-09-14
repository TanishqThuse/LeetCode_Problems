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

    public void helper(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val); 
        helper(root.left, list); 
        helper(root.right, list); 
    }

    public void flatten(TreeNode root) {
        //convert the root to a List (actual one)
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return;
        }
        // TreeNode temp = 
        helper(root, list);

        buildTree(root, list,1);
    }

    public void buildTree(TreeNode root, List<Integer> list, int i){
        if(i == list.size()){
            return;
        }

        root.left = null;
        nullify(root.left);
        if(root.right == null){
            TreeNode newNode = new TreeNode();
            root.right = newNode;
        }
        root.right.val = list.get(i);
        buildTree(root.right, list, i+1);
    }

    public void nullify(TreeNode root){
        if(root==null){
            return;
        }
        // if(root.right){
            
        // }
        root.left=null;
        root.right = null;
    }
}