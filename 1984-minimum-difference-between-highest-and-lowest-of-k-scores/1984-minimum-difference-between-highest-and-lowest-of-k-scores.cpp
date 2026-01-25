    class Solution {
    public:
        // Approach -2 : 1 byt changed
        // + SLIDING WINDOW
        // SINCE THIS IS SORTED ARRAY WE CAN SIMPLY CHEKC YTHE FIRST AND THE LAST ELEMENT NOT ANY ONE WE CARE
        int minimumDifference(vector<int>& nums, int k) {
            // simple : sort and check at 0th or n-1th
            int n = nums.size();
            // vector<int> copy = nums;
            sort(nums.begin(), nums.end());
            int ans = INT_MAX;

            for(int i=0 ; i+k-1 < n ;  i++)
            {
                ans = min(ans, nums[i + k - 1] - nums[i]);
            }

            return ans;

        }



        // Approiach - 1 : failued wrong ans
        // reason i only check the first and last k but niot the ones in the middle
        // int minimumDifference(vector<int>& nums, int k) {
        //     // simple : sort and check at 0th or n-1th
        //     int n = nums.size();
        //     // vector<int> copy = nums;
        //     sort(nums.begin(), nums.end());
        //     int minDiff = INT_MAX;
        //     int maxi = INT_MIN, mini=INT_MAX;
        //     for(int i=0; i<n && i<k; i++){
        //         maxi = max(maxi, nums[i]);
        //         mini = min(mini, nums[i]);
        //     }
        //     minDiff = min(minDiff, maxi-mini);

        //     maxi = INT_MIN;
        //     mini = INT_MAX;

        //     int cnt =0 ;
        //     for(int i=n-1; i>=0 && cnt < k; i--){
        //         mini = min(mini, nums[i]);
        //         maxi = max(maxi, nums[i]);
        //         cnt++;
        //     }

        //     return min(minDiff, maxi-mini);
        // }
    };