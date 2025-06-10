class Solution {
public:
    int maxDifference(string s) {
        // most frequent off character
        // least frequent even character
        int a1=INT_MIN, a2=INT_MAX;
        map<char, int> freq;
        for(int i=0; i<s.size(); i++){
            freq[s[i]]++;
        }

        for(auto it = freq.begin(); it!=freq.end(); it++){
            if(it->second % 2 != 0){
                a1 = max(a1, it->second);
            }
            else{
                a2 = min(a2, it->second);
            }
        }

        return a1-a2;
    }
};