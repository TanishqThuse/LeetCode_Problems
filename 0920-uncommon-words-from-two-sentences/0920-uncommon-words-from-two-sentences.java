class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        
        //put s1 words in map1 and similarly for map2
        String[] ch1 = s1.split(" ");
        String[] ch2 = s2.split(" ");
        
        for(int i=0; i<ch1.length; i++){
            map1.put(ch1[i], map1.getOrDefault(ch1[i],0)+1);
        }
        for(int i=0; i<ch2.length; i++){
            map2.put(ch2[i], map2.getOrDefault(ch2[i],0)+1);
        }

        int c = 0; //count number of uncommon words

        String ans = "";

        //now traverse map1 for it
        for(int i=0; i<ch1.length; i++){
            String s = ch1[i];
            if(map1.get(s)==1 && map2.getOrDefault(s, 0)==0){
                c++;
                ans += s + " ";
            }
        }
        //now traverse map2 for it
        for(int i=0; i<ch2.length; i++){
            String s = ch2[i];
            if(map2.get(s)==1 && map1.getOrDefault(s, 0)==0){
                c++;
                ans += s + " ";
            }
        }

        String[] res = new String[c];//= ans.split(" ");
        // if(ans == " "){
        //     return new String[0];
        // }
         if (ans.trim().isEmpty()) {
            return new String[0];
        }
        res = ans.split(" ");
        if(res.length == 0){
            return res;
        }



        return res;

    }
}