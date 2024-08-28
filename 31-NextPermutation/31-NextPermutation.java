class Solution {
    public void nextPermutation(int[] nums) {
        
        int n = nums.length;

        int index1 = -1;
        int index2 = -1;

        //find the rightmose index where :  
        //nums[i] < nums[i+1] ==> This will be our breaking point

        for(int i=(n-1)-1; i>=0; i--){
            if(nums[i] < nums[i+1]){
                index1 = i;
                break;
            }
        }

        //if there is no "breaking point"
        if(index1==-1){
            //simply we have to reverse the array
            reverse(nums, 0); // i have speciief 0 index which means i want enture array asorted
        }
        else{
            //we have to find a second index where : (starting from right hand side)
            //nums[i] > nums[index1] 
            //bascially the largest element to the right of index1 or the num itself if we cant find such

            for(int i=n-1 ; i>=0; i--){
                if(nums[i] > nums[index1]){
                    index2 = i;
                    break;
                }
            }

            //now we are supposed to swap the indices
            swap(nums, index1, index2);

            //the last step is to reverse the array's right hand side after index1

            reverse(nums, index1+1);
        }
    }

    public void reverse(int[] num, int start){
        int i = start;
        int j = num.length-1;
        while(i<j){
            swap(num,i,j);
            i++;
            j--;
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}