class Solution {
public:

    int solveDpMemo(vector<int>& coins, int amount, vector<int>& dp) {
        if (amount == 0) {
            return 0;
        } else if (amount < 0) {
            return INT_MAX;
        }

        if (dp[amount] != -1) {
            return dp[amount];
        }

        int mini = INT_MAX;

        for (int coin : coins) {
            int ans = solveDpMemo(coins, amount - coin, dp);
            if (ans != INT_MAX) {
                mini = min(mini, 1 + ans);
            }
        }

        dp[amount] = mini;
        return dp[amount];
    }

    int coinChange(vector<int>& coins, int amount) {
        vector<int> dp(amount + 1, -1); // Initialize dp array with size amount + 1
        int ans = solveDpMemo(coins, amount, dp);

        return (ans == INT_MAX) ? -1 : ans;
    }
};


// class Solution{
//     public:

//     int solveDpMemo(vector<int>& coins, int amount, vector<int>& dp){
//         int x = amount; //i am lazy
//         if(x==0){
//             return 0;
//         }
//         else if(x<0){
//             return INT_MAX;
//         }

//         if(dp[amount]!=-1){
//             return dp[amount];
//         }

//         int mini = INT_MAX;

//         for(int i=0; i<coins.size(); i++){
//             int ans = solveDpMemo(coins, amount-coins[i], dp);
//             if(ans!=INT_MAX){
//                 mini = min(mini, 1+ans);
//             }
//         }

//         //assign cureent vaue at x dp
//         dp[x] = mini;

//         return dp[x];
//     }

//     int coinChange(vector<int>& coins, int amount) {
//         int n = coins.size();
//         vector<int> dp(n+1,-1);
//         int ans = solveDpMemo(coins, amount, dp);

//         if(ans==INT_MAX){
//             return -1;
//         }
//         else{
//             return ans;
//         }
//     }
// };


// // // This solution give TLE due to Recursion problem not optimla
// // class Solution {
// // public:

// //     int RecMemo(vector<int>& coins, int amount){
// //         int x = amount; //i am lazy
// //         if(x==0){
// //             return 0;
// //         }
// //         else if(x<0){
// //             return INT_MAX;
// //         }

// //         int mini = INT_MAX;

// //         for(int i=0; i<coins.size(); i++){
// //             int ans = RecMemo(coins, amount-coins[i]);
// //             if(ans!=INT_MAX){
// //                 mini = min(mini, 1+ans);
// //             }
// //         }

// //         return mini;

// //     }

// //     int coinChange(vector<int>& coins, int amount) {
// //         int ans = RecMemo(coins, amount);
// //         if(ans==INT_MAX){
// //             return -1;
// //         }
// //         return ans;
// //     }
// // };