class Solution{
    public int candy(int[] ratings){
        int n = ratings.length;
        int count=0;
        HashMap<Integer, Integer> candies = new HashMap<>();
        // Step 1: Ensure All Children Start with at Least 1 Candy
        for (int i = 0; i < n; i++) {
            candies.put(i, 1);
        }

        // Step 2: Correctly Handle the Left-to-Right and Right-to-Left Passes
        
        //Left-to-Right Pass
        for(int i=1; i<n; i++){
            if(ratings[i]>ratings[i-1]){
                candies.put(i, candies.get(i-1)+1);
            }
        }

        // Right-to-Left Pass:
        for(int i=(n-1)-1; i>=0 ; i--){
            if(ratings[i] > ratings[i+1]){
                candies.put(i, Math.max(candies.get(i), candies.get(i+1)+1));
            }
        }

        // Step 3: Sum All Candies
        int sum = 0;
        for(int candy : candies.values()){
            sum+=candy;
        }

        return sum;
    }
}



//I feel like my apprach was geetting a lot messy and unnesary cmplicated so starting fro scratch again

// class Solution {
//     public int candy(int[] ratings) {
//         int n = ratings.length;
//         int count=0;
//         HashMap<Integer, Integer> candies = new HashMap<>();

//         //Edit : I forgot about initialization for each child and some cases occur whee it is left empty
//         for(int i=0; i<n; i++){
//             if(i-1<0){
//                 if(ratings[i+1]<ratings[i]){
//                     candies.put(i,2);
//                 }else{
//                     //rat[i+1]>rat[i]
//                     candies.put(i,1);
//                 }
//             }
//             else if(i+1>=n){
//                 if(ratings[i-1]<ratings[i]){
//                     // count+=2;
//                     candies.put(i, candies.get(i-1)+1);
//                 }else{ //rat[i-1]>rat[i]
//                     int prevCandy = candies.get(i-1);
//                     if(prevCandy>1){
//                         candies.put(i, prevCandy-1);
//                     }else{//prevCandy=1
//                         candies.put(i,prevCandy);
//                     }
//                 }
//             }
//             else{
//                 //1 2 3 //1--> 1 candy, 2--> 2 candy , 3--> candy
//                 if(ratings[i-1]<ratings[i] && ratings[i+1]>ratings[i]){
//                     // count+=2;
//                     candies.put(i, candies.get(i-1)+1);
//                 }
//                 //1 3 2 //1--> 1 candy, 3 --> 2 candy ,  2--> 1 candy
//                 else if(ratings[i-1] < ratings[i] && ratings[i]>ratings[i+1]){
//                     //i assume next prevCandy value is >1 so we are anyways going to do -1
//                     candies.put(i ,candies.get(i)+1);
//                 }
//                 //2 1 3
//                 else{
//                     //rat[i-1]>rat[i]
//                     int prevCandy = candies.get(i-1);
//                     if(prevCandy>1){
//                         candies.put(i, prevCandy-1);
//                     }else{//prevCandy=1
//                         candies.put(i,prevCandy);
//                     }
//                 }
//             }
//         }

//         int sum = 0;
//         for(int i=0; i<n; i++){
//             sum+=candies.getOrDefault(i,1);
//         }
//         return sum;



//         // unfortunately hashset only sums unique values which corrupts my answer
//         // // Get the set of values from the HashMap
//         // HashSet<Integer> valuesSet = new HashSet<>(candies.values());

//         // // Calculate the sum of values in the set
//         // int sum = 0;
//         // for (int value : valuesSet) {
//         //     sum += value;
//         // }
        
//         // return sum;

//     }
// }