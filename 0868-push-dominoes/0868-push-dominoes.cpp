// ALSO LOOK AT OWN BRUTE FORCE CODE WHICH I CODED FROM SCRATCH :)

// corect optimised apporahc
class Solution {
public:
    string pushDominoes(string dominoes) {
        int n = dominoes.size();
        vector<int> forces(n, 0);

        int force = 0;
        for (int i = 0; i < n; i++) {
            if (dominoes[i] == 'R') force = n;
            else if (dominoes[i] == 'L') force = 0;
            else force = max(force - 1, 0);
            forces[i] += force;
        }

        force = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (dominoes[i] == 'L') force = n;
            else if (dominoes[i] == 'R') force = 0;
            else force = max(force - 1, 0);
            forces[i] -= force;
        }

        string result;
        for (int f : forces) {
            if (f > 0) result += 'R';
            else if (f < 0) result += 'L';
            else result += '.';
        }

        return result;

        // the difference between my optimised apporach and the correct optimised apporach was that i only went from left to right and then stopped but in the correct optimised apporach they webt from left to right and then went from right to left and then went on to combine the forces from botht the directions and then then evaluated the answer to be the greater of the two forces so they kind converted the time depreciation to force depreciation which is interesting
    }
};


// My wrong optimised approach
// // This optimised apporahc uses force propogation calculation

// class Solution {
// public:
//     string pushDominoes(string dominoes) {
//         int n = dominoes.size();
//         // if we encounter a R we set force (int the forces array) to n and if we encounter a L we set forces to 0, similar if we dont encounter any R but only L we set it to -n throughout
//         vector<int> forces(n);
//         vector<char> ans(n);
//         int curr = 0;
//         for(int i=0; i<n; i++){
//             char ch = dominoes[i];
//             if(curr == 0 && ch=='R'){
//                 curr = n;
//             }
//             else if(curr == n && ch=='L'){
//                 curr = 0;
//             }
//             else if(curr == 0 && ch=='L'){
//                 curr = -n;
//             }
//             else if(curr == -n && ch=='R'){
//                 curr = 0;
//             }
//             forces[i] = curr;

//             if(forces[i]==0) ans[i] = '.';
//             else if(forces[i]==n) ans[i]='R';
//             else if(forces[i]==-n) ans[i] = 'L';

//      }
//      string answer  = "";
//      for(char ch : ans){
//         answer += ch;
//      }
//      return answer;
//     }
// };

// // /*Brute force  Approach : where we simulate the dominoes falling
// // | Complexity Type | Value    |
// // | --------------- | -------- |
// // | Time            | `O(n^2)` |
// // | Space           | `O(1)`   |
// // */

// // class Solution {
// // public:
// //     string pushDominoes(string dominoes) {
// //         // every second we will do changes until there is no change at any instant

// //         // My approach
// //         // bool noChange = false;
// //         // while(!noChange){
// //         //     noChange = true;
// //         //     for(int i=0; i<dominoes.size(); i++){
// //         //         if(dominoes[i] == 'L'){
// //         //             // 
// //         //         }
// //         //     }
// //         // }

// //         // One good man's approach
// //         // Step1 : Go left-> right, track how strong the right force is at each point, force drops by 1 at each step, resets to 0 if we see 'L'

// //         // alright a third approach, we compare two strings at a time if 'R.' then we go 'RR' , if '.L' then we go 'LL', 
// //         // if we get 'RL' at any step we stop, if we get 'R.L' we make '.' -> 'x' to demonstrate the deadlock
// //         bool noChange = false;
// //         int n = dominoes.size();
// //         while(!noChange){
// //             noChange = true;

// //             for(int i=0; i<n; i++){
// //                 if(dominoes[i] == '.'){
// //                     // check left, 
// //                     if(i-1>=0 && dominoes[i-1]=='R'){
// //                         // if the next element is 'L' we cooked
// //                         if(i+1 < n && dominoes[i+1]=='L'){
// //                             dominoes[i] = 'x'; //we stop propogation
// //                             // noChange = false; //i dont think this is necessary, since we have reached the condition of stalemate
// //                         }
// //                         else{
// //                             // next element is not 'L' so we cook others
// //                             dominoes[i] = 'R'; //also we don't want to interfere algo so we go i++
// //                             i++;
// //                             noChange = false;
// //                         }
// //                     }
// //                     // check right 
// //                     else if(i+1 < n && dominoes[i+1] == 'L'){
// //                         // check if prev element is not R or not
// //                         if(i-1 >=0 && dominoes[i-1] == 'R'){
// //                             // we reached a stalemate condition
// //                             dominoes[i] = 'x';

// //                             // noChange=false;
// //                         }
// //                         else{
// //                             // since no R element at my left , i can safely conquer current element
// //                             dominoes[i] = 'L';
// //                             noChange =false;
// //                         }
// //                     }
// //                 }

// //                 // since we moving left to right we have to keep on when we at 'L' check if we missed anyelement at left being . or not
// //                 else if(dominoes[i] =='L'){
// //                     if(i-1>=0 && dominoes[i-1]=='.'){
// //                         dominoes[i-1] = 'L';
// //                         noChange = false;
// //                     }
// //                 }
// //             }
// //         }
// //         // convert all 'x' to '.' again
// //         for(int i=0; i<n; i++){
// //             if(dominoes[i] == 'x'){
// //                 dominoes[i] = '.';
// //             }
// //         }
// //         return dominoes;
// //     }
// // };

// // // OG trick i followed : 
// // /*Alright, fellow average Leetcoders who are probably solving this while procrastinating on something more important, let me break down this dominoes problem with the unnecessary sarcasm you never asked for:

// // 1. If you see R.L, that's what I call a "standoff situation."
// // Two forces staring each other down like my credit card bill and my bank account at the end of the month. We need to protect this delicate balance, so we'll disguise it as xxx â not because we're being clever, but because typing three of the same letter is apparently the height of our creativity.

// // 2. Next up, any R. becomes RR and any .L becomes LL.
// // Why? Because dominoes are basically the clingy friends of the physics world â they just can't help but influence whoever's standing next to them. Right goes right, left goes left. It's not rocket science, people.

// // 3. Keep repeating this process until nothing changes â kind of like how I keep telling myself I'll go to the gym tomorrow. Eventually, one of us has to stop lying.

// // 4. Finally, bring back our perfect standoff couples by replacing xxx with R.L again.
// // And there you have it â a solution so elegant it almost makes up for the two hours you spent overthinking this problem before finding this comment.

// // Hint:
// // If you print the string after each step, you can literally watch your productivity fall in slow motion. You're welcome. This approach is simple, readable, and makes you look like you know what you're doing â which is all any of us are really aiming for here.

// // Maximum effort, minimum code. That's how we roll.
// // Tip*/