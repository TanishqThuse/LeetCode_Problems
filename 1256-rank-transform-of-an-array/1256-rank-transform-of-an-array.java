
import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> valueToRank = new HashMap<>();  // Map to store value-to-rank mapping
        int[] sortedUniqueNumbers = Arrays.stream(arr).distinct().sorted().toArray();  // Remove duplicates and sort
        
        // Assign ranks to sorted unique elements
        for (int i = 0; i < sortedUniqueNumbers.length; i++) {
            valueToRank.put(sortedUniqueNumbers[i], i + 1);
        }

        // Replace each element in the original array with its rank
        for (int i = 0; i < arr.length; i++) {
            arr[i] = valueToRank.get(arr[i]);
        }

        return arr;  // Return the updated array
    }
}

// import java.util.*;

// class Solution {
//     public int[] arrayRankTransform(int[] arr) {
//         Map<Integer, Integer> valueToRank = new HashMap<>();  // Map to store value-to-rank mapping
//         int n = arr.length;
//         // int[] sortedUniqueNumbers = Arrays.stream(arr).distinct().sorted().toArray();  // Remove duplicates and sort
        
//          // Step 1: Create a copy of the array and sort it
//         int[] sortedArr = Arrays.copyOf(arr, n);
//         Arrays.sort(sortedArr);  // Sorting the copied array
//         int rank = 1;

//          // Assign rank to the first element
//         valueToRank.put(sortedArr[0], rank);

                
//         // Loop through sortedArr and assign ranks, avoiding duplicates
//         for (int i = 1; i < n; i++) {
//             if (sortedArr[i] != sortedArr[i - 1]) {  // If it's a new unique number
//                 rank++;
//             }
//             valueToRank.put(sortedArr[i], rank);  // Assign rank
//         }

//         // Assign ranks to sorted unique elements
//         for (int i = 0; i < sortedArr.length; i++) {
//             if(i>0 && sortedArr[i]!=sortedArr[i-1])
//             valueToRank.put(sortedArr[i], i + 1);
//             else{
//                 valueToRank.put(sortedArr[i], i);
//             }
//         }

//         // Replace each element in the original array with its rank
//         for (int i = 0; i < arr.length; i++) {
//             arr[i] = valueToRank.get(arr[i]);
//         }

//         return arr;  // Return the updated array
//     }
// }


// //WOrks but very bad Time compleexity
//     // class Solution {

//     //     public void AssignHashMap(HashMap<Integer, Integer> map, int rank, int[] arr){
//     //         int n = arr.length;
//     //         Arrays.sort(arr);
//     //         map.put(arr[0], rank);
//     //         for(int i=1; i<n; i++){
//     //             if(arr[i]>arr[i-1]){
//     //                 map.put(arr[i], ++rank);
//     //             }
//     //             else{
//     //                 map.put(arr[i], rank);
//     //             }
//     //         }
//     //     }

//     //     public int[] arrayRankTransform(int[] arr) {
//     //         int n = arr.length;
//     //         //we have to start by assigning the rank 1 to smallest element
//     //         int rank = 1;
//     //         int[] ranks = new int[n];

//     //         // int[] copy = arr.clone(); 


//     //         // ranks[0] = rank;
//     //         HashMap<Integer, Integer> map = new HashMap<>();

//     //         AssignHashMap(map, rank, Arrays.copyOf(arr,arr.length));

//     //         //simply now replace respective arr value by it's rank
//     //         for(int i=0; i<n; i++){
//     //             arr[i] = map.get(arr[i]);
//     //         }

//     //         return arr;

            

//     //         //now simply assin according to the sequence arr
//     //     }
//     // }