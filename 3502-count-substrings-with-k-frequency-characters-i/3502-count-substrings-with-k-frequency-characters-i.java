//Sliding window 
class Solution {
    public int numberOfSubstrings(String s, int k) {
        int n = s.length();
        int c = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        int i,j;
        
        i = j = 0;

        while (j < n) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (satisfy(map, k)) {
                c += n - j;
                char leftChar = s.charAt(i);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                i++;
            }
            j++;
        }
        return c;
    }

    public boolean satisfy(HashMap<Character, Integer> map, int k) {
        for (int freq : map.values()) {
            if (freq >= k) {
                return true;
            }
        }
        return false;
    }
}


//Brute force : O(n^3) give TLE
// class Solution {
//     //Brute force : O(n^3) time complexity
//     public int numberOfSubstrings(String s, int k) {
//         int n = s.length();
//         int c= 0 ;
//         for(int i=0; i<n; i++){
//             for(int j=i+k; j<=n; j++){
//                 String sub = s.substring(i,j);
//                 if(satisfy(sub, k)){
//                     c++;
//                 }
//             }
//         }
//         return c;
//     }
//     public boolean satisfy(String sub, int k){
//         int n = sub.length();
//         HashMap<Character, Integer> map = new HashMap<>();
//         for(int i=0; i<n; i++){
//             char ch=sub.charAt(i);
//             map.put(ch, map.getOrDefault(ch,0)+1);
//         }
//         for(int i=0; i<n ; i++){
//             // char ch = map.get(i);
//             char ch = sub.charAt(i);
//             if(map.get(ch) >= k){
//                 return true;
//             }
//         }
//         return false;
//     }
// }