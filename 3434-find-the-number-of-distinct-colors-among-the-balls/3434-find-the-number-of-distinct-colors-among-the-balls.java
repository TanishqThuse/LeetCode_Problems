import java.util.*;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n]; // Result array to store the number of distinct colors after each query
        
        // Map to store the current color of each ball
        Map<Integer, Integer> ballColorMap = new HashMap<>();
        
        // Map to store the count of balls for each color
        Map<Integer, Integer> colorCountMap = new HashMap<>();
        
        // Set to store distinct colors
        Set<Integer> distinctColors = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            int ballIdx = queries[i][0];
            int newColor = queries[i][1];
            
            // Get the previous color of the ball
            Integer prevColor = ballColorMap.get(ballIdx);
            
            if (prevColor != null) {
                // If the ball was previously colored, decrement the count for that color
                colorCountMap.put(prevColor, colorCountMap.get(prevColor) - 1);
                
                // If the count drops to 0, remove the color from the distinct colors set
                if (colorCountMap.get(prevColor) == 0) {
                    distinctColors.remove(prevColor);
                }
            }
            
            // Update the ball's color
            ballColorMap.put(ballIdx, newColor);
            
            // Increment the count for the new color
            colorCountMap.put(newColor, colorCountMap.getOrDefault(newColor, 0) + 1);
            
            // Add the new color to the distinct colors set
            distinctColors.add(newColor);
            
            // Store the number of distinct colors in the result array
            result[i] = distinctColors.size();
        }
        
        return result;
    }
}

//I almost gave up at 32:00 minutes

// class Solution {
//     public int[] queryResults(int limit, int[][] queries) {
//         int n = queries.length;

//         //we have limit+1 balls
//         boolean[] ballColoured = new boolean[n+1];
//         //initially all are not coloured

//         int[] currentBallColourArr = new int[n]; //res array
//         for(int i=0; i<n; i++){
//             currentBallColourArr = Integer.MIN_VALUE;
//         }

//         int currentDistinctBalls = 0;

//         // Set<Integer> colourCount = new HashSet<>();

//         // Set<Boolean> repeatedColourMultipleTimes = new HashSet<>();

//         HashMap<Integer, Integer> mapForColourRepeatCount = new Hashmap<>();

//         for(int i=0; i<n; i++){
//             int ballIdx = queries[n][0];
//             int ballColour = queries[n][1];

//             int prevColour = currentBallColourArr[ballIdx];

//             if(prevColour == Integer.MIN_VALUE){
//                 //no colour assigned till now
//                 if(mapForColourRepeatCount.getOrDefault(ballColour,0) > 0 ) {
//                     //this means unique colour count decreases

//                     mapForColourRepeatCount.put(mapForColourRepeatCount.getOrDefault(ballColour,0)+1);
//                 }
//                 else{
//                     mapForColourRepeatCount.put(ballColour,0);
//                     currentDistinctBalls++;
//                 }

//                 if(mapForColourRepeatCount.get(ballColour) > 1){
//                     //no effect since unique count is already decrease
//                 }
//                 else{
//                     currentDistinctBalls--;
//                 }
//             }
//             else{
//                 //now the colour is going to get repeated definately
//                 //check the repeatedColourMultipleTimes variable here also

//                 //the colour is new and assigned till now

//                 //now we have a fixed prev colour for comparison

//                 //case - 1 : prevColour appears again, in this case do nothing
//                 if(prevColour == ballColour) {
//                     //eat 5 star
//                 }
//                 else{
//                     //we have a differencce in colours
//                     mapForColourRepeatCount.put(prevColour, mapForColourRepeatCount.get(prevColour)-1);

//                     if(mapForColourRepeatCount.get(prevColour) == 1){
//                         currentDistinctBalls++;
//                     }
//                     else{
//                         //leave it , either we lost the colour or its colour is >1

//                         //now focus on the new colour
//                         int prevCountOfTheMapFuckingVariable = mapForColourRepeatCount.getOrDefault(ballColour,0);

//                         mapForColourRepeatCount.put(mapForColourRepeatCount.getOrDefault(ballColour, 0)+1);

//                         //now check if the new colour has become unique or lost it's uniqueness
//                         if(mapForColourRepeatCount.get(ballColour) - prevCountOfTheMapFuckingVariable ){
//                             currentDistinctBalls++;
//                         }
//                         else if({
//                             //if it's >1 reduce the count
//                         }
//                     }
//                 }



//                 // if(mapForColourRepeatCount.getOrDefault(ballColour,0) >  ) {
//                 //     //this means unique colour count decreases

//                 //     if(repeatedColourMultipleTimes.contains(ballColour)) {
//                 //         //then don't decrease counter
//                 //     }
//                 //     else{
//                 //         //else decrease counter
//                 //         colourCount.add(ballColour);

//                 //         repeatedColourMultipleTimes.add(ballColour);

//                 //         currentDistinctBalls++;
//                 //     }
//                 // }
//             }


//             currentBallColourArr[ballIdx] = ballColour;

//         }
//     }
// }