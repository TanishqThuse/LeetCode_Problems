class Solution {
public:
    int digitRange(int num) {
        if (num == 0) return 0;

        int mx = 0;
        int mn = 9;

        while (num > 0) {
            int digit = num % 10;
            mx = max(mx, digit);
            mn = min(mn, digit);
            num /= 10;
        }

        return mx - mn;
    }

    int maxDigitRange(vector<int>& nums) {
        int maxRange = -1;

        for (int num : nums) {
            maxRange = max(maxRange, digitRange(num));
        }

        int sum = 0;

        for (int num : nums) {
            if (digitRange(num) == maxRange)
                sum += num;
        }

        return sum;
    }
};

// class Solution {
// public:
//     int f(int n){
//         int maxi = INT_MIN;
//         int mini = INT_MAX;

//         while(n > 0){
//             int d = n%10;
//             maxi = max(maxi, d);
//             mini = mini(mini, d);

//             n /= 10;
//         }
//         return maxi-mini;
//     }

//     int maxDigitRange(vector<int>& nums) {
//         map<int, vector<int>> mpp;
//         int n = nums.size();

//         for(int i=0; i<n; i++){
//             int dr = f(nums[i]);
//             mpp[dr].push_back(nums[i]);

            
//         }
//     }
// };