class Solution {
public:
    int numberOfSubstrings(string s) {
        int len = s.length();
        int left = 0, right = 0;
        // Track frequency of a, b, c
        vector<int> freq(3, 0);
        int total = 0;

        while (right < len) {
            // Add character at right pointer to frequency array
            char curr = s[right];
            freq[curr - 'a']++;

            // While we have all required characters
            while (hasAllChars(freq)) {
                // All substrings from current window to end are valid
                // Add count of these substrings to result
                total += len - right;

                // Remove leftmost character and move left pointer
                char leftChar = s[left];
                freq[leftChar - 'a']--;
                left++;
            }

            right++;
        }

        return total;
    }

private:
    bool hasAllChars(vector<int>& freq) {
        // Check if we have at least one of each character
        return freq[0] > 0 && freq[1] > 0 && freq[2] > 0;
    }
};

// // Approach - 2 : sliding window
// class Solution {
// public:
//     int numberOfSubstrings(string s) {
//         int n = s.length();
//         int left = 0, count = 0;
//         vector<int> freq(3, 0); // a = 0, b = 1, c = 2

//         for (int right = 0; right < n; right++) {
//             freq[s[right] - 'a']++;

//             // shrink from the left while all chars present
//             while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
//                 count += n - right;
//                 freq[s[left] - 'a']--;
//                 left++;
//             }
//         }

//         return count;
//     }
// };

// // Approach - 1 : Brute force
// // TIme complexity is  : O(n^2)
// // Space complexity is O(1) a bounded map of sizw 3
// // class Solution {
// // public:
// //     bool AllPresent(map<char,int>& freq){
// //         if(freq['a'] > 0 && freq['b'] > 0 && freq['c'] > 0){
// //             return true;
// //         }
// //         return false;
// //     }

// //     int numberOfSubstrings(string s) {
// //         int n = s.size();
// //         // int left = 0;
// //         // int right = 0;
// //         int cnt = 0;
// //         for(int i=0; i<n; i++){
// //             map<char, int> freq;
// //             freq[s[i]]++;
// //             for(int j=i+1; j<n; j++){
// //                 freq[s[j]]++;
// //                 if(AllPresent(freq)){
// //                     cnt++;
// //                 }
// //             }
// //         }
// //         return cnt;
// //     }
// // };