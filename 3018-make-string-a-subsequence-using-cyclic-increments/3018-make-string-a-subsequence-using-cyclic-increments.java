
//brute force
// class Solution {
//     public boolean canMakeSubsequence(String str1, String str2) {
//         int n = str1.length();
//         int m = str2.length();
//         int idx = 0;
//         for(int i=0; i<n && idx<m; i++){
//             char ch1 = str1.charAt(i);
//             char ch2 = str2.charAt(idx);
//             if(ch1-1 == ch2)
//         }
//     }
// }

class Solution {
    public boolean canMakeSubsequence(String source, String target) {
        int targetIdx = 0, targetLen = target.length();
        
        for (char currChar : source.toCharArray()) {
            if (targetIdx < targetLen && (target.charAt(targetIdx) - currChar + 26) % 26 <= 1) {
                targetIdx++;
            }
        }
        return targetIdx == targetLen;
    }
}