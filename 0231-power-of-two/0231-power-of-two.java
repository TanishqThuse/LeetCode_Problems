class Solution {
    public boolean isPowerOfTwo(int n) {
        //my approach withotu bit mani[uation
        boolean flag = true;
        while(n % 2 == 0){
            if(n == 1 || n == 0){
                break;
            }
            n = n / 2;
        }
        if(n==1){
            return true;
        }
        else{
            return false;
        }
        
    }
}