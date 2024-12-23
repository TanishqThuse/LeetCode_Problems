
//Approach 1: Hash Map
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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int totalSwaps = 0;

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            int[] levelValues = new int[levelSize];
            for(int i=0; i<levelSize; i++){
                TreeNode node = queue.poll();
                levelValues[i] = node.val;

                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }

                /**One of the most useful algorithm we are gonna use is the cycle sort algorithm
                Basically in this ago we will compare the original array to the sorted array and basically check which array element is in its required sorted place or not if it is in its sorted place then no need to sort f it i not in its sored oace then we have to swap it with tthe eement whih is at its sorted place and for that we get the getMinSwaps fnction which makes our work etremenyl easy  */
            }
            totalSwaps += getMinSwaps(levelValues);
        }
        return totalSwaps;
    }
    //Calculate min swaps needed to sort an array
    private int getMinSwaps(int[] original)
    {
        int swaps = 0;     
        int[] target = original.clone();
        Arrays.sort(target);

        //Map we have created to rack the current position of values
        Map<Integer, Integer> pos = new HashMap<>();
        for(int i=0; i<original.length; i++){
            pos.put(original[i], i);
        }

        //For each position, swap until correct value is placed
        for(int i=0; i<original.length; i++){
            if(original[i] != target[i]){
                swaps++;
            }

            //Update position of swapped values for the original array
            int curPos = pos.get(target[i]);
            pos.put(original[i], curPos);   
            original[curPos] = original[i]; //swap with the other element            
        }

        return swaps;
    }
}