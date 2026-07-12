class Solution {
public:
    vector<int> arrayRankTransform(vector<int>& arr) {
        int n = arr.size();
        map<int,int> mpp;
        vector<int> arr2(arr);
        sort(arr.begin(), arr.end());


        int rank = 0;
        for(int i=0; i<n; i++){
            if(i>0 && arr[i]!=arr[i-1])
                mpp[arr[i]] = ++rank;
            else if(i==0){
                mpp[arr[i]] = ++rank;
            }
            else{
                mpp[arr[i]] = rank;
            }
        }

        vector<int> ans(n);
        for(int i=0; i<n; i++){
            ans[i] = mpp[arr2[i]];
        }
        return ans;
    }
};