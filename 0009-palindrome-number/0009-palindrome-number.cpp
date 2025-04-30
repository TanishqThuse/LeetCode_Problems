class Solution {
public:
    // my approach is to reverse the number and compare with start
    
    long reverse(int x){
        long rev = 0;

        while(x > 0){
            rev = (rev * 10) + x%10; 
            x /= 10;
        }

        return rev;
    }

    bool isPalindrome(int x) {
        if(x < 0){
            return false;
        }

        long rev = reverse(x);     

        return rev == x; 
    }
};