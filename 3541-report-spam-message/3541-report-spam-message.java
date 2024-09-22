class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        HashSet<String> set = new HashSet<>();
        int m = bannedWords.length;
        for(int i=0; i<m; i++){
            set.add(bannedWords[i]);
        }
        int n = message.length;
        int c = 0;
        for(int i=0; i<n; i++){
            if(set.contains(message[i])){
                c++;
            }
        }
        if(c>=2){
            return true;
        }else{
            return false;
        }
    }
}