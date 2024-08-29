class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length;
        int sum = 0;
        for(int i=n/3; i<n ;i=i+2){
            sum+=piles[i];
        }
        return sum;
    }
}