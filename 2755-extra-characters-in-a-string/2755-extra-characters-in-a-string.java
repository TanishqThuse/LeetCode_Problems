//Practise again
import java.util.HashSet;

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        HashSet<String> dict = new HashSet<>();
        
        // Add dictionary words to HashSet
        for (String word : dictionary) {
            dict.add(word);
        }

        // dp[i] represents the minimum extra characters required for substring s[0:i]
        int[] dp = new int[n + 1];
        
        // Initialize dp array where dp[i] is at worst i (i.e., all characters are extra)
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }

        // Fill the dp array
        for (int i = 0; i < n; i++) {
            // If dp[i] has been computed, extend it with possible dictionary words
            for (int j = i; j < n; j++) {
                String substring = s.substring(i, j + 1);
                if (dict.contains(substring)) {
                    // If the substring s[i:j+1] is in the dictionary, no extra chars for this range
                    dp[j + 1] = Math.min(dp[j + 1], dp[i]);
                }
            }
            // Consider the character s[i] as extra, update dp for the next position
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
        }

        return dp[n];
    }
}

// class Solution {
//     public int minExtraChar(String s, String[] dictionary) {
//         int n  = s.length();
//         boolean[] used = new boolean[n]; //to mark if used or not
//         //put dictionary in HashSet
//         HashSet<String> dict = new HashSet<>();

//         for(int i=0; i<dictionary.length; i++){
//             dict.add(dictionary[i]);
//         }

//         //use brute forcee
//         for(int i=0; i<n; i++){
//             for(int j=i+1; j<n; j++){
//                 String temp = s.substring(i,j);
//                 if(dict.contains(temp)){
//                     // s = s.substring(0,i) + s.substring(j);
//                     for(int k=i; k < j ; k++){
//                         used[k] = true;
//                     }
//                 }
//             }
//         }

//         int c= 0 ;
//         for(int i=0; i<n; i++){
//             if(used[i]==false){
//                 c++;
//             }
//         }
//         return c;
//     }
// }