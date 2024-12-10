public class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        int l = 1, r = n;

        if (!helper(s, n, l)) return -1;

        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (helper(s, n, mid)) l = mid;
            else r = mid;
        }

        return l;
    }

    private boolean helper(String s, int n, int x) {
        int[] cnt = new int[26];
        int p = 0;

        for (int i = 0; i < n; i++) {
            while (s.charAt(p) != s.charAt(i)) p++;
            if (i - p + 1 >= x) cnt[s.charAt(i) - 'a']++;
            if (cnt[s.charAt(i) - 'a'] > 2) return true;
        }

        return false;
    }
}

// class Solution {
//     public int maximumLength(String s) {
//         //brute force since length of s is small
//         int n = s.length();
//         for(int i=0; i<n; i++){
//             for(int j=i+3; j<n; j++){
//                 String sub = s.substring(i,j);
//                 char ch = sub.charAt(0);
//                 for(int k=0; k<sub.length(); k++){
//                     char ch = 
//                 }
//             }
//         }
//     }
// }