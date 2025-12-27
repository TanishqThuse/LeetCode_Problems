class Solution {
public:

    int coinChange(vector<int>& coins, int amount) {
        vector<int> dp(amount+1, amount+1);
        // of size amount+1 with max value amount+1

        // to make amount = 0 we need 0 coins
        dp[0] = 0;

        // now for making sum 1 to amount we have to iterate
        for(int sum=1; sum<=amount; sum++){
            for(int coin : coins){
                if(sum - coin >= 0)
                dp[sum] = min(dp[sum], dp[sum-coin] + 1);
            }
        }

        if(dp[amount] > amount) return -1;
        return dp[amount];
    }

    // Greedy doesnt look like the solution to this problem
    // // Approach -1 : sorting + greedy 
    // int coinChange(vector<int>& coins, int amount) {
    //     int n = coins.size();
    //     sort(coins.rbegin(), coins.rend());

    //     int j=0;
    //     int ans = 0;
    //     int cnt = 0;
    //     while(amount > 0 && j<n){
    //         int currCoin = coins[j];
            
    //         if(amount >= currCoin){
    //             int totalCoins = amount / currCoin; 
    //             cnt += totalCoins;
    //             amount = amount % currCoin;
    //         }
    //         else{
    //             j++;
    //         }
    //     }

    //     if(amount == 0){
    //         return cnt;
    //     }
    //     return -1;
    // }
};