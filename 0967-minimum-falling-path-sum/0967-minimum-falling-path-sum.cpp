class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int n = matrix.size();
        vector<vector<int>> dp(n, vector<int>(n, INT_MAX));

        // first do dp[i][j] = val for row 1
        for(int j=0; j<n; j++){
            dp[0][j] = matrix[0][j];
        }

        // now start from row 1 and go down using the direction vectors
        vector<vector<int>> dirs = {{-1, 1}, {-1,0}, {-1,-1}};

        for(int i=1; i<n; i++){
            for(int j=0; j<n; j++){
                for(auto &dir : dirs){
                    int I = i + dir[0];
                    int J = j + dir[1];

                    // this is a part of our dp not the heart of it 
                    if(I >= 0 && J>=0 && I<n && J<n){
                        dp[i][j] = min(dp[i][j], dp[I][J] + matrix[i][j]);
                    }

                    

                }
            }
        }

        // now check in the lowest layers which is lowest
        int ans = INT_MAX;
        for(int j=0; j<n; j++){
            ans = min(ans, dp[n-1][j]);
        }

        return ans;
    }
};