class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long totalChalk = 0;

        // Step 1: Calculate the total chalk required for one complete round
        for (int c : chalk) {
            totalChalk += c;
        }

        // Step 2: Reduce k modulo the total chalk required in one complete round
        k %= totalChalk;

        // Step 3: Find the student who will replace the chalk
        for (int i = 0; i < n; i++) {
            if (chalk[i] > k) {
                return i;
            }
            k -= chalk[i];
        }

        // This line should never be reached since k will be reduced to below any chalk[i]
        return -1;
    }
}


//This solution gives TLE for Test 71/72
// class Solution {
//     public int chalkReplacer(int[] chalk, int k) {
//         int n = chalk.length;
//         int i=0;
//         while(true){
//             int demand = chalk[i%n];
//             if(demand>k){
//                 break;
//             }        
//             i++;
//             k = k-demand;
//         }
//         return i%n;
//     }
// }