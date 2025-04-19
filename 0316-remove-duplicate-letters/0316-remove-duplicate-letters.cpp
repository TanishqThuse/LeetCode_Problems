class Solution{
    public:
        string removeDuplicateLetters(string s){
            map<char, int> lastOcc ;
            int n = s.size();
            for(int i=0; i<n; i++){
                lastOcc[s[i]] = i;
            }            

            stack<char> stack;
            set<char> visited;

            for(int i=0; i<n; i++){
                if(visited.find(s[i]) != visited.end()) {
                    continue;
                }

                // if we dont have any previous checkpoints && curr_char is smaller lexiographically than prev_char && current_occ_of_prev_char < last_occ_of_it
                // where prev-char = stack.top

                // since we are using a while loop if the current string is : bc, and a comes, then both cb gets popped coz of while loop
                while(!stack.empty() && s[i] < stack.top() && i<lastOcc[stack.top()]){  
                    visited.erase(stack.top());
                    stack.pop();
                }

                visited.insert(s[i]);
                stack.push(s[i]);
            }

            // now we simmply fill the stack from by taking the str from stack and reversing it since stack gives output in reverse order
            string str;

            while(!stack.empty()){
                str += stack.top();
                stack.pop();
            }

            string str2;

            for(int i = str.size()-1; i>=0; i--){
                str2 += str[i];
            }

            return str2;
            





            // basically i guess agar vo last seen element hoga to i will kill it, else imma not gonna kill? but wait then i have check the lexiographically thing

        }  
};

// My approach , kinda weird if i continue this
// class Solution {
// public:
//     string removeDuplicateLetters(string s) {
//         //approach : map the characters
//         //then loop from 0-26 in reverse 'z' to 'a' and keep on removing duplicated and we will get our desdired smallest lexiographically answer
//         int n = s.length();

//         map<char, int> mpp;
//         for(char ch : s){
//             mpp[ch]++;
//         }

//         string str;
        
//         // O(n) * O(26) = O(n)
//         // instead i can do like
//         // O(26) * O(n)
//         int idx = 0;

//         for(char curr : s){
//             if(mpp[curr]>1){
//                 // skip
//             }
//             else {
//                 str += curr;
//             }
//             mpp[curr]--;
//         }

//         return str;

//         // kind of wrong logic since i am supposed to loop over the string in outter loop so that i can see the thing
//         // for(char c = 'a'; c<='z'; c++){
//         //     if(mpp[c]==0) continue;

//         //     for(char curr : s){
//         //         if(curr == c){
//         //             // since if it is <=1 there is nothing i have to do
//         //             if(mpp[c]==1){ //if it exists i'll append it
//         //                 str += curr;
//         //             }
//         //             else if(mpp[c]>1){
//         //                 // delete this character
//         //                 // i.e no need to append in our string str
//         //             }
//         //             mpp[c]--;
//         //         }
//         //     }
//         // }
//     }
// };