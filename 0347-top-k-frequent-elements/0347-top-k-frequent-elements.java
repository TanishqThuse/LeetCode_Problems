//okish question to revide priority queue
//try -2
//this question can be effective soled using priority queue
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int n : nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.getValue(), a.getValue())
        );
        
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            heap.offer(entry);
        }
        
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = Objects.requireNonNull(heap.poll()).getKey();
        }
        
        return res;        
    }
}

// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         int[] mostFreq = new int[k];
//         //approach 1 : use combination of map and set
//         int n = nums.length;
//         HashSet<Integer> set = new HashSet<>();
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int i=0; i<n; i++){
//             set.add(nums[i]);
//             map.put(nums[i], map.getOrDefault(nums[i],0)+1);
//         }

//         //today I learnt about traversing a hashset 
//         Iterator<Integer> iterator = set.iterator();
//         while (iterator.hasNext()) {
//             Integer num = iterator.next();
//               // Access each element in the HashSet 
//         }   

//     }
// }