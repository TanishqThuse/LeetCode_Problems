class Solution {
public:
    string frequencySort(string s) {
        map<char,int> mpp;
        // int i=0;
        for(char ch : s){
            mpp[ch] += 1;
        }
        string output;

        //Convert the map to vector of pairs
        vector<pair<char, int>> vec(mpp.begin(), mpp.end());

        //sort it
        sort(vec.begin(), vec.end(), [](const pair<char, int> &a, const pair<char, int> &b){
            return a.second > b.second;
        });

        //now the vector is sorted in descending order. being char -> freq, 
        for(auto p : vec){
            //we have to put char , freq times
            for(int i=0; i<p.second; i++){
                output += p.first;
            }
        }

        return output;    
    }
};