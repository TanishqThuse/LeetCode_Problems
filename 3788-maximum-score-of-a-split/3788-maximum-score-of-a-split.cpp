class Solution {
public:
    long long maximumScore(vector<int>& nums) {
        int n = nums.size();
        vector<long long> minVal(n);
        vector<long long> prefixSum(n,0);

        prefixSum[0] = nums[0];
        // minVal[0] = nums[0];

        for(int i=1; i<n; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
            // minVal[i] = min(minVal[i-1], nums[i]);
        }

        minVal[n-1] = INT_MAX;
        for(int i=n-2; i>=0; i--){
            minVal[i] = (long long)min(nums[i+1], (int)minVal[i+1]);
        }

        vector<long long> score(n);
        long long maxi = INT_MIN;
        for(int i=0; i<n-1; i++){
            score[i] = (long long)(prefixSum[i] - minVal[i]);
            // maxi = max(maxi, score[i]);
        }

        // for(int i=)
        for(int i=0; i<n-1; i++){
            maxi = max(maxi, score[i]);
        }

        return maxi;
    }
};