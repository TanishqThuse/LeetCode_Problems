
//Not SO optmial solution : Brute force : Heavy Recursion (But solved entirely by me :)
//Time : O(2^N) : Beats 5%
//Space : beats 90%
class Solution {
    public int isEvaluatedToTarget(int[] nums, int target, int index, char sign, int sum){
        // int sum = 0;
        if(sign=='+') sum += nums[index];
        if(sign=='-') sum -= nums[index];
        if(index==nums.length-1){
            if(sum==target) return 1;
            else return 0;
        }
        return isEvaluatedToTarget(nums, target, index+1,'+', sum) + isEvaluatedToTarget(nums, target, index+1,'-', sum);
    }
    public int findTargetSumWays(int[] nums, int target) {
        //since the constraints are very low i think brute force it is
        //a very heavy recursive code
        int n = nums.length;
        int cnt = 0;
        cnt += isEvaluatedToTarget(nums, target, 0, '+', 0) + isEvaluatedToTarget(nums, target, 0, '-', 0);
        return cnt;
    }
}