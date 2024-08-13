import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    
    List<List<Integer>> list = new ArrayList<>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Sort the array to handle duplicates easily
        Arrays.sort(candidates);
        List<Integer> tempList = new ArrayList<>();
        helper(tempList, target, candidates, 0);
        return list;
    }
    
    public void helper(List<Integer> tempList, int target, int[] candidates, int index) {
        if (target == 0) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        if (target < 0) {
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            // Skip duplicates
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            tempList.add(candidates[i]);
            helper(tempList, target - candidates[i], candidates, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}


// class Solution {


//         List<List<Integer>> list = new ArrayList<>();
//     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//         List<Integer> tempList = new ArrayList<>();
//         int sum = 0;

//         helper(tempList, target, candidates, 0);
//         return list;
//     }
//     public void helper(List<Integer> tempList, int target, int candidates[], int index){
//         if(target==0){
//             list.add(new ArrayList<>(tempList));
//             return;
//         }
//         else if(target<0){
//             return ;
//         }

//         for(int i=index; i<candidates.length; i++){
//             tempList.add(candidates[i]);
//             helper(tempList, target-candidates[i], candidates, i);
//             tempList.remove(tempList.size()-1);
//         }
//     }
// }