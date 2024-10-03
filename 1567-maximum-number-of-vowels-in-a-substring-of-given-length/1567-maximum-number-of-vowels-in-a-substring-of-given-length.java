//new approach wihtout creating  a string variable 

class Solution {

    public int maxVowels(String s, int k) {
        int c = 0; // Count of vowels in the current window
        int n = s.length();
        int max = 0; // Initialize max to 0

        // If the string length is less than k, return 0
        if (n < k) {
            return 0;
        }

        // Initial window of size k
        for (int i = 0; i < k; i++) {
            if (checkVowel(s.charAt(i))) {
                c++;
            }
        }

        max = c; // Set max after the first window

        // Sliding window
        for (int i = k; i < n; i++) {
            // Remove the first character of the previous window
            if (checkVowel(s.charAt(i - k))) {
                c--;
            }
            // Add the current character
            if (checkVowel(s.charAt(i))) {
                c++;
            }

            // Update max
            max = Math.max(max, c);
        }

        return max;
    }

    // Helper method to check if a character is a vowel
    public boolean checkVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}


//Very inefficient since new sting generation and deletion ==>basd
// class Solution {

//     public int maxVowels(String s, int k) {
//         int c = 0; // Count of vowels in the current window
//         int n = s.length();
//         int max = 0; // Initialize max to 0

//         // If the string length is less than k, return 0
//         if (n < k) {
//             return 0;
//         }

//         String str = "";

//         // Initial window of size k
//         for (int i = 0; i < k; i++) {
//             if (checkVowel(s.charAt(i))) {
//                 c++;
//             }
//             str += s.charAt(i);
//         }

//         max = c; // Set max after the first window

//         // Sliding window
//         for (int i = k; i < n; i++) {
//             // Remove the first character of the previous window
//             char ch = str.charAt(0);
//             if (checkVowel(ch)) {
//                 c--;
//             }
//             ch = s.charAt(i);
//             str = str.substring(1);
//             str += s.charAt(i);

//             // Add the current character
//             if (checkVowel(s.charAt(i))) {
//                 c++;
//             }

//             // Update max
//             max = Math.max(max, c);
//         }

//         return max;
//     }

//     // Helper method to check if a character is a vowel
//     public boolean checkVowel(char ch) {
//         return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
//     }
// }


// // class Solution {
    

// //     public int maxVowels(String s, int k) {
// //         int c = 0 ;
// //         int n = s.length();
// //         int max = Integer.MIN_VAULE;
// //         if(n<k){
// //             return 0;
// //         }

// //         // String str = s.substring(0,k);
// //         String str = "";
// //         for(int i=0 ; i<k; i++){
// //             char ch = s.charAt(i);
// //             if(checkVowel(ch)){
// //                 c++;
// //                 max = Math.max(max, c);
// //             }
// //             str += ch;
// //         }


// //         for(int i=k; i<n; i++){
// //             char ch = str.charAt(0);
// //             if(checkVowel(ch)){
// //                 c--;
// //                 // max = Math.max(max, c);
// //             }
// //             str = str.substring(1);
// //             ch = s.charAt(i);
// //             if(checkVowel(ch)){
// //                 c++;
// //                 max = Math.max(max, c);
// //             }
// //         }

// //         return max;
// //     }

// //     public boolean checkVowel(char ch){
// //         if(ch =='a' || ch == 'e' || ch == 'i' || ch=='o' || ch=='u'){
// //                 return true;
// //             }
// //         }
// //         return false;
// //     }
// // }