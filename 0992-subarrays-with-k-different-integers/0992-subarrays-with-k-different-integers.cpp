class Solution {
public:
    int atMostK(vector<int>& nums, int k){
        int n = nums.size();
        int l = 0;
        int r = 0;
        int cnt = 0;
        map<int, int> mpp;
        for(r=0; r<n; r++){
            // if too many we increment l
            mpp[nums[r]]++;

            // since i am taking atMost i will accept the lower and equal parts as well
            while(mpp.size() > k){
                mpp[nums[l]]--;
                if(mpp[nums[l]] == 0) mpp.erase(nums[l]);
                l++;
            }

            cnt += (r-l+1);
        }
        return cnt;
    }

    int subarraysWithKDistinct(vector<int>& nums, int k){
        return atMostK(nums,k) - atMostK(nums, k-1);
    }

    // Approach - 1 : but works for single part only
    // int subarraysWithKDistinct(vector<int>& nums, int k) {
    //     int n = nums.size();
    //     int cnt = 0;
    //     int curr = 0;
    //     int l = 0;
    //     int r = 0;
    //     map<int,int> mpp;
    //     while(l <= r && r<n){
            
    //         // check the count
    //         // if have an equal number 
    //         if(mpp.size() == k){
    //             // increase cnt
    //             cnt++;
    //             r++; //we still would have to go ahead right
    //             mpp[nums[r]]++;
    //         }
    //         else if(mpp.size() < k){
    //             // add more elements, i.e the rightmost element
    //             r++;
    //             mpp[nums[r]]++;
    //         }
    //         else{
    //             // we need to remove the leftmost element
    //             mpp[nums[l]]--;
    //             if (mpp[nums[l]] == 0) mpp.erase(nums[l])
    //             l++;
    //         }          
    //     }
    //     return cnt;
    // }
};