class Solution {
    public int Mini(int nums[]){
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            min = Math.min(nums[i],min);
        }
        return min;
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        //Time = O(k * n * n) =>> ekdam bakwas
        while(k-->0){
            int min = Mini(nums);
            for(int i=0; i<n; i++){
                if(nums[i] == min){
                    nums[i] *= multiplier;
                    break;
                }
            }
        }
        return nums;
    }
}