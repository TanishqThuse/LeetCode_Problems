class Solution {
public:
    int nearestDrone(vector<vector<int>>& drones, vector<int>& target) {
        int min_dist = INT_MAX;
        int n = drones.size();
        int ans = -1;
        for(int i=0; i<n; i++){
            // chcek with target
            int x = abs(drones[i][0] - target[0]);
            int y = abs(drones[i][1] - target[1]);
            int range = drones[i][2];
            int dist = x+y;
            if(dist <= range){
                if(min_dist > dist){
                    ans = i;
                    min_dist = dist;
                }
            }
        }
        return ans;

    }
};