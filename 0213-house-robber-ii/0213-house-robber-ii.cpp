class Solution {
public:
    // Helper function to use Tabulation DP on a linear list of houses
    int robLinear(vector<int>& nums, int start, int end) {
        if (start == end) return nums[start];

        vector<int> dp(end - start + 1);
        dp[0] = nums[start];
        dp[1] = max(nums[start], nums[start + 1]);

        for (int i = 2; i <= end - start; i++) {
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }
        return dp[end - start];
    }

    int rob(vector<int>& nums) {
        int n = nums.size();
        if (n == 1) return nums[0];

        // Exclude last house
        int option1 = robLinear(nums, 0, n - 2);
        // Exclude first house
        int option2 = robLinear(nums, 1, n - 1);

        return max(option1, option2);
    }
};


// class Solution {
// public:
//         // since neighboursing houses have security ssytem connected dont simply rob past 2 houses, loop this from left to right and from right to left
//     // also since the houses are circled means we can either take hosue 1 or last house

//     // the linear house solution BUT we are actually seeing the last or second last
//     int robLinear(vector<int>& nums, int start,  int end){
//         if(start == end){
//             return nums[start];
//         }

//         vector<int> dp(end - start + 1);
//         dp[0] = nums[start];
//         dp[1] = max(nums[start], nums[start + 1]);

//         for(int i=2; i <=end - start; i++){
//             // notice how we are skipping an additional elemebt ub tgus case
//             dp[i] = max(dp[i-1], dp[i-2] + nums[start + i]);    
//         }
//         return dp[end - start];
//     }
    
//     int rob(vector<int>& nums) {
//         int n = nums.size();

//         int takeFirst = robLinear(nums, 0, n-2);

//         int takeLast = robLinear(nums, 1, n-1);

//         return max(takeFirst , takeLast);
//     }
// };