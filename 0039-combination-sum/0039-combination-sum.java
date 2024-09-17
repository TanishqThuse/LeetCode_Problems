// /**Time Complexity: The time complexity is O(k^n) or, in a more detailed and problem-specific form, it is bounded by the number of combinations.
// Space Complexity: The space complexity is 
// O(T)+O(C⋅T), where T is the target sum and C is the number of combinations.
//  */

//Practise again
class Solution{
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        //first we create a list where we can put the values
        List<List<Integer>> list = new ArrayList<>();
        //sort array to not miss any combo
        Arrays.sort(candidates);
        backtracking(new ArrayList<>(), candidates, target, 0 , list);
        return list;
    } 

    public void backtracking(List<Integer> tempList , int[] candidates, int sumLeft, int idx, List<List<Integer>> list ){
        if(sumLeft < 0){
            return;
        }
        else if(sumLeft == 0){
            list.add(new ArrayList<>(tempList));
        }
        else{
            for(int i=idx; i<candidates.length; i++){
                tempList.add(candidates[i]);
                int newSumLeft = sumLeft - candidates[i];
                //we are passing idx = i  since this prblm allows us to add the same character multiple times
                backtracking(tempList, candidates, newSumLeft, i, list);
                tempList.remove(tempList.size()-1);

            }
        }
    }
}


// class Solution {
//     List<List<Integer>> list = new ArrayList<>();
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         //we sort candidates array to make sure we dont miss any combo
//         Arrays.sort(candidates);
//         backtracking(new ArrayList<>(), candidates, target, 0);
//         return list;
//     }

//     public void backtracking(List<Integer> tempList, int[] candidates, int remaining_sum , int start){
//         if(remaining_sum<0){
//             return ;
//         }
//         else if(remaining_sum==0){
//             list.add(new ArrayList<>(tempList));
//         }
//         else{
//             for(int i = start; i<candidates.length; i++){
//                 tempList.add(candidates[i]);
//                 int sumLeft = remaining_sum - candidates[i];
//                 backtracking(tempList, candidates,sumLeft,i);
//                 tempList.remove(tempList.size()-1);
//             }
//         }
//     }
// }