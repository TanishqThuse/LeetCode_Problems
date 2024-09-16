class Solution {

    public int findMinDifference(List<String> timePoints) {
        // convert input to minutes
        int[] minutes = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String time = timePoints.get(i);
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3));
            minutes[i] = h * 60 + m;
        }

        // sort times in ascending order
        Arrays.sort(minutes);

        // find minimum difference across adjacent elements
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < minutes.length - 1; i++) {
            ans = Math.min(ans, minutes[i + 1] - minutes[i]);
        }

        // consider difference between last and first element
        return Math.min(ans,24 * 60 - minutes[minutes.length - 1] + minutes[0]
        );
    }
}


//Extrememly comiplicated

// class Solution {
//     public int findMinDifference(List<String> timePoints) {
//         int n = timePoints.size();
//         int[] timeInMinutes = new int[n];
//         for(int i=0; i<n; i++){
//             String curr = timePoints.get(i);
//             int j = i;
//             // for(int j=i+1; j<n ; j++){
//                 String temp = timePoints.get(j);
//                 String[] timeParts = temp.split(":");

//                 int hours = Integer.parseInt(timeParts[0]) * 60;
//                 int minutes = Integer.parseInt(timeParts[1]) ;

//                 int total_time = hours + minutes;

//                 if(total_time == 0){
//                     total_time = 1440;
//                 }

//                 timeInMinutes[i] = total_time;
//             // }
//         }

//         //now we  will sort it 
//         Arrays.sort(timeInMinutes);

//         int n1 = timeInMinutes.length;

//         // int diff = Math.abs(timeInMinutes[0] - timeInMinutes[n1-1]);
 
//         int diff = Integer.MAX_VALUE;
//         for(int i=0; i<n1; i++){
//             // diff = Math.min()
//             for(int j=i+1; j<n1; j++){
//                 // if()
//                 diff = Math.min(diff , Math.abs(timeInMinutes[i] - timeInMinutes[j]));
//             }
//         }

//         return diff;
//     }
// }