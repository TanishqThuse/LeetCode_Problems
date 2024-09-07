class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= nums.length - 1; i++) {
            if (prefix == 0)
                prefix = 1;
            if (suffix == 0)
                suffix = 1;
            prefix = prefix * nums[i];
            suffix = suffix * nums[nums.length - 1 - i];
            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;

    }

}

//The very simple but effective test case i forgot about is : 
// nums = [-2,3,-4]
// // //Approach 2 : Dp
// class Solution {
//     public int maxProduct(int[] nums) {

//         int n = nums.length;
        
//         if(n <= 1){
//             return nums[0];
//         }

//         int[] dp = new int[n];

//         dp[0] = nums[0]*nums[1];

//         for(int i=1; i<n; i++){
//             dp[i] = Math.max(Math.max(dp[i-1], nums[i]*nums[i-1]), nums[i]);
//         }

//         return dp[n-1];
//     }
// }