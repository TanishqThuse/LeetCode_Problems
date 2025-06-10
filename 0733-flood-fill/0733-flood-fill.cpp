class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int n = image.size();
        int m = image[0].size();

        int idx_pxl = image[sr][sc]; //to change pixels of pixels of the same originla same pixel as it 

        if(idx_pxl == color){
            return image;
        }

        queue<pair<int,int>> q;
        q.push({sr,sc});
        image[sr][sc] = color;

        vector<pair<int,int>> dirs = {{1,0},{0,1},{-1,0},{0,-1}};

        while(!q.empty()){
            int size = q.size();

            while(size-->0){
                auto [x,y] = q.front();
                q.pop();
                for(auto [dx,dy] : dirs){
                    int i = x+dx;
                    int j = y+dy;
                    if(i>=0 && i<n && j>=0 && j<m && image[i][j]==idx_pxl){
                        image[i][j] = color;
                        q.push({i,j});
                    }
                }
              
            }
        }

        return image;
    }
};