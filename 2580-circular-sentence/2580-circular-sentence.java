class Solution {
    public boolean isCircularSentence(String sentence) {
        //logic / trick => We have to find space at i and simply compare i-1 and i+1
        int n = sentence.length();
        //first we will compare the first and last char of snetenace here itsekd
        if(sentence.charAt(0) != sentence.charAt(n-1)){
            return false;
        }

        //now compare by first finding a space and ccomparing the two adjacent spaces to space => it will go till  n-2 since we dont need last char and also we dont need n-1 to check sincce it will voilate i+1 th term
        for(int i=1; i<=n-2; i++)
        {
            char ch = sentence.charAt(i);
            if(ch == ' '){
                if(sentence.charAt(i-1) != sentence.charAt(i+1)){
                    return false;
                }
            }
        }
        return true;
    }




}

// //By using java libraries => String.split
// class Solution {
//     public boolean isCircularSentence(String sentence) {
//         String[] words = sentence.split(" ");
//         int n = words.length;
//         for(int i=0; i<n; i++){
//             String curr = words[i];
//             int m = curr.length();
//             String next = words[(i+1)%n];
//             if(curr.charAt(m-1) != next.charAt(0)){
//                 return false;
//             }
//         }
//         return true;
//     }
// }
