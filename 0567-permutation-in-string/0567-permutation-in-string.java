/**Initial map creation: O(n1)
Sliding window loop: O(n2 - n1), where each iteration has an O(1) cost due to isSubMap.
Thus, the total time complexity is O(n2), where n2 is the length of s2. */

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        int n1 = s1.length();
        //now ccreate a window for size n1
        int n2 = s2.length();
        if(n2 < n1){
            return false;
        }

        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i=0; i<n1; i++){
            char ch = s1.charAt(i);
            map1.put(ch, map1.getOrDefault(ch,0)+1);
            char ch2  = s2.charAt(i);
            map2.put(ch2, map2.getOrDefault(ch2, 0)+1);
        }

        //compare map2 and map1
        //today I learned about isSubMap(map1,map2) && map1.equals(map2)
        if(isSubMap(map1,map2)){
            return true;
        }

        for(int i=n1; i<n2; i++){
            char latest = s2.charAt(i);
            char old = s2.charAt(i-n1);
            map2.put(old, map2.get(old)-1);
            map2.put(latest,map2.getOrDefault(latest,0)+1);
            if(isSubMap(map1, map2)){
                return true;
            }
        }
        return false;
    }

    public boolean isSubMap(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2){
        for(Character key : map1.keySet()){
            // If map2 does not contain the key from map1, or if map2's count for the key is less than map1's count, return false
        if (!map2.containsKey(key) || map2.get(key) < map1.get(key)) {
            return false;
        }
        }
        return true;
    }
}