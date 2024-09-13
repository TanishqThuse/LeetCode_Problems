class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        
        int n = arr.length;
        int m = queries.length;
        int[] res = new int[m];
        for(int i=0; i<m; i++){
            int s = queries[i][0];
            int e = queries[i][1];
            int xor = 0; //since x^0 =x , 0 is only value which does not alternate the result
            for(int j=s; j<= e; j++){
                // if(j==s){
                //     xor = j;
                // }
                // else{
                    xor = xor ^ arr[j];
                // }
            }
            res[i] = xor;
        }
        return res;

        

    }
}