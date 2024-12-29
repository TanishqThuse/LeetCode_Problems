// //This program looks like it could be solved by Greedy and DP

// //Greedy solution
// class Solution {
//     public boolean canJump(int[] nums) {
//         int n = nums.length;
//         int maxJumpIndex= 0;
//         for(int i=0; i<n; i++){
//             if(i<=maxJumpIndex){
//                 int jumping = i+nums[i];
//                 maxJumpIndex = Math.max(maxJumpIndex, jumping );
//             }
//             else{
//                 return false;
//             }
//         }
//         return true;
//     }
// }

//Approach - 2 : 
class Solution {
    public boolean canJump(int[] nums) {
       int reachable = 0;
       for(int i = 0; i < nums.length; i ++) {
           if(i > reachable) return false;
           reachable = Math.max(reachable, i + nums[i]);
       } 
       return true;
    }
}