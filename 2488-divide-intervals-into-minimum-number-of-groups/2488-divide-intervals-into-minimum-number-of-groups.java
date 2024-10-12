class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[] start_times = new int[n];
        int[] end_times = new int[n];

        // Extract start and end times
        for (int i = 0; i < n; i++) {
            start_times[i] = intervals[i][0];
            end_times[i] = intervals[i][1];
        }

        // Sort start and end times
        Arrays.sort(start_times);
        Arrays.sort(end_times);

        int end_ptr = 0, group_count = 0;

        // Traverse through the start times
        for (int start : start_times) {
            if (start > end_times[end_ptr]) {
                end_ptr++;
            } else {
                group_count++;
            }
        }

        return group_count;
    }
}

//My apporach getting too complicated
// class Solution {
//     public int minGroups(int[][] intervals) {
//         int n = intervals.length;
//         int m = intervals[0].length;
        
//         boolean[] flags = new boolean[n];
//         //initially all false

//         int count = 0;

//         for(int i=0; i<n; i++){
//             //basically if flags[i] is true then we have already placed it in some interval
//             boolean newListCreated = false;
//             HashSet<Integer> set=new HashSet<>();
//             if(flags[i]!=true){
//                 //put all in set

//                 //first check if it is not overlapping
//                 for(int j=0; j<m; j++){
//                     if(set.contains(intervals[i][j])){
//                         break;
//                     }
//                 }

//                 //now if we reach here we can add all
//                 for(int j=0; j<m; j++){
//                     set.add(intervals[i][j]);
//                 }
//                 newListCreated = true;
//                 flag[i] = true;
//                 flag[j] = true;
//             }
//             if(newListCreated){
//                 count++;
//             }
//         }
//     }
// }