//The key insight is that when you concatenate a string with itself (s + s), it contains all possible rotations of the original string.

class Solution{
    public boolean rotateString(String s, String goal){
        int n = s.length();
        s += s;
        //now s contains all permutations of s and we just need to create a window for size n
        // String temp = s.substring()
        //s = "abcdeabcde"
        String temp  = s.substring(0, n);
        for(int i=1; i<n; i++){
            // if(temp.)
            if(temp.equals(goal)){
                return true;
            }
            temp = s.substring(i,i+n);
        }
        if(temp.equals(goal)){
            return true;
        }
        return false;
    }
}

// Inefficient approach only beats ~7%
// class Solution {
//     public boolean rotateString(String s, String goal) {
//         int n = s.length();
//         if(n==1 || n==0){
//             return true;
//         }
//         while(n-->0){
//             if(s.equals(goal)){
//                 return true;
//             }
//             char ch = s.charAt(0);
//             s = s.substring(1);
//             s += ch;
//         }

//         return false;

//     }
// }