
class Solution{
    public String clearDigits(String s){
        int n = s.length();
        boolean marked[] = new boolean[n];

        String ans = "";
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch>='0' && ch<='9'){
                marked[i] = true; //but what if i counldn't find any valid index with 
                // boolean flag = false;

                // Find the nearest unmarked non-digit to the left
                for(int j = i - 1; j >= 0; j--) {  // Change made here: Corrected loop to move leftwards
                    char ch1 = s.charAt(j);  // Change made here: Fixed incorrect index usage
                    if(ch1 >= 'a' && ch1 <= 'z' && !marked[j]) {   
                        marked[j] = true; // Mark the non-digit character for removal
                        break; // Exit the loop once the nearest non-digit is found
                    }
                }

                // //wrong code as i was searching the full array
                // for(int j=0; j<n; j++){
                //     char ch1 = s.charAt(j);
                //     if(ch1>='a' && ch1<='z' && marked[j]==false){   
                //         // flag=true;
                //         marked[i]=true;
                //         break;
                //     }
                // }

                // if(flag){
                //     marked[i]=true;
                // }
            }
        }

        for(int i=0; i<n; i++){
            if(!marked[i]){
                ans+=s.charAt(i);
            }
        }
        return ans;
    }
}

//Unnecessaryly complicated codde which doesn;t even work :(
// class Solution {
//     public String clearDigits(String s) {
//         int n = s.length();
//         int count_digits = 0;
//         int count_alphabets = 0;
//         String ans = "";
//         for(int i=0; i<n; i++){
//             char ch = s.charAt(i);
//             if(ch>='0' && ch<='9'){
//                 count_digits++;
//             }
//             else{
//                 count_alphabets++;
//             }
//         }
//         if(count_digits==count_alphabets){
//             return ans;
//         }
//         else if(count_digits==0){
//             return s;
//         }

//         //now if digit<non-digit then remove all
//          //then remove no of digits and no. of alphabets from left == no of non digits
//         if(count_digits<count_alphabets){
//             int c1 = 0;
//             int c2 = 0;
//             for(int i=0; i<n; i++){
//                 char ch = s.charAt(i);
//                 if(c1!=count_digits && ch>='0' && ch<='9'){
//                     c1++;
//                     // continue;
//                 }
//                 else if(c2!=count_digits && ch>='a' && ch<='z'){
//                     c2++;
//                     // continue;
//                 }
//                 if(c1==count_digits && c2==count_alphabets ){
//                     ans+=ch;
//                 }
//             }
//         }
//         else{ //count_alphabets < count_digits
//             int c1 = 0; //digits
//             int c2 = 0; //alphabets
//             // int j;
//             for(int j=0; j<n; j++){
//                 char ch = s.charAt(j);
//                 if(c1!=count_alphabets && ch>='0' && ch<='9'){
//                     c1++;
//                     continue;
//                 }
//                 else if(c2!=count_alphabets && ch>='a' && ch<='z'){
//                     c2++;
//                     continue;
//                 }

//                 ans+=ch;

//                 // if(c1==count_alphabets && c2==count_alphabets){
//                 //     ans+=
//                 // }
//             }
//         }

//         return ans;
//     }
// }