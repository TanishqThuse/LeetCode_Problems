//By using java libraries
class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        int n = words.length;
        for(int i=0; i<n; i++){
            String curr = words[i];
            int m = curr.length();
            String next = words[(i+1)%n];
            if(curr.charAt(m-1) != next.charAt(0)){
                return false;
            }
        }
        return true;
    }
}

// class Solution {
//     public boolean isCircularSentence(String sentence) {
        
//     }
// }