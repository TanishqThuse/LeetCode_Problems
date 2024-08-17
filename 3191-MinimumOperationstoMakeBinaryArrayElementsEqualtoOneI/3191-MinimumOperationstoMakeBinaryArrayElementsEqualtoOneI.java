//I see a pattern()
//Basically I loop from 0 to end of array
//Each time I see 0 i flip it and next 2 elements
//I keep i in memory and after flipping i resume loop from i+1 
//After flipping i start from start ==> This will give runtime 
//i do this until array ends 

// nums = [0,1,1,1,0,0]

// We can do the following operations:

// Choose the elements at indices 0, 1 and 2. The resulting array is nums = [1,0,0,1,0,0].
// Choose the elements at indices 1, 2 and 3. The resulting array is nums = [1,1,1,0,0,0].
// Choose the elements at indices 3, 4 and 5. The resulting array is nums = [1,1,1,1,1,1].


class Solution {
    
    public int checkAllOnes(int[] nums, int count){
        // int flag = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                count=-1;
                break;
            }
        }
        return count;
    }

    public int minOperations(int[] nums) {
        int n = nums.length;
        int flag = -1;
        int count = 0;
        for(int i=0; i<n; i++){
            if(nums[i]==0 && i+2<n){
                nums[i] = (nums[i]==0) ? 1:0;
                nums[i+1] = (nums[i+1]==0) ? 1:0;
                nums[i+2] = (nums[i+2]==0) ? 1:0;
                count++;  
            }
        }       
        return checkAllOnes(nums,count);
    }
}