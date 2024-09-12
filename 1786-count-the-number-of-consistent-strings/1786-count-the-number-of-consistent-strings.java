class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int n = words.length;
        int count= 0;
        //sapce = O(1)
        int m = allowed.length();
        HashSet<Character> set = new HashSet<>();
        //space = O(m)
        for(int i=0; i<m; i++){
            set.add(allowed.charAt(i));
        }
        //time = O(m), space = O(m)
        for(int i=0; i<n; i++){
            //time for loop = O(n)
            //comparison for set will be like O(m)
            //in this case time would be O(n) * O(m) * O(k) 
            //so instead of using an array for char set of allwoed
            //i will use a hashset
            int k = words[i].length();
            int flag = 1;
            for(int j=0; j<k; j++){
                if(!(set.contains(words[i].charAt(j))))
                {
                    flag = 0;
                    break;
                }
            }
            if(flag == 1){
                count++;
            }
        }
    return count;
    }
}