class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int size = n - k + 1;
        int[] arr = new int[size];
        int p = 0; // pointer to arr array
        
        for (int i = 0; i <= n - k; i++) {
            boolean isAscending = true;
            boolean isConsecutive = true;
            int max = nums[i];
            int min = nums[i];
            
            for (int j = i; j < i + k; j++) {
                if (j > i && nums[j] < nums[j - 1]) {
                    isAscending = false;
                }
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
            }
            
            // Check if elements are consecutive
            if (isAscending && max - min + 1 == k) {
                arr[p] = max;
            } else {
                arr[p] = -1;
            }
            p++;
        }
        
        return arr;
    }
}



// //try -2 in hurry of solving quesitons faster didnt read elements should be consecutive also i though they should just be 2nd > 1st uptil k
// class Solution {
//     public int[] resultsArray(int[] nums, int k) {
//         int n = nums.length;
//         int size = n - k + 1;
//         int[] arr = new int[size];
//         int p = 0; // pointer to arr array
        
//         for (int i = 0; i <= n - k; i++) {
//             boolean isAscending = true;
//             for (int j = i; j < i + k - 1; j++) {
//                 if (nums[j] >= nums[j + 1]) {
//                     isAscending = false;
//                     break;
//                 }
//             }
//             if (isAscending) {
//                 arr[p] = nums[i + k - 1];  // Last element in the subarray
//             } else {
//                 arr[p] = -1;
//             }
//             p++;
//         }
        
//         return arr;
//     }
// }



// //fk man didnt read question in hurry though k=3 for all cases dumb meee
// // class Solution {
// //     public int[] resultsArray(int[] nums, int k) {
// //         int n = nums.length;
// //         int size = n-k+1;
// //         int[] arr = new int[size];
// //         int p = 0; //pointer to arr array
// //         for(int i=0; i<n-2; i++){
// //             // for(int j=i; ; j++){
// //                 if(nums[i]<nums[i+1] && nums[i+1]<nums[i+2]){
// //                     arr[p] = nums[i+2];
// //                 }
// //                 else {

// //                     arr[p] = -1;
// //                 }
// //                 p++;
// //             // }
// //         }
// //         // for(; p<size; p++){
// //         //     arr[p] = -1;
// //         // }
// //         return arr;
// //     }
// // }