class Solution {
    public int isConsMax(int[] nums, int idx, int k)
    {
        int max = nums[idx];
        boolean ascending = true;
        for(int i=idx+1; i<nums.length+k-1 && i<idx+k; i++){
            //check is ascending
            if(nums[i] <= nums[i-1] ){
                ascending = false;
                break;
            }
            if (nums[i] - nums[i - 1] != 1) {
                ascending = false;
                break;
            }
            else{
                max = Math.max(nums[i], max);
            }
        }
        if(ascending){
            return max;
        }
        else{
            return -1;
        }
    }
    public int[] resultsArray(int[] nums, int k) {
        //sliding window of k
        
        int n = nums.length;
        // int[] res = new int[n];
        int[] res = new int[n-k+1];
        int lastMax = -1;
        int i;
        for( i=0; i<n-k+1; i++){
            res[i] = isConsMax(nums, i, k);
        }
        return res;

    }
}