class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] raj = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            int sec = Character.getNumericValue(secret.charAt(i));
            int gu = Character.getNumericValue(guess.charAt(i));

            if (sec == gu) {
                bulls++;
                continue;
            }
            if (raj[sec] < 0) {
                cows++;
            }
            if (raj[gu] > 0) {
                cows++;
            }
            raj[sec]++;
            raj[gu]--;
        }

        return bulls + "A" + cows + "B";
    }
}

//Good question
// class Solution {
//     public String getHint(String secret, String guess) {
//         int bull = 0;
//         int cow = 0;
//         int n = secret.length();
//         HashMap<Character, Integer> set = new HashMap<>();
//         for(int i=0; i<n; i++){
//             char ch = guess.charAt(i);
//             set.put(ch, set.getOrDefault(ch, 0)+1);
 
//         }
//         HashMap<Character, Integer> set2 = new HashMap<>();
//         for(int i=0; i<n; i++){
//             char ch = secret.charAt(i);
//             set2.put(ch, set2.getOrDefault(ch, 0)+1);
//         }

//         for(int i=0; i<n; i++){
//             if(secret.charAt(i) == guess.charAt(i)){
//                 bull++;
//                 //even if the element is a bull we MUST put it in HashMap4
//                 set.put(secret.charAt(i), 1);
//             }
//             else{
//                 char ch = secret.charAt(i);
//                 if(set.containsKey(ch))
//                 {
//                     if(set.get(ch)>0){
//                         continue;
//                     }

//                     if(set2.get(ch)>1){
//                         continue;
//                     }
//                     cow++;
//                     set.put(ch,1);
//                 }

//                 // cow++;
//                 // set.add(guess.charAt(i))
//             }
//         }
//         String res = "";
//         res += String.valueOf(bull) + "A" + String.valueOf(cow) + "B";
//         return res; 
//     }
// }