class Solution {
    public int maxSubArray(int[] nums) {
        int sum=nums[0];
        int maxi = nums[0];
        int i=1;
        while(i<nums.length){
            sum = Math.max(nums[i],nums[i]+sum);
            maxi = Math.max(sum,maxi);
            i++;
        }
        return maxi;
    }
}

// class Solution {
//     public int maxSubArray(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];

//         dp[0] = nums[0];

//         int ans = dp[0];

//         for(int i=1; i<n; i++){
//             dp[i] = Math.max(nums[i], nums[i]+dp[i-1]);
//             //since we have two choices either take current num or take currentNum + prevSum ==> SO we take max among both

//             ans = Math.max(ans, dp[i]);
//         }

//         return ans;
//     }
// }