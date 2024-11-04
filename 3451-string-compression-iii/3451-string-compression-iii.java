/**This code beats 98% and 68% in space (since we used int n, String s) whcih is not necessary */
/**So this is more efficient than second  one since,
1. Efficient String Concatenation with StringBuilder
2. Simplified Counting Logic
3. Correct Count Reset and Logic
4. Reduced Complexity in Character Count Conversion*/
class Solution{
    public String compressedString(String word){
        StringBuilder comp = new StringBuilder();
        int n = word.length();
        int cnt = 1;
        String s = word;
        char ch = s.charAt(0);
        for(int i=1; i<n; i++){
            if(word.charAt(i) == ch && cnt<9){
                cnt++;
            }
            else{
                comp.append((char)(cnt+'0'));
                comp.append(ch);
                ch = word.charAt(i);
                cnt = 1;
            }
        }
        //now in both cases the last selected char ch is still not appended so we will do it now
        comp.append((char)(cnt+'0'));
        comp.append(ch);
        return comp.toString(); 
    }
}

//Time : O(n), where n is the length of the string word.
//Space : O(n)
 
//Extrememely inefficeint code 
//Beats 5% and 7% for time ans space
// class Solution {
//     public String compressedString(String word) {
//         int n = word.length();
//         int cnt = 0 ;
//         int idx = 0;
//         String comp = "";
//         String s= word;
//         while(n>0 && idx<n){
//             char ch = s.charAt(idx);
//             cnt++;
//             int i;
//             for( i=idx+1; i<n && i<9+idx; i++){
//                 if(s.charAt(i) == ch){
//                     cnt++;
//                 }
//                 else{
//                     break;
//                 }
//             }
//             idx = i;
//             // comp += (char)(cnt + '0') + ch; //problem in this is it is converting ch to a  number as well
//             comp += (char)(cnt + '0');
//             comp += ch;
//             // return comp;
//             cnt = 0;
//             n-=cnt;
//         }
//         return comp;
//     }
// }

//More details : 
// Issues in the Code
// Inefficient String Concatenation: Using += repeatedly to build a String leads to inefficiency because a new String object is created for each concatenation.
// Incorrect cnt Reset: cnt is reset after updating comp, but n is also decremented by cnt, which can cause unintended behavior.
// Logic Issue in comp += (char)(cnt + '0');: This line attempts to convert cnt to a character but will work only for single-digit counts (1-9). For larger counts, it would lead to incorrect results.