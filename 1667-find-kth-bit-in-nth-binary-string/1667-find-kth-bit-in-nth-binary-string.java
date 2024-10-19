
//solution without building th string 
class Solution {
    
    public char findKthBit(int n, int k) {
        // Base case: when n is 1, the string is just "0"
        if (n == 1) {
            return '0';
        }
        
        int length = (1 << n) - 1; // Length of S(n) is 2^n - 1
        int mid = length / 2 + 1;  // Middle position
        
        if (k == mid) {
            return '1'; // Middle character is always '1'
        } else if (k < mid) {
            // k is in the first half, same as S(n-1)
            return findKthBit(n - 1, k);
        } else {
            // k is in the second half, it corresponds to the reverse and invert of S(n-1)
            // Find the corresponding position in the first half
            int mirroredK = length - k + 1;
            char mirroredBit = findKthBit(n - 1, mirroredK);
            // Invert the mirrored bit
            return mirroredBit == '0' ? '1' : '0';
        }
    }
}


//brute force / recursive solution ==> it is inefficient
// class Solution {

//     public String formString(String s, int m){
//         String str = "";
//         if(m == 0){
//             return "0";
//         }
//         else{
//             String inverse = "";
//             for(int i=0; i<m; i++){
//                 char ch = s.charAt(i);
//                 if(ch == '0'){
//                     inverse += "1";
//                 }
//                 else{
//                     inverse += "0";
//                 }
//             }
            
//             String rev = "";
//             for(int i=m-1; i>=0; i--){
//                 char ch = inverse.charAt(i);
//                 rev += ch;
//             }
//             str = s + "1" + rev;
//             // str = s + "1" + reverse(invert(s,m));
//         }
//         return str;
//     }

//     public char findKthBit(int n, int k) {
//         //first we have to find the nth string
//         String s = "";
//         while(n-->0){
//             int m = s.length();
//             s = formString(s, m);
//         }
//         return s.charAt(k-1);
//     }
// }