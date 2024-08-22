//bettter time complexity
class Solution{
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> seen = new HashMap<>();
        int n = nums.length;
         int[] arr = new int[2];
        for(int i=0; i<n; i++){
            if(seen.containsKey(target-nums[i])){
                arr[1] = i; 
                arr[0] = seen.get(target-nums[i]); 
                return arr; 
            }
            seen.put(nums[i], i);
        }
        return null;
    }
} 

// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         // int n  =

        //// HashMap<Integer, boolean> 
//         int[] arr = new int[2];
//         for(int i=0;i<nums.length; i++){
//             for(int j=i+1; j<nums.length; j++){
//                 if(nums[i] + nums[j] == target){
//                     arr[0] = i;
//                     arr[1] = j;
//                     return arr; 
//                 }
//             }
//         }
//         return arr;arget - num)
//     }
// }
