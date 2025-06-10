class Solution {
public:
    int minimumTotal(vector<vector<int> > &triangle) {
    int n = triangle.size();
    vector<int> minlen(triangle.back());
    for (int layer = n-2; layer >= 0; layer--) // For each layer
    {
        for (int i = 0; i <= layer; i++) // Check its every 'node'
        {
            // Find the lesser of its two children, and sum the current value in the triangle with it.
            minlen[i] = min(minlen[i], minlen[i+1]) + triangle[layer][i]; 
        }
    }
    return minlen[0];
}
    // int minimumTotal(vector<vector<int>>& triangle) {
        
    //     int n = triangle.size();
    //     vector<int> dp(triangle.back()); //initialise with the lowest layer
    //     // dp[0] = triangle[0][0];

    //     for(int i=n-2; i>=0; i--){
    //         for(int j=0; j<=i; j++){
    //             // find the min
    //             dp[i] = min(dp[i], dp[i+1]) + triangle[i][j];
    //         }
    //     }

    //     return dp[0];


    // }
};

// class Solution {
// public:
//     int minimumTotal(vector<vector<int>>& triangle) {
//         int n = triangle.size();
//         vector<int> dp(n, INT_MAX);
//         dp[0] = triangle[0][0];

//         for(int i=1; i<n; i++){
//             int lower = i;
//             int upper = triangle[i].size();
//             for(int j=0; j<triangle[i].size(); j++){
//                 if(j>=lower && j<=upper){
//                     dp[i][j] = min(dp[i][j], )
//                 } 
//             }
//         }

//         return dp[n-1];
//     }
// };