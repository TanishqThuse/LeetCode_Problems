/**TIme comeplxity is : 
O(N) {trimming == reversing == spilliting}
So now the overall time complexity is O(n)

The overll sapce comelpixty is O(n) coz of string builder
 */

class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        // String[] words = s.split("\\s+"); //divides based on one or more space 
        // String word;
        for(int i=words.length-1; i>=0; i--){
            sb.append(words[i]);
            if(i!=0){
            sb.append(" ");
            }
        }
        return sb.toString();
    }
}