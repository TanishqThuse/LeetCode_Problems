class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // //brute force

        // int sum = 0;
        // int n = nums.length;
        // int maxi = Integer.MAX_VALUE;
        // int ans = maxi;
        
        // //TLE Since huge constraints
        // for(int i=0; i<nums.length; i++){
        //     int sum = 0;
        //     int j = i;
        //     int c= 0;
        //     while(j<n && sum < target ){
        //         sum += nums[j];
        //         j++;
        //         c++;
        //     }
        //     if(sum >= target)
        //     ans = Math.min(c,ans);
        // }
        // return (ans==Integer.MAX_VALUE)?0:ans;

         int n = nums.length;
        int left = 0, right = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        while (right < n) {
            // Expand the window by adding the current element
            currentSum += nums[right];
            right++;
            
            // Contract the window until the sum is less than the target
            while (currentSum >= target) {
                minLength = Math.min(minLength, right - left); // Update minimum length
                currentSum -= nums[left]; // Shrink the window from the left
                left++;
            }
        }

        // If minLength was updated, return it, otherwise return 0
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
   
    }
}