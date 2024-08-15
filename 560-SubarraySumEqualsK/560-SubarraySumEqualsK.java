// //Sorting and sliding windows
// class Solution{
//     public int subarraySum(int[] nums, int k){
        
// }

//This quesion is still let for undersndin or optimisation


//Brute force ==> Bad apporach
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // int sum = 0 ;
        int count=0;
        for(int i=0; i<n; i++){
            int sum=0;
            for(int j=i; j<n; j++){
                sum += nums[j];
                if(sum==k){
                    count++;
                }
            }            
        }
        return count;
        // System.out.println(count);
    }
}