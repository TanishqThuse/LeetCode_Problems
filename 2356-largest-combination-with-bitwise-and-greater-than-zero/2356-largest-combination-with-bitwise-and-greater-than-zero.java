class Solution {
    public int largestCombination(int[] candidates) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int candidate : candidates) {
                if ((candidate & (1 << i)) != 0) cnt++;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}

// class Solution {
//     public int largestCombination(int[] candidates) {
//         int n = candidates.length;
//         // int largest = Integer.MIN_VALUE;
//         int size = 1;
//         for(int i=0; i<n; i++){
//             int curr = candidates[i];
//             int tempSize = 1;
//             for(int j = i+1; j<n; j++){
//                 curr = curr & candidates[j];
//                 if(curr > 0){
//                     tempSize++;
//                     size = Math.max(size, tempSize);
//                     // largest = curr;
//                 }
//             }
//         }
//         return size;
//     }
// }