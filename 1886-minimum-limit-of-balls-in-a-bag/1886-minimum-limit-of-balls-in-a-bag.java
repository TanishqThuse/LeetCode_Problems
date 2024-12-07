class Solution {
    public int minimumSize(int[] nums, int maxOps) {
        int low = 1, high = Arrays.stream(nums).max().getAsInt();
        while (low < high) {
            int mid = (low + high) / 2;
            int ops = 0;
            for (int n : nums) {
                ops += (n - 1) / mid;
            }
            if (ops <= maxOps) high = mid;
            else low = mid + 1;
        }
        return high;
    }
}

// class Solution {
//     public int minimumSize(int[] nums, int maxOperations) {
//         int n = nums.length;
//         List<Integer> list = new ArrayList<>();
//         for(int i=0; i<n; i++){
//             list.add(nums[i]);
//         }

//         //now basically i have to go on to split and go on to add
//         // Arrays.sort(nums);
//         while(maxOperations-- > 0){
//             Collections.sort(list);
//             int k = list.get(nums.size() - 1);
//             int k1 = list.get(nums.size() - 2);
//             // int min = list.get(0);
            
//         }
//     }
// }