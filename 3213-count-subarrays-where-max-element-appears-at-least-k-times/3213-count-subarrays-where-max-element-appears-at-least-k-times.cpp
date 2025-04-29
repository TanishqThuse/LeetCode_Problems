class Solution{
   public:
    long long countSubarrays(vector<int>& nums, int k){
        int n = nums.size();
        long long ans = 0;
        int maxi = *max_element(nums.begin(), nums.end());
        int cnt = 0; //the count of max elements
        int left = 0;
        
        for(int right=0; right<n; right++){
            if(nums[right] == maxi){
                cnt++;
            }

            while(cnt>=k){
                // All subarrays starting at left and anding at right or beofre are eligible
                ans += (n-right);
                if(nums[left] == maxi){
                    cnt--; //reducing the conut of max elements
                }
                left++; //shrink window
            }

        }
        return ans;
    }
};

// Brute force approach -> TIme : O(N^2)
// Passed 613/633 cases
// class Solution {
// public:
//     long long countSubarrays(vector<int>& nums, int k) {
//         int n = nums.size();
//         long long cnt=0;

//         int maxi = INT_MIN;
//         // first we will find the max element
//         for(int ele : nums){
//             maxi = max(maxi, ele);
//         }

//         // let's try brute force approach first
//         for(int i=0; i<n; i++){
//             // int max = nums[i];
//             map<int, int> mpp;
//             mpp[nums[i]]++;
//             if(mpp[nums[i]]==k && nums[i] == maxi){
//                 cnt++;
//             }
//             for(int j=i+1; j<n; j++){
//                 mpp[nums[j]]++;
//                 if(mpp[maxi] >= k){
//                     cnt++;
//                 }
//             }
//         }
//         return cnt;
//     }
// };