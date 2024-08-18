//USING DP
class Solution{
    public int nthUglyNumber(int n){
        int dp[] = new int[n+1];
        dp[1] = 1; //sinve 1 si ou first ugly number

        int i2= 1, i3= 1, i5 = 1;

        for(int i = 2 ; i<=n; i++){
            dp[i] = Math.min(Math.min(dp[i2]*2, dp[i3]*3), dp[i5]*5);
            if(dp[i]==dp[i2]*2){
                i2++;
            }
            if(dp[i]==dp[i3]*3){
                i3++;
            }
            if(dp[i]==dp[i5]*5){
                i5++;
            }
        }
            return dp[n];
    }
}




//This approach will always give time complexity error for many cases
//DP is GOAT solution for this
// class Solution {

//     public boolean checkUgly(int n){
//         int[] primes = {2,3,5};
//         for(int prime : primes ){
//             while(n%prime==0){
//                 n/=prime;
//             }
//         } 
//         return n==1;
//     }

//     public int nthUglyNumber(int n) {
//         int count = 0;
//         int i=0;
//         while(count!=n){
//             i++;
//             if(checkUgly(i)){
//                 count++;
//             }
//         }
//         return i;
//     }
// }