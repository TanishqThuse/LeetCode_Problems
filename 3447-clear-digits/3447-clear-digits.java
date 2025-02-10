class Solution {
    public boolean isNum(char ch){
        int num = ch - '0';
        if(num >=0 && num<=9){
            return true;
        }
        return false;
    }
    public String clearDigits(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);

            if(isNum(ch) && sb.length()!=0){
                sb.deleteCharAt(sb.length()-1);
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}