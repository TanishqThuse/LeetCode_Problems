class Solution {
    public int numIdenticalPairs(int[] nums) {
        int n = nums.length;
        int ans = 0;

        Map<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            int count = entry.getValue();
            ans += (count * (count - 1)) / 2;
        }
        return ans;
    }
}

//Goof but vn br ioptimsed
// class Solution {
//     public int numIdenticalPairs(int[] nums) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         int c= 0 ;
//         for(int i=0; i<nums.length; i++){
//             for(int j=i+1; j<nums.length; j++){
//                 if(i<j && nums[i] == nums[j]){
//                     c++;
//                 }
//             }
//         }
//         return c;
//     }
// }