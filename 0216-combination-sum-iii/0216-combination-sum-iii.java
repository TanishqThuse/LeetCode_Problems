class Solution {
    void find(List<Integer> It, List<List<Integer>> ans, int i, int[] nums, int n, int k){
        // pruning condition
        // either target is <0 or the required element(similar to the size of the tempList > k)
        if(n < 0 || It.size() > k){
            return;
        }

        // target found since sum = 0 && size of tempList is the siozeof the requred nuymber of elements
        if(n==0 && It.size() == k){
            ans.add(new ArrayList<>(It));
        }

        // now the fun begins
        for(int s = i; s <= 9; s++){
            It.add(s);
            find(It, ans, s+1, nums, n-s, k);

            // backtrack
            It.remove(It.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1,2,3,4,5,6,7,8,9};

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> It = new ArrayList<>(); //It is like the tempList here in this case
        find(It, ans, 1, nums, n, k);
        return ans;
    } 
}