class Solution {
public:
    int reverseDegree(string s) {
        
        int sum = 0;
        int n = s.length();

        for(int i = 0 ; i<n; i++){
            int reverseValue = 26 - (s[i] - 'a');
            sum += reverseValue * (i+1);
        }

        return sum;

        // map<char, int> mpp;
        // int n = s.length();
        // int cnt = 1;
        // for(char i='a'; i<='z'; i++){
        //     mpp[i] = cnt++;
        // }

        // int sum = 0;
        // for(int i=0; i<n; i++){
        //     int reverse = getReverse()
        // }
    }
};