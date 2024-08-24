class Solution {
    public int divide(int dividend, int divisor) {
        int ctr = dividend / divisor;
        if(dividend == Integer.MIN_VALUE &&  divisor == -1){
            return Integer.MAX_VALUE;
            //to denote integer overflow as 2147483648 is highest int value
        }
        return ctr; 
    }
}