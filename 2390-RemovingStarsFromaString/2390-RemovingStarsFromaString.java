import java.util.Stack;

class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        
        // Iterate through each character in the string
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                // Pop from the stack if '*' is encountered
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                
                stack.push(ch);
            }
        }
        
        // Build the result string from the characters in the stack
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        
        // Reverse the string since the stack pops elements in reverse order
        return ans.reverse().toString();
    }
}


// class Solution {
//     public String removeStars(String s) {
//         Stack<Character> stack = new Stack<>();
//         int n = s.length();
//         for(int i=0; i<n; i++){
//             char ch = s.charAt(i);
//             if(ch=='*' && !(stack.isEmpty())){
//                 stack.pop();
//             }
//             //i not only avoided pushing * in stack but also i removed top element
//             else{
//                stack.push(ch);
//             }
//         }
//         //convert stack to string
//         StringBuilder ans = new StringBuilder();
//         for(int i=0; i<stack.size(); i++){
//             ans.append(stack.pop());
//         }
//         return ans.reverse().toString();
//     }
// }