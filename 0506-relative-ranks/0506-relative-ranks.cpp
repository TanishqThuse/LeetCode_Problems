class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& score) {
        int n = score.size();
        vector<string> result(n);

        //Declaring a max priority queue storing as {score,index}
        priority_queue<pair<int, int>> maxHeap;

        //Step-1 : Push all elements into heap 
        for(int i=0; i<n; i++){
            //this below implementation doesn't work since the map heap would be sorted on basis of i
            // maxHeap.push({i, score[i]});

            //instead we want it to be sorted on basis or score[i]
            maxHeap.push({score[i],i});
        }

        //Step-2 :  Extract all elements and assign ranks 
        for(int rank = 1; !maxHeap.empty(); rank++){
            int idx = maxHeap.top().second; 
            maxHeap.pop();

            if(rank == 1) {
                result[idx] = "Gold Medal"; 
            }
            else if(rank == 2){
                result[idx] = "Silver Medal";
            }
            else if(rank == 3){
                result[idx] = "Bronze Medal";
            }
            else {
                // result[idx] = '0' + (char)rank; works only for 1-9
                result[idx] = to_string(rank); //works for all
            }
        
        }
        return result;
    }
};