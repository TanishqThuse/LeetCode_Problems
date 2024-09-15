class Solution {
    public long maxScore(int[] a, int[] b) {
        int n = b.length;

        // initialise dp
        long[][] dp = new long[4][n];

        // image a dp to be 4xn matrix where we now fill the 0th column with values
        for (int j = 0; j < n; j++) {
            dp[0][j] = (long) a[0] * b[j];
        }

        // now we fill the dp from 1 to 3
        // it corresponds to a[1], a[2], a[3] respective rows
        for (int i = 1; i < 4; i++) {
            long maxPre = Long.MIN_VALUE;

            // we have to make sure i <= j
            for (int j = i; j < n; j++) {
                maxPre = Math.max(maxPre, dp[i - 1][j - 1]);
                dp[i][j] = maxPre + (long) a[i] * b[j];
            }
        }

        long maxValue = Long.MIN_VALUE;
        for (int j = 3; j < n; j++) {
            maxValue = Math.max(maxValue, dp[3][j]);
        }

        return maxValue;
    }
}


//got wrong ans
//maybe due to using int dp instead of long --> shuld have seen return tyep carefully
// class Solution {
//     public long maxScore(int[] a, int[] b) {
//            //dynamic progg
//            int n = b.length;

//            //initialise dp
//            long[][] dp = new long[4][n];

//            //image a dp to be 4xn matrix where we now fill the 0th coloumn with values
//            for(int j=0; j<n; j++){
//             dp[0][j] = a[0] * b[j];
//            }

//            //now we fill the dp ffron 1 to 3
//            //it corresponds to a[1], a[2], a[3] respective rows

//            for(int i=1; i<4; i++){
//                 int maxPre = Integer.MIN_VALUE;

//                 //we have to make sure i<=j
//                 for(int j=i; j<n; j++){
//                     maxPre = Math.max(maxPre, dp[i-1][j-1]);
//                     dp[i][j] = maxPre + a[i] * b[j];
//                 }
//             }

//             int  maxValue = Integer.MIN_VALUE;
//             for(int j=3; j<n ; j++){
//                 maxValue = Math.max(maxValue, dp[3][j]);
//             }

//             return maxValue;

//     }
// }