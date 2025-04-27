class Solution {
public:
    int countSubarrays(vector<int>& nums) {
        // sime time constraints are pretty low we can do brute force
        int n = nums.size();
        // the complexity is O(n)
        int cnt = 0;
        for(int i=0; i<n-2; i++){
            if((double)(nums[i] + nums[i+2]) == (nums[i+1]/2.0)){
                cnt++;
            }
        }
        return cnt;
    }
};