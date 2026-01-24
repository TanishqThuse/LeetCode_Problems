class Solution {
public:
    int countPartitions(vector<int>& nums) {
        int n = nums.size();
        vector<int> prefixSum(n, 0); //contains curr element sum
        vector<int> suffixSum(n,0); //contains only forward code
        
        int sum = 0;
        for(int ele : nums) sum += ele;

        prefixSum[0] = 0;
        suffixSum[0] = sum;

        for(int i=1;i<n;i++){ 
            prefixSum[i] += prefixSum[i-1] + nums[i];
            suffixSum[i] = suffixSum[i-1] - nums[i];
        }

        int cnt = 0;
        for(int i=0; i<n-1; i++){
            if((prefixSum[i] - suffixSum[i]) % 2 == 0){
                cnt++;
            }
        }
        return cnt;
    }
};