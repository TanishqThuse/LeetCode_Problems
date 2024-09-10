import java.util.Arrays;

//Approach 1 : Sort both the string and create an Array of string ffrom it and compare both the freaking arrays
//Not good as O(n log n ) complexity
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);

        return Arrays.equals(sCharArray, tCharArray); 
    }
}

//My Approach - Approach 0 ==> Compare each char frmo HashSet 
// class Solution {
//     public boolean isAnagram(String s, String t) {
//         int length = s.length();
//         int count =0;
//         HashSet<Character> characters = new HashSet<>();
//         for(int i=0; i<length; i++){
//             char ch = s.charAt(i);
//             characters.add(ch);
//         }
//         for(int i=0; i<length; i++){
//             char ch1 = s.charAt(i);
//             if(characters.contains(ch1)){
//                 count++;
//             }
//         }
//         if(count == length){
//             return true;
//         }
//         return false;
//     }
// }