/*Time Complexity:

    Time: O(n) â each element is added and removed at most once.

    Space: O(1) â max 3 entries in the map (since only 2 fruit types allowed, the map can briefly go to 3).*/

class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        int left = 0;
        int right = 0;
        int n = fruits.size();
        int maxi = 0;
        map<int, int> freq;
        while(right<n){
            freq[fruits[right]]++;                        
            if(freq.size() > 2){
                // now we gotta iterate
                // since we are not dependent on k and left<=right will hold true always in THIS IF CONDITION so we dont have to worry about that
                while(freq.size() > 2){
                    freq[fruits[left]]--;
                    if(freq[fruits[left]] == 0){
                        freq.erase(fruits[left]);
                    }
                    left++;
                }
            }
            maxi = max(right - left + 1, maxi);
            right++;
        }
        return maxi;
    }
};