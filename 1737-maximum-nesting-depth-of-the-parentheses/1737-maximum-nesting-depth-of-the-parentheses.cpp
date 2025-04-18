class Solution {
public:
    int maxDepth(string s) {
        stack<char> stk;
        //basically keep the stack count as max_stack_count, if '(' then push, if ')' them pull, at each step keep count=max(count, stack.size())
        int cnt = 0;
        for(char c : s){
            if(c=='('){
                stk.push('(');
            }
            else if(c==')'){
                stk.pop();
            }
            int size = stk.size();
            cnt = max(cnt, size);
        }
        return cnt;
    }
};