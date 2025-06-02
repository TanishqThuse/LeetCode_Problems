class Solution {
public:
    vector<vector<string>> partition(string s) {
        vector<vector<string>> result;
        vector<string> path;
        solve(0, s, path, result);
        return result;
    }
private:
    void solve(int idx, const string &s, vector<string> &path, vector<vector<string>> &result) {
        if (idx >= s.length()) {
            result.push_back(path);
            return;
        }
        for (int i = idx; i < s.length(); ++i) {
            string subStr = s.substr(idx, i - idx + 1);
            if (isPalindrome(subStr)) {
                path.push_back(subStr);
                solve(i + 1, s, path, result);
                path.pop_back();
            }
        }
    }
    bool isPalindrome(const string &str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str[left] != str[right]) return false;
            ++left;
            --right;
        }
        return true;
    }
};

// class Solution {
// public:
//     bool isPalindrome(string str){
//         string res; 
//         for(int i=str.size()-1; i>=0; i--){
//             res += str[i];
//         }
//         return (res == str);
//     }

//     // my function
//     // void backtracking(int idx, string& s, string& curr, vector<string> tempList, vector<vector<string>> list){
//     //     // string curr = 
//     //     for(int i = idx; i<s.size(); i++){  
//     //         curr += s[i];

//     //         // check if the curr is a palindrome
//     //         if(isPalindrome(curr)){
//     //             // Case-1 : We DO NOT accept this palindrome
                
                
//     //             tempList.push_back(curr);


//     //         }
//     //     }
//     // } 

//     // actually required function
//     void solve(int idx, const string& s, vector<string>& path, vector<vector<string>>& result){
//         if(idx >= s.size()){
//             result.push_back(path);
//             return;
//         }

//         for(int i=idx; i<s.size(); i++){
//             string subStr = s.substr(idx, i-idx);
//             // in cpp substr(index start, size/number of values needed for this)

//             if(isPalindrome(subStr)){
//                 path.push_back(subStr);
//                 solve(i+1, s, path, result);
//                 path.pop_back();
//             }
//         }
//     }

//     vector<vector<string>> partition(string s) {
//         int n = s.size();
        
//         vector<vector<string>> list;
//         string curr;
//         vector<string> tempList;
//         solve(0, s, tempList, list);

//         return list;
//     }
// };