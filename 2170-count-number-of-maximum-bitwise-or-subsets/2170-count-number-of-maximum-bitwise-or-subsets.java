class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int maxOr = 0;
        
        // Calculate the maximum bitwise OR of all elements
        for (int num : nums) {
            maxOr |= num;
        }

        return countSubsets(nums, n, 0, 0, maxOr);
    }

    private int countSubsets(int[] nums, int n, int index, int currentOr, int maxOr) {
        if (index == n) {
            // If the OR of the subset matches the maximum OR, count it
            return currentOr == maxOr ? 1 : 0;
        }

        // Count the subsets that include nums[index]
        int include = countSubsets(nums, n, index + 1, currentOr | nums[index], maxOr);
        
        // Count the subsets that exclude nums[index]
        int exclude = countSubsets(nums, n, index + 1, currentOr, maxOr);

        return include + exclude;
    }
}


// class Solution {
//     public int countMaxOrSubsets(int[] nums) {
//         ///brute force
//         int n = nums.length;
//         //mapping : biwiseOr --> Frequencey
//         HashMap<Integer, Integer> map = new HashMap<>();
//         int max_sum = Integer.MIN_VALUE;
//         for(int i=0; i<n; i++){
//             int sum = nums[i];
//             max_sum = Math.max(max_sum, sum);
//             map.put(sum, map.getOrDefault(sum,0)+1);
//             for(int j=i; j<n; j++){
//                 sum = sum | nums[j];
//                 map.put(sum, map.getOrDefault(sum,0)+1);
//                 max_sum = Math.max(max_sum, sum);
//             }
//         }
//         int ans = map.get(max_sum);
//         return ans;
//     }
// }