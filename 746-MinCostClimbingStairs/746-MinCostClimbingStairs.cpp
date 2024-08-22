class Solution {
public:

    // //Solved by Memoization my goal is to solve with tabulation
    // int Memo(vector<int>& dp, int n, vector<int> & cost){
        
    //     //MEMOIZATION + Recursion
    //     //BASE CASE
    //     if(n==0){
    //         return cost[0];
    //     }

    //     if(n==1){
    //         return cost[1];
    //     }

    //     if(dp[n]!=-1){
    //         return dp[n];
    //     }

    //     //calculate dp
    //     //it is the cost at the ith index
    //     dp[n] = cost[n] + min(Memo(dp, n-1, cost) , Memo(dp, n-2, cost));
    //     return dp[n];
    // }

    //Solvin by using tabulation
    int tabulation(vector<int>& cost, int n){
        vector<int> dp(n+1);

        //base conditions
        dp[0] = cost[0];
        dp[1] = cost[1];

        //simple looop
        for(int i=2; i<n; i++){
            dp[i] = cost[i] + min(dp[i-1], dp[i-2]);
        }

        //return solution
        // return dp[n]; //wrong how can we return dpn where the last value of omputation was dp[n-1]

        // dp[n] = ##Basically the min of dp[n-1] && dp[n-2] as per ou condition whre cost[n] is invalid/not applicable

        dp[n] = min(dp[n-1], dp[n-2]);
        return dp[n];

    }

    int minCostClimbingStairs(vector<int>& cost) {
        int n = cost.size();

        //Tabulation
        return tabulation(cost, n);
        //we cannot directy return our ans

        //the reason is because cost is of n size and dp is of size n+1
        //so we must calculate the last (n+1th value ==> nth value in 0indexing in main function)
        //Edit : I decided to do this in called function itself since i dont have acces to its dp

        //WRONG direction
        // //so here we go
        // int ans = /*cost[n]*/ + min(tabulation())

        //Memoization
        // vector<int> dp(n+1, -1);
        // int ans = min(Memo(dp, n-1, cost), Memo(dp, n-2, cost));
        // return ans;
    }
};