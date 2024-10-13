class Solution {

    //Misunderstood the funcion
    //thoiugh we were suppposed to take the freq > x    
    // public int xSum(int[] nums, int i, int j, int k, int x){
    //     int sum = 0; 
    //     if(k == x){
    //         //return subarray
    //         for(int p = i ; p<=j ; p++){
    //             sum += nums[p];
    //         }
    //     }
    //     else{
    //         //find the top freq using hashmap
    //         HashMap<Integer, Integer> map = new HashMap<>();
    //         //basically calculate all element freq and tsore in map
    //         for(int p = i; p<=j; p++){
    //             map.put(nums[p], map.getOrDefault(nums[p],0)+1);
    //         }

    //         //now check if it contains at least x top elements with freq > x
    //         boolean flag = true;
    //         int c = 0 ;
    //         // int SUM = 0;
    //         for(int p = i ; p<=j ; p++){
    //             if(map.get(nums[p])>x){
    //                 c++;
    //                 sum += nums[p];
    //             }
    //         }            
    //     }
    //     return sum;
    // }

    public int xSum(int[] nums, int i, int j, int k, int x) {
    int sum = 0; 
    if (k == x) {
        for (int p = i; p <= j; p++) {
            sum += nums[p];
        }
    }
     else {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int p = i; p <= j; p++) {
            map.put(nums[p], map.getOrDefault(nums[p], 0) + 1);
        }

        List<int[]> freqList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freqList.add(new int[]{entry.getKey(), entry.getValue()});
        }

        Collections.sort(freqList, (a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];
            }
            return b[1] - a[1];
        });

        int count = 0;
        for (int[] elem : freqList) {
            if (count >= x) break;
            sum += elem[0] * elem[1];
            count++;
        }
    }
    return sum;
}


    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int m = n-k+1;
        int[] ans = new int[m];
        
        for(int i=0; i<m; i++){
            //we have to get sum for n-k+1 elements
            ans[i] = xSum(nums, i, i+k-1, k,x);
        }
        return ans;
    }
}