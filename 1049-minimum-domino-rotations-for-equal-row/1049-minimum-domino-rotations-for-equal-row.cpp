class Solution {
public:
    int minDominoRotations(vector<int>& tops, vector<int>& bottoms) {
        int n = tops.size();
        // we take two cases, one we make the top element equal, one we make the bottom element equal
        // firstly we should count the max value of any index in all the topp and bottom element
        int top_min = INT_MAX;
        int bott_min = INT_MAX;

        map<int, int> mpp;
        for(int ele : tops){
            mpp[ele]++;
        }
        for(int ele : bottoms){
            mpp[ele]++;
        }

        // just check the max element
        int maxi = -1;
        int maxFreq = 0;

        for(auto pair : mpp){
            if(pair.second > maxFreq){
                maxi = pair.first;
                maxFreq = pair.second;
            }
        }

        // now check if the element is occuring in both the top OR bottom dices, if it doesn't occur we return -1
        for(int i=0; i<n; i++){
            if(tops[i] == maxi || bottoms[i]==maxi){
                // eat 5 star
            }
            else{
                return -1;
            }
        } 

        // now first make tops[i] == maxi
        int cnt1 = 0;
        for(int i=0; i<n; i++){
            if(tops[i] != maxi) cnt1++;
        }
        int cnt2 = 0;
        for(int i=0; i<n; i++){
            if(bottoms[i] != maxi) cnt2++;
        }
        return min(cnt1,cnt2);


    }
};