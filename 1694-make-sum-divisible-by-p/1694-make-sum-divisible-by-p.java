//good qsn practise more
class Solution {

    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int totalSum = 0;

        // Step 1: Calculate total sum and target remainder
        for (int num : nums) {
            totalSum = (totalSum + num) % p;
        }

        int target = totalSum % p;
        if (target == 0) {
            return 0; // The array is already divisible by p
        }

        // Step 2: Use a hash map to track prefix sum mod p
        HashMap<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, -1); // To handle the case where the whole prefix is the answer
        int currentSum = 0;
        int minLen = n;

        // Step 3: Iterate over the array
        for (int i = 0; i < n; ++i) {
            currentSum = (currentSum + nums[i]) % p;

            // Calculate what we need to remove
            int needed = (currentSum - target + p) % p;

            // If we have seen the needed remainder, we can consider this subarray
            if (modMap.containsKey(needed)) {
                minLen = Math.min(minLen, i - modMap.get(needed));
            }

            // Store the current remainder and index
            modMap.put(currentSum, i);
        }

        // Step 4: Return result
        return minLen == n ? -1 : minLen;
    }
}

// class Solution {
//     public int minSubarray(int[] nums, int p) {
//         int n = nums.length;
//         int sum = 0 ;
//         for(int i=0; i<n; i++){
//             sum += nums[i];
//         }

//         //difference == ??
//         int diff = sum % p;

//         if(diff < 0){
//             return -1;
//         }
//         else if(diff == 0){
//             return diff;
//         }

//         //now i have to find a subarray whose sum is == diff
//         //i will store the min size of such a sub array sinnce we done thave to retunrn the sub instead we hav to retunr its size
//         int size = Integer.MAX_VALUE;

//         //sliding window
//         //cannot be used since we done have a fixed window size

//         //brute force
//         int s1 = 0;
//         boolean flag = false;
//         for(int i=0; i<n; i++){
//             s1 = nums[i];
//             List<Integer> list = new ArrayList<>();
//             list.add(nums[i]);
//             for(int j = i+1; j<n; j++){
//                 if(s1 % p == diff){
//                     size = Math.min(size, list.size());
//                     flag = true;
//                 }
//                 s1 += nums[j];
//                 list.add(nums[j]);
//             }
//         }

//         if(flag == false){
//             return -1;
//         }
//         else{
//             return size;
//         }
//     }
// }