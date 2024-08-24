class Solution {
    public int bitwiseComplement(int n) {
        String str = Integer.toBinaryString(n);
        String res = "";
        int l = str.length();
        for(int i=0; i<l; i++){
            if(str.charAt(i) == '0'){
                res += '1';
            }
            else{
                res += '0';
            }
        }
        return Integer.parseInt(res,2);
    }
}