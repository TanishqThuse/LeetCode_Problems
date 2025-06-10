class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        
        vector<vector<int>> dp(m, vector<int>(n, 0));

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int fromUp = (i > 0) ? dp[i - 1][j] : INT_MAX;
                int fromLeft = (j > 0) ? dp[i][j - 1] : INT_MAX;

                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j]; // Starting cell
                } else {
                    dp[i][j] = grid[i][j] + min(fromUp, fromLeft);
                }
            }
        }

        return dp[m - 1][n - 1];
    }
};


// class Solution {
// public:
//     int minPathSum(vector<vector<int>>& grid) {
//         int m = grid.size();
//         int n = grid[0].size();

//         vector<vector<int>> dp(m, vector<int>(n));

//         for(int i=0; i<m; i++){
//             for(int j=0; j<n; j++){
//                 if(i==0 && j==0){
//                     dp[i][j] = grid[i][j];
//                     continue;
//                 }
//                 int up=0;
//                 int left = 0;
//                 if(i>0 && j>0){
//                     dp[i][j] = min(grid[i][j] + dp[i-1][j], grid[i][j]+dp[i][j-1]);
//                 }
//                 else if(j>0){
//                     // possible to take value from left
//                     left = dp[i][j-1];
//                     dp[i][j] = grid[i][j] + left;
//                 }
//                 else{
//                     // it is possible to take values from up
//                     up = dp[i-1][j];
//                     dp[i][j] = grid[i][j] + up;
//                 }
//             }
//         }

//         return dp[m-1][n-1];
//     }
// };