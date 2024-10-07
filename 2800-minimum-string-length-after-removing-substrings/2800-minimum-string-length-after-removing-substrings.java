class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cur_char = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(cur_char);
                continue;
            }
      
            if (cur_char == 'B' && stack.peek() == 'A') {
                stack.pop();
            }
            else if (cur_char == 'D' && stack.peek() == 'C') {
                stack.pop();
            }
            else {
                stack.push(cur_char);
            }
        }

        return stack.size();
    }
}

// class Solution {
//     public int minLength(String s) {
//         String s1 = "AB";
//         String s2 = "CD";
//         int n = s.length();
//         int n1 = n;
//         boolean flag = true;
//         String newString = s;
//         while(flag == true){
//             for(int i=0; i<n-1; i++){
//             String sub = s.substring(i,i+2);
//             if(sub.equals(s1) || sub.equals(s2)){
//                 n1 -= 2;
//                 if(i+2 < n)
//                     newString = s.substring(0,i) + s.substring(i+2);
//                 else
//                     newString = s.substring(0,i);
//             }
//             s = newString;
//             if(n1 == n){
//                 flag = false;
//             }
//             n = n1;
//         }        
//     }
//         return n1;
// }
// }