class Solution {
public:
    string f(string s){
        int n = s.size();
        int cnt = 1;
        char ch = s[0];
        string res = "";
        for(int i=1; i<n ; i++){
            // count the no. of similar items
            if(s[i] == ch){
                cnt++;
            }
            else{
                res += to_string(cnt) + ch;
                ch = s[i];
                cnt = 1;
            }
        }
        res += to_string(cnt) + ch;
        return res;
    }

    string countAndSay(int n) {
        if(n==1){
            return "1";
        }

        string s = "1";
        for(int i=0; i<n-1; i++){
            s = f(s);
        }
        return s;

        // return f(n, s);
    }
};