class Solution {
public:
    int evenDigits(int num){
        int cnt = 0;
        while(num > 0){
            num /= 10;
            cnt++;
        }
        if(cnt % 2 == 0){
            return 1;
        }
        return 0;
    }

    int findNumbers(vector<int>& nums) {
        int cnt = 0;
        for(int num : nums){
            cnt += evenDigits(num);
        }
        return cnt;
    }
};