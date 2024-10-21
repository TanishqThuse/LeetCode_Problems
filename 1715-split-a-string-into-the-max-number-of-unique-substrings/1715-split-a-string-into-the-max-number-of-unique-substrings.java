class Solution {
    public int maxUniqueSplit(String s) {
        return backtrack(0, s, new HashSet<>());
    }
    public int backtrack(int start, String s, HashSet<String> seen) {
        if (start == s.length()) {
            return 0; 
        }
        
        int maxSplits = 0;
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (!seen.contains(substring)) {
                seen.add(substring); 
                maxSplits = Math.max(maxSplits, 1 + backtrack(end, s, seen));
                seen.remove(substring);
            }
        }
        return maxSplits;
    }
}

// class Solution {
//     public int maxUniqueSplit(String s) {
//         int idx = 0;
//         int n = s.length();
//         HashSet<String> unique = new HashSet<>();
//         // for(int i=0; i<n; i++)
//         int i = 1;
//         if(n<1){
//             return 0;
//         }
//         String firstStr = s.substring(idx,idx+1); 
//         unique.add(firstStr);
//         idx = idx + 2;
//         while(i < n)
//         {
//             String str = s.substring(i,idx);
//             String temp = 
//             if(unique.contains())
//         }
//     }
// }