class Solution {
public:
    int checkDivision(int mid, vector<int>& nums){
        int sum = 0;
        for(int i=0; i<nums.size(); i++){
            sum += ceil((double)nums[i] / mid);
        }
        return sum;
    }

    int smallestDivisor(vector<int>& nums, int threshold) {
        int maxi = *max_element(nums.begin(), nums.end());
        int n = nums.size();
        // vector<int> arr(n);
        // for(int i=0; i<n; i++){
        //     arr[i] = i+1;
        // }   

        int left = 1;
        int right = *max_element(nums.begin(), nums.end());
        int ans = -1;
        while(left <= right){
            int mid = (left+right)/2;
            // check for mid, if satisfy go back for optimal, else go ahed
            // actual confition check
            int sum = checkDivision(mid, nums);
            if(sum <= threshold){
                // try smaller
                ans = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return ans;
    }
};