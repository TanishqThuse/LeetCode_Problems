//much more simplified ==> simple check if i+=2 is same as prev or not
public class Solution {
    public int minChanges(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 1; i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                count++;
            }
        }
        return count;
    }
}


// // //extremely simplfied
// // class Solution {
// //     public int minChanges(String s) {
// //         int n = s.length();
// //         int cnt = 0;
        
// //         for (int i = 1; i < n; i++) {
// //             if (s.charAt(i) == s.charAt(i - 1)) {
// //                 cnt++; // A change is needed here
// //                 // Optionally change the current character to the other type
// //                 // s = s.substring(0, i) + (s.charAt(i) == '0' ? '1' : '0') + s.substring(i + 1);
// //             }
// //         }
        
// //         return cnt;
// //     }
// // }


// class Solution {
//     public int minChanges(String s) {
//         int n = s.length();
//         int cnt = 0 ;
//         int size = 1;
//         for(int i=1; i<n; i++){
//             if(s.charAt(i)!=s.charAt(i-1)){
//                 if(size%2==0){
//                     //partition can be done
//                     size = 1;
//                 }
//                 else{
//                     cnt++;
//                     size = 1;
//                     i++;
//                     // s.charAt(i) = s.charAt(i-1);
//                     s = s.substring(0,i) + s.charAt(i-1) + ((i+1<n)?(s.substring(i+1)):"");
//                 }
//             }
//             else{
//                 size++;
//             }
//         }
//         // if(size%2!=0){
//         //     return ++cnt;
//         // }
//         return cnt;
//     }
// }