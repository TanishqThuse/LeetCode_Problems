class Solution {
public:
    bool isValid(std::string s) {
        std::stack<char> stack;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char ch = s[i];
            if(ch == '(') {
                stack.push(')');
            }
            else if(ch == '{') {
                stack.push('}');
            }
            else if(ch == '[') {
                stack.push(']');
            }
            else {
                //this is very imp condition which i used to oten forget
                if(stack.empty() || stack.top() != ch) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }
};
