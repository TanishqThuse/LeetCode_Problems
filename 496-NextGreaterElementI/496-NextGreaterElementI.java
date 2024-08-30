//first i solve without stack
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[n];
        int c = 0;
        for(int i=0; i<n; i++){
            //for each i find an equivalent index j
            int temp = nums1[i];
            int j=-1;
            int flag = -1;
            for( j=0; j<m ; j++){
                if(temp == nums2[j]){
                    break; //we now have j stored
                    // flag = 1; // ithink in any case ek value to miljayge
                }
            }
            // if(flag==1){
                int val = -1;
                for(int k=j+1; k<m ; k++){
                    if(nums2[j]<nums2[k]){
                        val = nums2[k]; //i did some bachat in makin variables
                        break;
                    }
                }
            // }
            ans[c++] = val;
        }
        return ans;
    }
}