// Tabulation like builidng a building start from base(here the base case) and go to top, memoization is opposite

// Memoization
class Solution {
public:
    int solve(int n, vector<int>& dp) {
        if(n <= 1) return 1;

        if(dp[n] != -1) return dp[n]; // Already computed
        return dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
    }

    int climbStairs(int n) {
        vector<int> dp(n + 1, -1); // Initialize with -1 (uncomputed)
        return solve(n, dp);
    }
};


// Tabulation
// class Solution {
// public:
//     int climbStairs(int n) {
//         vector<int> dp(n+1);

//         dp[0] = 1;
//         // ground,1,2,{3}.{5}
//         // dp[n] = dp[n-1] + dp[n-2]
//         for(int i=1; i<n+1; i++){
//             if(i-2>=0){
//                 dp[i] = dp[i-1] + dp[i-2];
//             }
//             else{
//                 dp[i] = dp[i-1];
//             }
//         }
//         return dp[n];
//     }
// };