class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashMap<Integer,Integer> count = new HashMap<>();
        int n = nums.length;
        
        for(int i=0; i<n; i++){
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        
        int[] c = new int[2];
        int idx = 0;

        for(int i=0; i<n; i++){
            if(count.get(nums[i]) == 2){
                if(idx < 2 && (idx == 0 || c[idx-1] != nums[i])){
                    c[idx] = nums[i];
                    idx++;
                }
            }
        }
        return c;
    }
}


// class Solution {
//     public int[] getSneakyNumbers(int[] nums) {
//         HashMap<Integer,Integer> count = new HashMap<>();
//         int n = nums.length;
//         for(int i=0; i<n; i++){
//             count.put(nums[i], count.getOrDefault(nums[i],0)+1);
//         }
//         int[] c = new int[2];
//         for(int i=0; i<n; i++){
//             if(count.get(nums[i])==2){
//                 if(c[0]==nums[i]){
//                     continue;
//                 }
//                 else{
//                     c[1] = nums[i];
//                     break;
//                 }
//             }
//         }
//         return c;
//     }
// }