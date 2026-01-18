class Solution {
public:
    int vowelConsonantScore(string s) {
        int v=0,c=0;
        unordered_set<char> set = {'a','e','i','o','u'};
        unordered_set<char> others = {' ','1','2','3','4','5','6','7','8','9','0'};
        for(char ch : s){
            if(set.count(ch)){
                v++;
            }
            else if(others.count(ch) == 0){
                c++;
            }
        }
        int score = 0;
        if(c>0){
            score = v/c;
        }
        return score;
    }
};