//Appraoch 2 : My Favourie approach
//Iteratire + Memo
// (botom up)
class Solution{

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            memo[i+1] = Math.max(memo[i], memo[i-1] + val);
        }
        return memo[nums.length];
}
}

//Appraoch 1 : Recursion : Top Down
//Outcome : TLE
// class Solution{
//     public int rob(int[] nums) {
//     return rob(nums, nums.length - 1);
//     }
//     private int rob(int[] nums, int i) {
//         if (i < 0) {
//             return 0;
//         }
//         return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
//     }
// }


// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         List<Integer> dp;
//         // dp = nums[0];
//         for(int i=1; i<n/2; i++){
//             dp.put(dp.getOrDefault(i,0)+ Math.max(nums[i], nums[i-1]));   
//         }

//         return dp.get(dp.size()-1);
//     }
// }