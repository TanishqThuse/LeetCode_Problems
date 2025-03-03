class Solution{
    public boolean nullArray(int[] nums){
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i]!=0) return false;
        }
        return true;
    }
    public int longestOnes(int[] nums, int k){
        int i=0, j=0;
        int max_len = 0;
        int zeroes = 0;
        int n = nums.length;

        // if(k==0){
        //     return 0;
        // }

        while(j<nums.length){
            
            if(nums[j] == 0) {
                zeroes++;
            }

            //now run the loop and check the no. of zeroes
            if(zeroes > k){
                //shrink the gap
                while((zeroes>k) ){
                    if(nums[i] == 0) zeroes--;
                    i++;
                }
            }

            //now we are sure zeroes are lesser k
            max_len = Math.max(max_len, j-i+1);
            j++; //expand the window
        }
        return max_len;
    }
}

//Brute force
// class Solution {
//     public int longestOnes(int[] nums, int k) {
//         //Brute force : Subarray with maximum number of zeroes
//         int n = nums.length;
//         int max_len = 0;
//         for(int i=0; i<n; i++){
//             int zeroes = 0;
//             int len = 0;
//             for(int j=i; j<n; j++){
//                 if(nums[j] == 0) zeroes++;
//                 if(zeroes==k){
//                     len = j - i + 1;
//                     max_len = Math.max(max_len, len);
//                     break;
//                 }
//             }
//         }
//         return max_len;
//     }
// }

// // class Solution {
// //     public int longestOnes(int[] nums, int k) {
// //         //Approach - FInd largest row of 1s , then first fill right then fill left, (left number of 0s isless than k then change direction, otherwise skip the 1 and go on)
// //         int n = nums.length;
// //         for(int i=0; i<n; i++){

// //         }
// //     }
// // }