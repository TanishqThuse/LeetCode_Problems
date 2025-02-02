// class Solution{
//     public boolean check(int[] nums){
//         int n = nums.length;

//         boolean flag = true;

//         for(int i=0; i<n-1; i++){
//             if(nums[i] > nums[i]+1){
//                 if(flag==false) return flag;
//                 flag = false;
//             }

//             if(nums[i+1] != nums[i]+1 && flag==false){
//                 return false;
//             }
//         }
//         return true;
//     }
// }

// /**T(O) = O(n)
// S(O) = 1 */
// //A good problem for pattern recognization

class Solution {
    public boolean check(int[] nums) {
        //The pattern which was supposed to be observed here is : 
        // 1)The array was sorted and then rotated'
        // 2)WHich means there is only one position where nums[i] > nums[i+1]
        int l = nums.length;
        int c = 0;
        for(int i=0; i<(l); i++){
            if(i==l-1){
                //comapre 4rht and 0th index
                if(nums[i]>nums[0]){
                    c++;
                }
            }
            else{
                if(nums[i]>nums[i+1]){
                    c++;
                }
            }

            if(c>1){
                return false;
            }
        }
        return true;
    }
}