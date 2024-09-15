class Solution {
    // Function to reverse a string
    public String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString(); // Efficient way to reverse
    }

    public String reverseStr(String s, int k) {
        int n = s.length();
        StringBuilder fin = new StringBuilder(); // Use StringBuilder for efficient concatenation
        
        for (int i = 0; i < n; i += 2 * k) {
            // Step 1: Reverse the first k characters
            // If there are less than k characters remaining, reverse all of them
            if (i + k <= n) {
                fin.append(reverse(s.substring(i, i + k)));
            } else {
                // If fewer than k characters, reverse the remaining part
                fin.append(reverse(s.substring(i)));
                break;
            }
            
            // Step 2: Append the next k characters without reversing, if they exist
            if (i + k < n) {
                int nextEnd = Math.min(i + 2 * k, n); // Ensure we don't go out of bounds
                fin.append(s.substring(i + k, nextEnd));
            }
        }
        
        return fin.toString();
    }
}


// class Solution {
//     public String reverse(String s){
//         int n = s.length();
//         String rev = "";
//         for(int i = 0 ; i<n/2; i++){
//             char temp = s.charAt(n-i-1);
//             rev = temp + rev + s.charAt(i);
//         }
//         return rev;
//     }
//     public String reverseStr(String s, int k) {
//         int n = s.length();
//         String fin = "";
//         for(int i=0; i<n; i = i+2*k){
//             if(i+k < n){
//                 String temp = s.substring(i,i+k);
//                 fin += reverse(temp);

//                 //now we have reverse form 0 to k
//                 //since in for loop condition we do i = i + 2*k, now we have to manually add part fom k to 2k
//                 if(i+(2*k) < n)
//                     fin += s.substring(i+k,i+(2*k));
//                 // else{
                    
//                 // }
//             }
//             else{
//                 fin += s.substring(i);
//             }
//         }
//         return fin;
//     }
// }