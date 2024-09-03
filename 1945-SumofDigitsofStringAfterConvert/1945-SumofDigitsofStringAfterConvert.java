class Solution {

    // Sum of digits of a string representation of a number
    public int sumOfDigits(String num){
        int N = 0;
        for (char digit : num.toCharArray()) {
            N += digit - '0';  // Sum up the digits of the string
        }
        return N;
    }

    public int getLucky(String s, int k) {
        int n = s.length();
        StringBuilder num = new StringBuilder();
    
        // Convert characters to their alphabetical positions
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int temp = ch - 'a' + 1;  // Convert 'a' -> 1, 'b' -> 2, ..., 'z' -> 26
            num.append(temp);  // Append the number to StringBuilder
        }
    
        String str = num.toString();  // Initial string representation of the number

        // Get sum of digits k times
        for(int i = 0; i < k; i++){
            int N = sumOfDigits(str);  // Compute sum of digits of the current string
            str = String.valueOf(N);   // Update str to the new string representation
        }

        return Integer.parseInt(str);  // Return the final result
    }
}


// class Solution {

//     // public int sumOfDigits(int num){
//     //     if(num<10){
//     //         return num;
//     //     }
//     //     else{
//     //         int N  =0;
//     //         while(num>0){
//     //             int digit = num%10;
//     //             N += digit;
//     //             num /= 10;
//     //         }
//     //         return N;
//     //     }
//     // }

//     public int sumOfDigits(String num){
//         // Convert the concatenated string to an integer for transformation
//         int N = 0;
//         for (char digit : num.toCharArray()) {
//             N += digit - '0';  // Sum up the digits of the string
//         }

//         return N;
//     }

//     public int getLucky(String s, int k) {
//         int n = s.length();
//         StringBuilder num = new StringBuilder();
    
//         // Convert characters to their alphabetical positions
//         for(int i = 0; i < n; i++) {
//             char ch = s.charAt(i);
//             int temp = ch - 'a' + 1;  // Convert 'a' -> 1, 'b' -> 2, ..., 'z' -> 26
//             num.append(temp);  // Append the number to StringBuilder
//         }
    
//         String str = num.toString();

//         //This will give NumberFormat Exception so cannot be used
//         //N=Integer.parseInt(str);

//         // // Convert the concatenated string to an integer for transformation
//         // int N = 0;
//         // for (char digit : str.toCharArray()) {
//         //     N += digit - '0';  // Sum up the digits of the string
//         // }

//         //get sum K times
//         int N = Integer.parseInt(str);
//         for(int i = 0; i<k; i++){
//             N = sumOfDigits(str);
//             str = String.valueOf(N);
//         }
//         return N;
//     }
// }