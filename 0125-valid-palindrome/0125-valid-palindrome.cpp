class Solution {
public:
    bool isPalindrome(string s) {
        string str;
        for(char c : s){
            if(isalnum(c)) { // Check if the character is a letter or digit
                str += tolower(c); // Convert to lowercase
            }
        }

        int m = str.size();
        for(int i = 0; i < m / 2; i++){
            if(str[i] != str[m - i - 1]){ // Compare with the correct index
                return false;
            }
        }
        return true;
    }
};


// class Solution {
// public:
//     bool isPalindrome(string s) {
//         int n = s.size();

//         //first clean the string, remove " ", all other characters which is not a-z
//         string str;
//         for(int i=0 ; i<n; i++){
//             if((s[i] >= 'a' && s[i] <= 'z') || (s[i] >= 'A' && s[i] <= 'Z')){
//                 str += s[i];
//             }
//         }

//         for(int i=0; i<str.size()/2; i++){
//             if(str[i] != str[n-i-1]){
//                 return false;
//             }
//         }
//         return true;
//     }
// };