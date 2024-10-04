import java.util.Arrays;

class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length; // n is even
        Arrays.sort(skill);
        long constSum = 0;
        boolean flag = false;
        
        // Calculate constant sum and check if all pairs sum to the same value
        for(int i = 0; i < n / 2; i++) {
            int player1 = skill[i];
            int player2 = skill[n - i - 1];
            
            if (constSum == 0) {
                constSum = (long) player1 + player2;  // Use long for constSum
            }
            
            if ((long) player1 + player2 != constSum) {
                flag = true;
                break;
            }
        }
        
        if (flag) {
            return -1;
        }
        
        // Sum of chemistry
        long chemistrySum = 0;
        for(int i = 0; i < n / 2; i++) {
            chemistrySum += (long) skill[i] * skill[n - i - 1];  // Use long to avoid overflow
        }
        
        return chemistrySum;
    }
}


// //Solution works!! ==> It just fails for 85/88 since we use int ==> not let' use chatGpt to change int to long since i am not gonna waste time in doing that
// class Solution {
//     public long dividePlayers(int[] skill) {
//         int n = skill.length; //n%2==0
//         Arrays.sort(skill);
//         int[][] div = new int[n/2][2];
//         int constSum = 0;
//         boolean flag = false;
//         for(int i=0; i<n/2; i++){
//             div[i][0] = skill[i];
//             div[i][1] = skill[n-i-1];
//             if(constSum==0){
//                 constSum = div[i][0] + div[i][1];
//             }
//             if(div[i][0] + div[i][1] != constSum){
//                 flag = true;
//                 break;
//             }
//         }
//         if(flag){
//             return -1;
//         }

//         //sum of chemistry
//         int c = 0;
//         for(int i=0 ; i<n/2 ; i++){
//             c += div[i][0] * div[i][1];
//         }

//         return c;
//     }
// }