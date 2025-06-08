class Solution {
public:
    vector<int> lexicalOrder(int n) {
        vector<int> arr;
        int cnt = 1;
        for(int i=0; i<n; i++){
            arr.push_back(cnt);
            if(cnt * 10 <= n){
                cnt *= 10; //10 ->100 if 100 is still in the range
            }
            else{
                if(cnt >= n){
                    cnt /= 10; //go up now
                }
                cnt++;
                while(cnt % 10 == 0){
                    // we hvae to remoce all zeroees
                    cnt /= 10;
                }
            }
        }
        return arr;
    }
};