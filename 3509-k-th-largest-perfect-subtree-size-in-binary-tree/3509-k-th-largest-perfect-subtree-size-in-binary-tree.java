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

//Try- 4
public class Solution {
    private int[] dfs(TreeNode node, List<Integer> sizes) {

        //0th elemetn is a boolean value which tellls whether it is perfect or not
        //1st leement is size (current)

        if (node == null) return new int[] { 1, 0 };

        int[] left = dfs(node.left, sizes);
        int[] right = dfs(node.right, sizes);

        //bascially check if left and right both are perfect binary trees
        //and it so , then check if size of left == size of right binary trees

        if (left[0] == 1 && right[0] == 1 && left[1] == right[1]) {
            int currentSize = left[1] + right[1] + 1;
            sizes.add(currentSize);
            return new int[] { 1, currentSize };
        }

        return new int[] { 0, 0 };
        //it root is not perfect we return 0
    }

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        List<Integer> sizes = new ArrayList<>();
        dfs(root, sizes);
        sizes.sort(Collections.reverseOrder());

        if (sizes.size() < k) return -1;

        return sizes.get(k - 1);
    }
}

// class Solution{

//     List<Integer> subTreeSize = new ArrayList<>();

//     public int kthLargestPerfectSubtree(TreeNode root, int k) {
//         helper(root,k,0);
//     }

//     public int helper(TreeNode root){
//         if(root == null){
//             return 0;
//         }

//         int leftSize = helper(root.left);
        
//     }
// }

// // class Solution {
// //     int max = 0;

// //     public int kthLargestPerfectSubtree(TreeNode root, int k) {
// //         helper(root,k,0);
// //     }

// //     public int kthLargestPerfectSubtree(TreeNode root, int k) {
// //         if(root == null){
// //             max = Math.max(1,max);
// //             return 1;
// //         }

// //         if(root.left != null && root.right != null){
            
// //         }

// //     }
// // }