// Time : O(n log n) + O(n) = O(n log n)
// SPace : O(n) for result storage

class Solution {
public:
    bool checkCondition(vector<int>& temp, int k){
        return temp[2] - temp[0] <= k;
    }

    vector<vector<int>> divideArray(vector<int>& nums, int k) {
        int n = nums.size();
        sort(nums.begin() , nums.end());
        vector<vector<int>> res;
        vector<vector<int>> empty;
        int cnt = 0;
        vector<int> temp;
        for(int i=0; i<n; i++){
            temp.push_back(nums[i]);
            cnt++; //0,1 ; 1,2 ; 2,3
            if(cnt % 3 == 0){
                // cnt = 0;
                if(checkCondition(temp, k)){
                    res.push_back(temp);
                }
                else{
                    return empty;
                }
            temp.clear();
            }
        }
        return res;
    }
};