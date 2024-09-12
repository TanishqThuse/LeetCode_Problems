class Solution{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        //My idea is i folllow normal bfs for this problem howveer aftwr end of nested while op immma gonna check if this time we have to add leftToRight ot RightOrLeft depending on that will do Collections.sort() thing

        boolean leftToRight = true;

        queue.offer(root);

        // leftToRight = false;
        //this above statement is ery deep 
        //since we have traversed the 1st level by adding root

        while(!(queue.isEmpty())){
            List<Integer> tempList = new ArrayList<>();
            int size = queue.size();
            while(size-->0){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }

                //now add the element to the tempList
                tempList.add(node.val);
            }
            if(leftToRight){
                res.add(tempList);
            }
            else{
                Collections.reverse(tempList);
                res.add(tempList);
            }
            // leftToRight = !(leftToRight);
            leftToRight = !leftToRight;
        }
        return res;
    }
}

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
// class Solution {
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         //Very very similar to binary tree level order traversal just the differenec is here we add left, right in case-1 then we add right, left in case-2
//         List<List<Integer>> list = new ArrayList<>();
//         if(root==null){
//             return list;
//         }

//         Queue<TreeNode> queue = new LinkedList<TreeNode>();

//         boolean addLeft = true;

//         queue.offer(root);

//         addLeft = !(addLeft); //since adding the root is considered as traversing from left to right

//         while(!(queue.isEmpty())){
//             List<Integer> tempList = new ArrayList<>();
//             int level = queue.size();
//             while(level-->0){
//                 TreeNode currNode = queue.poll();
//                 if(addLeft){
//                     //our standard way of first adding left then right
//                     if(currNode.left!=null){
//                         queue.offer(currNode.left);
//                     }
//                     if(currNode.right!=null){
//                         queue.offer(currNode.right);
//                     }
//                 }
//                 else{
//                     //mentos zindagi
//                     if(currNode.right!=null){
//                         queue.offer(currNode.right);
//                     }
//                     if(currNode.left!=null){
//                         queue.offer(currNode.left);
//                     }
//                 }
//                 tempList.add(currNode.val);
//             }
//             list.add(tempList);
//             addLeft = !(addLeft);
//         }
//         return list;
//     }
// }