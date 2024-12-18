class Solution {
    public int buttonWithLongestTime(int[][] events) {
        int maxTimeTaken = 0;
        int maxTimeIndex = Integer.MAX_VALUE; // Start with a large value for tie-breaking

        int prev = 0; // Initialize previous time to 0
        for (int i = 0; i < events.length; i++) {
            int index = events[i][0];
            int time_taken = events[i][1] - prev;

            if (time_taken > maxTimeTaken || (time_taken == maxTimeTaken && index < maxTimeIndex)) {
                maxTimeTaken = time_taken;
                maxTimeIndex = index;
            }

            prev = events[i][1]; // Update previous time to the current event's time
        }
        return maxTimeIndex;
    }
}


//First apporach can't decide for variables who have the same time as max
//The issue in your code arises because the logic does not correctly handle tie-breaking when two or more buttons have the same maximum time
// class Solution {
//     public int buttonWithLongestTime(int[][] events) {
//         int maxTimeTaken = 0;
//         int maxTimeIndex = 0;

//         //events is an array which sure shot is n*2 
//         int n = events.length;
//         int prev = 0;
//         // List<Integer
//         for(int i=0; i<n; i++){
//             int index = events[i][0];
//             int time_taken = events[i][1] - prev;
//             if(time_taken >= maxTimeTaken) {
//                 maxTimeTaken = time_taken;
//                 maxTimeIndex = index;
//             }
//             prev = events[i][1];
//         }
//         return maxTimeIndex;
//     }
// }

// //Approach -2 buut very sus
// class Solution {
//     public int buttonWithLongestTime(int[][] events) {
//         int maxTimeTaken = 0;
//         int maxTimeIndex = 0;

//         //events is an array which sure shot is n*2 
//         int n = events.length;
//         int prev = 0;
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int i=0; i<n; i++){
//             int index = events[i][0];
//             int time_taken = events[i][1] - prev;
//             map.put(index,map.getOrDefault(index, 0)+time_taken);
//             prev = events[i][1];
//         }
//         // return maxTimeIndex;
//         // Loop over all keys
//         for (int key : map.keySet()) {
//             maxTimeIndex = Math.max(maxTimeIndex,key);
//         }

//         return maxTimeIndex;
//     }
// }