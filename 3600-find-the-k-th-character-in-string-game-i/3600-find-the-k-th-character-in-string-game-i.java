class Solution {
    public char kthCharacter(int k) {
        String word = "a";

        while(word.length()<k){
            int n = word.length();
            for(int i=0; i<n; i++){
                char ch = word.charAt(i);
                ch++;
                if(ch>'z'){
                    ch -= 25;
                }
                word += ch;
            }
        }
        return word.charAt(k-1);
    }
}