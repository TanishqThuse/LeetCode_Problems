class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];

        if (k == 0) {
            // If k is 0, all elements in the result are 0
            return res;
        }

        int start = 1, end = k; // Default for k > 0
        if (k < 0) {
            k = -k; // Make k positive
            start = n - k; // Shift the window for negative k
            end = n - 1;
        }

        // Calculate the initial window sum
        int windowSum = 0;
        for (int i = start; i <= end; i++) {
            windowSum += code[i % n];
        }

        // Compute the result using the sliding window
        for (int i = 0; i < n; i++) {
            res[i] = windowSum;
            // Slide the window
            windowSum -= code[start % n];
            windowSum += code[(end + 1) % n];
            start++;
            end++;
        }

        return res;
    }
}


// class Solution {
//     public int[] decrypt(int[] code, int k) {
//         int n = code.length;
//         int[] res = new int[n];
//         int mag = Math.abs(k);
//         // int dir = (k>0)?1:-1;

//         for(int i=0; i<n; i++){
//             res[i] = 0;
//         }

//         if(k==0){
//             return res;
//         }

//         if(k>0){
//             for(int i=0; i<n; i++){
//                 for(int j=i+1; j<i+1+k; j++){
//                     res[i] += code[(j%n)];
//                 }
//             }
//         } 
//         //simply outting else gives TLE
//         else if(k<0){
//             for(int i=0; i<n; i++){
//                 // for(int j=i-1; j<i+1+k; j++){
//                 //     res[i] += arr[(j%n)];
//                 // }
//                 int temp = k;
//                 int cnt = --i;
//                 while(temp-->0){
//                     res[i] += code[((cnt--) + n)%n];
//                 }
//             }
//         }
//         return res;
//     }
// }