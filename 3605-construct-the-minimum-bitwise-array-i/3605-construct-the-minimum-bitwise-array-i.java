class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            int j = 0;
            ans[i] = -1;
            while(j<nums.get(i)){
                if((j | j+1) == nums.get(i)){
                    ans[i] = j;
                    break;
                }
                j++;
            }
            if(ans[i]!=j){
                if((j | j+1) == nums.get(i)){
                    ans[i] = j;
                }
            }
        }
        return ans;
    }
}