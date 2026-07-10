class Solution {
public:
    bool consecutiveSetBits(int n) {
        int ct=0;
        int cs=0;
        while(n>0){
            int bit=n&1;
            if(bit==1)cs++;
            else cs=0;
            if(cs>=2)ct++;
            n=n>>1;
        }
        return ct==1;
    }
};

// class Solution {
// public:
//     string binary(int n){
//         string s = "";
//     while (n > 0) {
//         s += (n % 2) + '0';
//         n /= 2;
//     }
//     return s;
//     }

//     bool consecutiveSetBits(int n) {
//         // convert n to binary
//         string s = binary(n);

//         int cnt = 0;
//         for(int i=1; i<s.size(); i++){
//             if((s[i] == s[i-1]) && s[i] == '1'){
//                 cnt++;
//             }
//         }

//         return cnt==1;
//     }
// };