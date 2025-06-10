class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        // bfs related question
        int n = grid.size();
        int m = grid[0].size();

        queue<pair<int,int>> queue;
        // vector<vector<bool>> visited(n,m);
        int fresh = 0;
        int minutes = -1; //very imposince the loop goes one extra bfs coz when last queue is emtpeid it doesnt not add any other elements but indeeed counted one extra loop

        int rotten = 0; //coz of edge case

        //first go throught the grid to check for rotten oragnegs
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                // i rotten put in queue
                if(grid[i][j] == 1){
                    fresh++;
                }
                else if(grid[i][j] == 2){
                    queue.push({i,j});
                    rotten++;
                }
            }
        } 

        vector<pair<int,int>> dirs = {{1,0},{0,1},{-1,0},{0,-1}};

        // now loop using the queue
        while(!queue.empty()){
            // get the element rom the queue
            // this declaration of size is imp since we wanna know the elements present in the queue per second
            int size = queue.size();

            while(size-->0){
                auto [x,y] = queue.front();
                queue.pop();

                // no dealing with the dirs vector
                for(auto [dx, dy] : dirs){
                    int i = x + dx;
                    int j = y+ dy;
                    if(i>=0 && i<n && j>=0 && j<m && grid[i][j] == 1){
                        grid[i][j] = 2;
                        fresh--;
                        queue.push({i,j});
                        rotten++;
                    }
                }
            }
            minutes++;
            
        }
        if(fresh==0) {
            if( rotten==0)
                return 0;
            return minutes;
        }
        return -1;
    }
};