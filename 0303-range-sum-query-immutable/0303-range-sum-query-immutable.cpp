class NumArray {
public:
    vector<int> list ;
    // vector<int> ans
    NumArray(vector<int>& nums) {
        list = nums;
        //Precompute a prefix sum array where   prefix[i] stores the sum of elements from the beginning of the array (nums[0]) to nums[i].
        int n = list.size();
        for(int i=1; i<n; i++){
            list[i] = list[i] + list[i-1];
        }
        return;
    }
    
    int sumRange(int left, int right) {
        //we use a prefix sum approach


        //when left == 0, i can do
        // return list[right];

        //but if left!=0 then it is a problem
        //left =2 and right = 5;
        //list[2] = 1, list[5] = -1
        //we can do : list[5] - list[2-1]

        if(left == 0){
            return list[right];
        }
        else{
            return list[right] - list[left-1];
        }
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * int param_1 = obj->sumRange(left,right);
 */