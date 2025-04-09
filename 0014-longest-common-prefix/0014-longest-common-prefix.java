class Solution {
    public String longestCommonPrefix(String[] strs) {

        // Approach : start with first string and go on extraccting common part itself
        int n = strs.length;

        String comm = strs[0];
        int m = comm.length();
        for(int i=1; i<n; i++){
            String curr = strs[i];
            int o = curr.length();
            m = comm.length();
            int j = 0;
            if (comm.isEmpty()) return "";
            for( j=0; j<Math.min(m,o); j++){
                char ch1 = curr.charAt(j);
                char ch2 = comm.charAt(j);
                if(ch1!=ch2){
                    break;
                }
            }
            comm = comm.substring(0,j);
        }
        return comm;



        // Arrays.sort(strs);
        // //Because of this it is evident that if the start and end string are not same then there is no meanign in checking intermediate strings ... duhh
        // String s1 = strs[0];
        // String s2 = strs[strs.length-1];
        // int idx = 0;
        // while(idx < s1.length() && idx < s2.length()){
        //     if(s1.charAt(idx) == s2.charAt(idx)){
        //         idx++;
        //     } 
        //     else{
        //         break;
        //     }
        // }
        // return s1.substring(0,idx);
    }
}