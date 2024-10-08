class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        int unbalanced = 0;
        int n = s.length();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);

            if(ch=='['){
                stack.push(ch);
            }
            else{
                //if stack is not empty pop it, since we except a oppning brack is already in it then
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    unbalanced++;
                }
            }
        }
        return (unbalanced + 1) / 2;
    }
}