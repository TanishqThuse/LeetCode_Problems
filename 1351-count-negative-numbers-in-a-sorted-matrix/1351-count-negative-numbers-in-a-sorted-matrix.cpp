class Solution {
public:
    int countNegatives(vector<vector<int>>& grid) {
        
        // Appraocg - 2 : staircase method
        // O(m+n)
        int m = grid.size();
        int n = grid[0].size();

        int j=0;
        int i = m-1;
        int res = 0;
        while(i>=0 && j<n){
            if(grid[i][j] < 0){
                res += n-j;
                i--;
            }
            else{
                j++;
            }
        }
        return res;
        
        // Approach - 1 : Brute force
        // // brute force 
        // int m = grid.size();
        // int n = grid[0].size();
        // int cnt = 0;
        // for(int i=0; i<m; i++){
        //     for(int j=0; j<n; j++){
        //         if(grid[i][j] < 0){
        //             cnt++;
        //         }
        //     }
        // }
        // return cnt;
    }
};