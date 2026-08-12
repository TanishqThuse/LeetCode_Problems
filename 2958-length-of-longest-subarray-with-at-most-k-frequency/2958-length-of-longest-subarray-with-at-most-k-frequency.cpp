class Solution {
public:
    int maxSubarrayLength(vector<int>& nums, int k) {
        int n = nums.size();

        unordered_map<int, int> mpp;
        int l = 0;
        int ans = 0;
        // tC : O(n*1*(L<)*M) = O(NM)
        for(int r=0; r<n; r++){                             //O(n) times run 
            mpp[nums[r]]++;     

            if(mpp[nums[r]] > k){
                // this makes it a bad subarray 
                // coz it should be <=k
                // now we will have to remove from
                //  left and go till the point
                //  where the new maxi is less
                while(mpp[nums[r]] > k){
                    mpp[nums[l]]--;
                    l++;
                }
            }
            ans = max(ans , r-l+1);
        }
        return ans;
    }
};