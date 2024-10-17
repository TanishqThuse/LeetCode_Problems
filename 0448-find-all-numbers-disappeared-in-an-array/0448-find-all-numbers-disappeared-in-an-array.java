class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(i+1, 0);
        }

        //now simply put it from array
        for(int i=0; i<n; i++){
            map.put(nums[i], map.get(nums[i])+1);
        }

        List<Integer> numbersWhoWentToBuyMilk = new ArrayList<>();

        for(int i=1; i<=n; i++){
            if(map.get(i) == 0){
                numbersWhoWentToBuyMilk.add(i);
            }
        }
        return numbersWhoWentToBuyMilk;
    }
}