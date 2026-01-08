class Solution {
public:
    int maxDotProduct(vector<int>& nums1, vector<int>& nums2) {
        // find sum, find total-sum would have been useful if dot product was not there
        // now we can use dp 
        int n = nums1.size();
        int m = nums2.size();

        vector<vector<int>> dp(n, vector<int>(m,INT_MIN));

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int curr = nums1[i] * nums2[j];

                if(i>0 && j>0){
                    curr = curr+max(0, dp[i-1][j-1]);
                }

                dp[i][j] = curr;

                if(i>0){
                    dp[i][j] = max(dp[i-1][j], dp[i][j]);
                }
                if(j>0){
                    dp[i][j] = max(dp[i][j-1], dp[i][j]);
                }   
            }
        }
            return dp[n-1][m-1];


    }
};