class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int count = 0;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum+=nums[j];
                if(sum==goal){
                    count++;
                    //I am not adding continue, since i am unsure whether we get -ve number or not
                }
            }            
        }
        return count;
    }
}