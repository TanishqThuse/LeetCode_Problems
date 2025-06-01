// Approach - 2 : Bracktracking and pruning approaches
class Solution {
public:
    void backtrack(int start, int target, vector<int>& candidates, vector<int>& tempList, vector<vector<int>>& res) {
        if (target == 0) {
            res.push_back(tempList);
            return;
        }

        for (int i = start; i < candidates.size(); ++i) {
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            // Prune: no point in continuing if current candidate > target
            if (candidates[i] > target) break;

            tempList.push_back(candidates[i]);
            backtrack(i + 1, target - candidates[i], candidates, tempList, res);
            tempList.pop_back();
        }
    }

    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end()); // Required for skipping duplicates
        vector<vector<int>> res;
        vector<int> tempList;
        backtrack(0, target, candidates, tempList, res);
        return res;
    }
};



// // Approach 1 : Use a set and finally convert the elements of set to a vector
// class Solution {
// public:
//     void helper(int idx, int target, vector<int>& tempList,  vector<int>& candidates, set<vector<int>>& list){
//         // also make sure to see if the idx is over then put it in list
//         if(idx == candidates.size()){
//             if(target == 0){
//                 list.insert(tempList);
//             }

//             return; ///imp step
//         }

//         // first dont take the current 
//         helper(idx + 1, target,tempList, candidates, list);

//         // in second case do take the currectnt element
//         tempList.push_back(candidates[idx]);
//         helper(idx + 1, target - candidates[idx],tempList, candidates, list);

//         // now since we passing the addresses of the elements do not forget to remoce the current element
//         tempList.pop_back();
//     }   

//     vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
//         set<vector<int>> list;
//         sort(candidates.begin(), candidates.end());

//         vector<int> tempList;

//         helper(0, target, tempList, candidates, list);

//         vector<vector<int>> res(list.begin(), list.end());

//         return res;
//     }
// };