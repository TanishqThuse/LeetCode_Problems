class Solution {
    public String getEncryptedString(String s, int k) {
        int n = s.length();
        String str = "";

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            ch = s.charAt((i+k)%n);
            //EDIT : Mistake : I forgot to keep a copy of s and takingn new char fro odified works not
            str += ch;
        }
        return str;



        //did not read question properly though they want cyclic from a-z turns out they want withing string
        // for(int i=0; i<n; i++){
        //     char ch = s.charAt(i);
        //     if((int)ch+k > 122){
        //         ch = (char)((int)ch+k-26); 
        //     }
        //     else{
        //         ch = (char)((int)ch+k);
        //     }
        //     s = s.substring(0,i) + ch + s.substring(i+1); 
        // }
        // return s;
    }
}