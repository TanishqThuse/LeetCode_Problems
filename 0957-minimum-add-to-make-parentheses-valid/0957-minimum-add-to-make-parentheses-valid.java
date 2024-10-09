class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        int cnt  =0;
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.push(c);
            }
            else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    cnt++;
                }
            }
        }
        return stack.size() + cnt;
        //case - 1 : either some '(' left unassigned ==> so cnt==0 and stack.size() is utilised
        //case - 2 : or some ')' is unassigned ==> so stack.size()==0 and cnt is utilised
        //or some arbritrary combination works
    }
}