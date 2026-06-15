class Solution {
public:
    bool checkGoodInteger(int n) {
        int n2 = n;
        int sqSum = 0;
        int digitSum = 0;
        while(n2 > 0){
            int d = n2%10;
            sqSum += d*d;
            digitSum += d;
            n2 /= 10;
        }
        return (sqSum - digitSum >= 50);
    }
};