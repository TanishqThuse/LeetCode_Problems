/**Pattern Recognization : The catchy point in this question was to 
identify the fact that the first and last element of 
each subArrayList is the min and max of the subList respectively 

This problem teaches me to read each line of problme ststement properly and not 
be in a rush to solve problems */

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        //a naive/brute force approach 
        //get first last element of first list inlise arrays
        //we tak e first and last since it's guaranteed the list is int sorted order//THUS THIS WAS THE PATTERN WE WERE SUPPOSED TO SE
        int min = arrays.get(0).get(0); //get first element of first list
        int max = arrays.get(0).get(arrays.get(0).size()-1); //get last elementr of last list

        int maxDistance = Integer.MIN_VALUE;

        for(int i=1; i<arrays.size(); i++){
            int currMin = arrays.get(i).get(0);
            int currMax = arrays.get(i).get(arrays.get(i).size() - 1 );

            maxDistance = Math.max(maxDistance, Math.abs(currMax - min));
            maxDistance = Math.max(maxDistance , Math.abs(max - currMin));
        
            //P.S : I forgot to change my global max and min value which is also very imp for this problem
            max = Math.max(max, currMax);
            min = Math.min(min, currMin);
        }
        return maxDistance;
    }
}