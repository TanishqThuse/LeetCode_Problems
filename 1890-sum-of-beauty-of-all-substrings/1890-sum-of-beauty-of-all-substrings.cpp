// try once more
class Solution{
    public:
        int beautySum(string s){
            int n = s.size();
            int sum = 0;

            //firstly select from every possible starting point
            for(int i=0; i<n; i++){
                //create a frequency array
                vector<int> freq(26, 0); //of size 26 and all defaul;ted to 0

                //keep on pushing the j values to the right
                for(int j=i; j<n; j++){
                    //increase the frequency
                    freq[s[j]-'a']++;

                    int maxi = INT_MIN;
                    int mini = INT_MAX;

                    for(int k=0; k<26; k++){
                        if(freq[k] <= 0){
                            continue;
                        }
                        maxi = max(maxi, freq[k]);
                        mini = min(mini, freq[k]);
                    }

                    sum += maxi - mini;
                }
            }
            return sum;
        }
};

// // OPtimised

// class Solution{
//     public:
//         int beautySum(string s){
//             int n = s.size();
//             int sum = 0;

//             //now we iterate from i=0 to n-1 in s
//             for(int i=0; i<n; i++){
//                 vector<int> freq(26);
//                 fill(freq.begin(), freq.end(), 0);

//                 for(int j=i; j<n; j++){
//                     //add current character
//                     freq[s[j] - 'a']++;

//                     int maxi = INT_MIN;
//                     int mini = INT_MAX;

//                     for(int k=0; k<26; k++){
//                         if(freq[k] <= 0) continue;
//                         maxi = max(maxi, freq[k]);
//                         mini = min(mini, freq[k]);
//                     }

//                     sum += maxi - mini;
//                 }
//             }
//             return sum;
//         }        
// };

// // Brute force

// // class Solution {
// // public:
// //     int beautySum(string s) {
// //         int n = s.size();
// //         //brute force
// //         int sum = 0;
// //         for(int i=0; i<n; i++){
// //             for(int j=i+1; j<n+1; j++){
// //                 map<char, int> mpp;
// //                 // → substr() takes:
// //                 // substr(start_index, length);
// //                 string sub = s.substr(i,j-i);
// //                 for(char ch : sub){
// //                     mpp[ch] += 1;
// //                 }

// //                 //now get highest and lowest
// //                 int maxi = INT_MIN;
// //                 int mini = INT_MAX;
// //                 for(auto it : mpp){
// //                     maxi = max(maxi, it.second);
// //                     mini = min(mini, it.second);
// //                 }

// //                 int diff = maxi - mini;
// //                 sum += diff;
// //             }
// //         }
// //         return sum;
// //     }
// // };