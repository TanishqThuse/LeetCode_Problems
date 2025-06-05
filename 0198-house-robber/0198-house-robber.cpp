// Using memoization(top - down)
class Solution {
public:
    int solve(int i, vector<int>& nums, vector<int>& dp) {
        if(i < 0) return 0;               // No houses left
        if(dp[i] != -1) return dp[i];     // Return memoized result

        // Either rob this house and skip previous, or skip this house
        int rob = nums[i] + solve(i - 2, nums, dp);
        int skip = solve(i - 1, nums, dp);

        return dp[i] = max(rob, skip);
    }

    int rob(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(n, -1);
        return solve(n - 1, nums, dp);
    }
};



// // Method : using dp (dynamic programming apporach) -> Tabulation
// class Solution {
// public:
//     int rob(vector<int>& nums) {
//         // Tabulation Approach
//         int n = nums.size();

//         // vector<int> dp(n+1);
//         int dp[n+1];
//         dp[0] = nums[0];

//         for(int i=1; i<n; i++){
//             if(i-2 >= 0){
//                dp[i] = max(dp[i-1], dp[i-2] + nums[i]);
//             }
//             else{
//                 dp[i] = max(dp[i-1], nums[i]);
//             }
//         }

//         return dp[n-1];
//     }
// };