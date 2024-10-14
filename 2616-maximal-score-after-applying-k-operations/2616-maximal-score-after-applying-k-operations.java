class Solution {
    public long maxKelements(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    });
    
    for (int num : nums) {
        pq.add(num);
    }
        
    long score = 0;
    
    for (int i = 0; i < k; i++) {
        // Get the maximum value from the priority queue
        int max = pq.poll();
        
        // Increase the score by the maximum value
        score += max;
        
        // Replace the value with ceil(max / 3)
        pq.add((int) Math.ceil(max / 3.0));
    }
    
    return score;
    }
}