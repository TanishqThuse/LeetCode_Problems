// Same as my logic but in lesser no. of lines and slightly efficeint
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        set<char> set;
        int maxi = 0;

        int left = 0;
        int right = 0;
        while (right < s.size()) {
            if (set.find(s[right]) != set.end()) {
                // Remove from left until duplicate is removed
                while (set.find(s[right]) != set.end()) {
                    set.erase(s[left]);
                    left++;
                }
            }
            set.insert(s[right]);
            maxi = max(maxi, right - left + 1);
            right++;
        }

        return maxi;
    }
};


// // Removing just the single element of left size may not work so we hvae to iterate within the while loop until the left side posses not threat
// // My logic
// class Solution {
// public:
//     int lengthOfLongestSubstring(string s) {
//         set<char> set;
//         int maxi = 0;

//         int left = 0;
//         int right = 0;
//         while(left <= right && right<s.size()){
//             // add right element
//             if(set.find(s[right]) == set.end()){
//                 // now we can successfully add this right   most elemenmt
//                 set.insert(s[right]);
//             }
//             else{
//                 // we have to subtract the element
//                 while(set.find(s[right]) != set.end()){
//                     set.erase(s[left]);
//                     left++;
//                     // continue;no need coz of while loop
//                 }
//                 // now we insert in right
//                 set.insert(s[right]);
//             }

//             maxi = max(maxi, right-left+1);
//             right++;
//         }

//         return maxi;
//     }
// };


// // class Solution {
// // public:
// //     int lengthOfLongestSubstring(string s) {
// //         set<char> set;
// //         int maxi = 0;

// //         int left = 0;
// //         int right = 0;
// //         while(left <= right && right<s.size()){
// //             // add right element
// //             if(set.find(s[right]) == set.end()){
// //                 // now we can successfully add this right   most elemenmt
// //                 set.insert(s[right]);
// //             }
// //             else{
// //                 // we have to subtract the element
// //                 set.erase(s[left]);
// //                 left++;
// //                 continue;
// //             }

// //             maxi = max(maxi, right-left+1);
// //             right++;
            
// //         }

// //         return maxi;
// //     }
// // };