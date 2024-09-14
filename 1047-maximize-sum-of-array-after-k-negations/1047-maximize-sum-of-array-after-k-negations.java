class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        //My approach --> first make all -ve values postivie
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<n; i++){
            if(nums[i] < 0 && k>0){
                nums[i] = -nums[i];
                k--;
            }
        }
        int sum = 0;

        // boolean flag = true;

        //right now either we hv kiled all negeative umbers Or we have killed all byt wtill some moves life --> in this case we will chechk below
        if(k>=0){
            // Arrays.sort(nums);
            if(k%2==0){
                // int sum = 0 ;
                for(int i=0; i<n; i++){
                    sum += nums[i];
                }
                // return sum;
            }
            else{
                //No need --> find largest -ve number 
                //find smallest +ve positie
                //find max of : 
                
                //However
                Arrays.sort(nums);
                // int sum = 0 ;
                sum -= nums[0];
                for(int i=1 ;  i<n; i++){
                    sum+=nums[i];
                }
                // return sum;
            }
        }
        return sum;
    }
}