//One nice recursive DFS approach
class Solution{
    public TreeNode reverseOddLevels(TreeNode root){
        helper(root.left, root.right, 0);
        return root;
    }

    public void helper(
        TreeNode left,
        TreeNode right,
        int level
    ) {
        if(left == null || right == null){
            return ;
        }
        if(level%2==0){
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }

        helper(left.left, right.right, level+1);
        helper(left.right, right.left, level+1);
    }
}

//Wrong logic I dicided to make the cahnge by standing at their parent but that is now how it works
// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
//  //Recursive apporahc
// class Solution {
//     public void helper(TreeNode root, int count){
//         if(root==null){
//             return ;
//         }
        
//         //incrememt to curent level
//         count++;
//         //if the current level is odd, then it's children are reverse
//         if(root.left != null && count%2!=0){
//             int temp = root.left.val;
//             root.left.val = root.right.val;
//             root.right.val = temp;
//         }
//         helper(root.left, count);
//         helper(root.right, count);
//     }

//     public TreeNode reverseOddLevels(TreeNode root) {
//         int count = 0 ;
//         helper(root, count);
//         return root;
//     }
// }