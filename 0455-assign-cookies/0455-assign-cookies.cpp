class Solution {
public:
    // Apporahc - 2 : OS level memoery management analogy : best first

    // Appaoch - 1 : sort and direct assign
    int findContentChildren(vector<int>& g, vector<int>& s) {
        int n = g.size();
        int m = s.size();

        // O(nlogn) sorting
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());

        // O(n^2) loops
        // i should first select a cookie s give it direcly to the child in g
        int cnt = 0;
        int j = 0;
        for(int i=0; i<m && j<n; i++){
            if(s[i] >= g[j]){
                cnt++;
                j++;
            } 
            // else{
            //     break;
            // }
        }
        return cnt;
    }
};