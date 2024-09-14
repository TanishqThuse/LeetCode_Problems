class Solution {
    public int longestSubarray(int[] nums) {
        int c = 0;
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            max = Math.max(nums[i], max);
        }
        int temp_c = 0;
        for(int i=0; i<n; i++){
            if(nums[i]==max){
                temp_c++;
            }
            else if(temp_c>0){
                c = Math.max(temp_c, c);
                temp_c = 0;
            }
        }
        return Math.max(temp_c,c);
    }
}