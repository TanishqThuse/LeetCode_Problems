// Method-1 : DP SOlution
class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<vector<int>> dp(m, vector<int>(n));
        
        // all top rows first make it 1
        for(int j=0; j<n; j++){
            dp[0][j] = 1;
        }

        // now make all thw coloumds as 1
        for(int i=0; i<m; i++){
            dp[i][0] = 1;
        }

        // now we iterate and check for the left and top values
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
};