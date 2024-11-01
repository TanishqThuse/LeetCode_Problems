class Solution {
    public String makeFancyString(String s) {
        // StrinBuilder str = new StringBuilder(s);
        int n = s.length();
        if(n<1){
            return s;
        }
        StringBuilder str = new StringBuilder();
        str.append(s.charAt(0));
        for(int i=1; i<s.length()-1; i++){
            char curr = s.charAt(i);
            char prev = s.charAt(i-1);
            char next = s.charAt(i+1);
            if(curr == prev && curr == next){
                continue;
            }
            else{
                str.append(curr);
            }
        }
        //now i gotta append the last char
        //this is gicing problem
        if(n>1)
            str.append(s.charAt(n-1));
        return str.toString();
    }
}