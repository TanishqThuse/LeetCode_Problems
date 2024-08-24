class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> mpp = new HashMap<>();
        
        for (int num : nums) {
            if (num % 2 == 0) {
                mpp.put(num, mpp.getOrDefault(num, 0) + 1);
            }
        }

        int freq = 0;
        int ans = -1;

        for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value > freq || (value == freq && key < ans)) {
                freq = value;
                ans = key;
            }
        }

        return ans;
    }
}

// class Solution {
//     public int mostFrequentEven(int[] nums) {
//         int n = nums.length;
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int i=0; i<n; i++){
//             if(nums[i]%2==0){
//                 map.put(nums[i], map.getOrDefault(nums[i],0)+1);
//             }
//         }
 
//         int min_max = Integer.MAX_VALUE; //the maximum time occuring minimum even number(int case of tie)
//         int max_freq = Integer.MIN_VALUE;

//         for(int value : map.keySet()){
//             max_freq = Math.max(max_freq, map.get(value));
//         }

//         for(int i=0; i<map.size(); i++){
//             min_max = Math.min(min_max, map.get(i));
//         }

//     }
// }