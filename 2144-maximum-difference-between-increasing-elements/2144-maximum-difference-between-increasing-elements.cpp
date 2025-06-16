// Optimal approach so far

class Solution {
public:
int maximumDifference(vector<int>& nums) {
    int minSoFar = nums[0];
    int maxDiff = -1;

    for (int i = 1; i < nums.size(); i++) {
        if (nums[i] > minSoFar) {
            maxDiff = max(maxDiff, nums[i] - minSoFar);
        } else {
            minSoFar = nums[i];
        }
    }

    return maxDiff;
}
};

// class Solution {
// public:
//     int maximumDifference(vector<int>& nums) {
//         // Approach -1 : Brute force with 2 for loops
        
//         // two pointers -> Approach two
//         int left = 0;
//         int right = 0;
//         int maxi = -1;
//         int n = nums.size();
//         while(right < n){

//             if(left < right && nums[left] < nums[right]){
//                 maxi = max(maxi, nums[right] - nums[left]);
//             }
//             right++;
//         }
//         return maxi;
//     }
// };