//Aprroach - 2: Count left zeroes and right ones
//initially we keep the sum = {For all ch=='1'} => all stings are right
//so we start by assuming te ccirent har belongs to ch=='0'
//int rightAllOnesSum = {Sum if ++ for all ch=='1'} = currentSum
// int ans = 0;
//for(0->=n-2) :{
//     currentSum += 1 {if ch=='0'}
//     currentSum += -1 (if ch=='1') 
// }

class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int sum =0;
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            if(ch=='1') sum++;
        }

        int currentSum = sum;
        int maxSum = 0 ;
        for(int i=0; i<n-1; i++){
            char ch = s.charAt(i);
            if(ch=='0') currentSum++;
            else currentSum--;

            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;    
    }
}


//Approach - 1 : Brute force
// class Solution {
//     public int maxScore(String s) {
//         int n = s.length();
//         //brute force approach => check all possibe combinations
//         int score= 0;
//         for(int i=0; i<n-1; i++){
//             //check what is we make partition here
//             score = Math.max(score,scoreAfterPartition(s,i,n));
//         }
//         return score;
//     }
//     public int scoreAfterPartition(String s, int idx, int n){
//         int currentScore = 0;
//         for(int i=0; i<=idx; i++){
//             char ch = s.charAt(i);
//             if(ch=='0') currentScore++;
//         }
//         for(int i=idx+1; i<n; i++){
//             char ch = s.charAt(i);
//             if(ch=='1') currentScore++;
//         }
//         return currentScore;
//     }
// }