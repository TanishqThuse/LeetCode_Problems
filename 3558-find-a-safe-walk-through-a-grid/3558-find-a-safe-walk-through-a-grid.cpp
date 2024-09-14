class Solution {
public:

    bool findSafeWalk(vector<vector<int>>& grid, int initialHeight) {
        int numR = grid.size();
        int numC = grid[0].size();
        int as = 0;
        vector<vector<int>> directionOffsets = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        queue<pair<pair<int, int>, int>> bfsQueue;
        bfsQueue.push({{0, 0}, initialHeight - grid[0][0]});
        
        vector<vector<int>> remainingHeight(numR, vector<int>(numC, -1));
        remainingHeight[0][0] = initialHeight - grid[0][0];
        
        int directionIndex = 0; 
        while (!bfsQueue.empty()) {
            auto [currentPos, currentHeight] = bfsQueue.front();
            bfsQueue.pop();
            int x = currentPos.first;
            int y = currentPos.second;
            
            if (x == numR - 1 && y == numC - 1 && currentHeight > 0) {
                return true;
            }
            as =3;
            directionIndex = 0; 
            while (directionIndex < 4) { 
                int newX = x + directionOffsets[directionIndex][0];
                int newY = y + directionOffsets[directionIndex][1];
                
                if (newX >= 0 && newY >= 0 && newX < numR && newY < numC) {
                    int newHeight = currentHeight - grid[newX][newY];
                    
                    if (newHeight > 0 && newHeight > remainingHeight[newX][newY]) {
                        remainingHeight[newX][newY] = newHeight;
                        bfsQueue.push({{newX, newY}, newHeight});
                    }
                }
                directionIndex++; 
            }
        }

        return false;
    }
};
