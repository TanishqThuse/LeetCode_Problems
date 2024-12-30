class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        // Use dp[i] to record to number of good strings of length i.
        int[] dp = new int[high + 1];
        dp[0] = 1;
        int mod = 1_000_000_007;
        
        // Iterate over each length `end`.
        for (int end = 1; end <= high; ++end) {
            // check if the current string can be made by append zero `0`s or one `1`s.
            if (end >= zero) {
                dp[end] += dp[end - zero];
            }
            if (end >= one) {
                dp[end] += dp[end - one];
            }
            dp[end] %= mod;
        }
        
        // Add up the number of strings with each valid length [low ~ high].
        int answer = 0;
        for (int i = low; i <= high; ++i) {
            answer += dp[i];
            answer %= mod;
        }
        return answer;
    }
}

// class Solution {
//     public int countGoodStrings(int low, int high, int zero, int one) {
//         //The problem is a standard dynamic programming problem

//         //first we create a dp where we use dp[i] to record
//         //the number of good strings of length i

//         //we create a high+1 since it is possible => since we are going to check for high+1 cases
//         int[] dp = new int[high + 1];
//         dp[0] = 1;
//         int mod = 1_000_000_007;

//         //we iterate over each length `end`
//         for(int end = 1 ; end<=high; ++end) {

//             //check if current string can be made by append zero '0's or one 1's

//             if(end >= zero){
//                 dp[end] += dp[end - zero];
//             }

            

//         }

//     }
// }