class Solution {
    public char getLargestChar(int[] alp, char lastChar, int repeatLimit, int lastCharCount) {
        boolean skip = (lastCharCount == repeatLimit);
        for (int i = 25; i >= 0; i--) {
            if (alp[i] > 0) {
                char currentChar = (char)(i + 'a');
                if (skip && currentChar == lastChar) {
                    continue; // Skip this character if it violates the repeat limit
                }
                alp[i]--; // Use this character
                return currentChar;
            }
        }
        return '\0'; // Return null character if no valid character is found
    }

    public String repeatLimitedString(String s, int repeatLimit) {
        int[] alp = new int[26];
        for (char ch : s.toCharArray()) {
            alp[ch - 'a']++;
        }

        StringBuilder res = new StringBuilder();
        char lastChar = '\0';
        int lastCharCount = 0;

        while (true) {
            char nextChar = getLargestChar(alp, lastChar, repeatLimit, lastCharCount);
            if (nextChar == '\0') {
                break; 
            }

            if (nextChar == lastChar) {
                lastCharCount++;
            } 
            else {
                lastChar = nextChar;
                lastCharCount = 1;
            }

            res.append(nextChar);
        }

        return res.toString();
    }
}


// class Solution {

//     public char getLargestChar(String s, String res, int[] alp, int index, int repeatLimit){
//         boolean flag = false;
//         char curr = res.charAt(index);
//         int count = 0;
//         for(int i=res.length() ; i>=0 ; i--){
//             char ch = res.charAt(i);
//             if(ch!=curr) break;
//             else{
//                 //both same
//                 //increase counter
//                 count++;
//                 if(count==repeatLimit) {
//                     flag = true;
//                     break;
//                 }
//             }
//         }

//         for(int i=26-1; i>=0; i--){
//             if(alp[i]>0){
//                 if(flag){
//                     flag = !flag;
//                 }
//                 else{
//                     alp[i]--;
//                     return (char)(i+'0');
//                 }
//             }
//         }
//         return '\0';
//     }

//     public String repeatLimitedString(String s, int repeatLimit) {
//         int n = s.length();
//         int[] alp = new int[26];
//         for(int i=0; i<n; i++){
//             char ch = s.charAt(i);
//             alp[ch-'a']++;
//         }

//         String res = "";

//         for(int i=0; i<n; i++){
//             char ch = getLargestChar(s,res,alp, i, repeatLimit);
//             res += ch;
//         } 
//         return res;
//     }
// }