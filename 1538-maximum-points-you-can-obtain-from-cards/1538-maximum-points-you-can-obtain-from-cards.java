class Solution {
    public int maxScore(int[] cardPoints, int k) {
        //I love this question
        //we have find the WINDOW/RANGE OF SUM WHERE SUM IS MINMUM
        int n = cardPoints.length;

        int totalSum = 0 ;
        for(int i=0; i<n; i++){
            totalSum += cardPoints[i];
        }
        int minSum = Integer.MAX_VALUE;
        

        // int windowSum = sum(length=n-k)
        int windowSum = 0;
        int l = n-k;
        for(int i=0; i<l ;i++)
        {
            windowSum += cardPoints[i];
        }

        minSum = Math.min(windowSum, minSum);

        for(int i=l; i<n; i++){
            windowSum += cardPoints[i] - cardPoints[i-l];
            minSum = Math.min(windowSum , minSum);
        }

        //now we have to retunr the maxSum without the window
        return totalSum - minSum;

    }
}