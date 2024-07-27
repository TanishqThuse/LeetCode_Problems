/*242. Valid Anagram
Solved
Easy
Topics
Companies
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.*/

import java.util.Arrays;

//Approach 1 : Sort both the string and create an Array of string ffrom it and compare both the freaking arrays
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




