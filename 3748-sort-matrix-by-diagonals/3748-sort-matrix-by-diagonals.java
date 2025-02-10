//Approahc -  1 : Correct hashmap based approach
import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] matrix) {
        // Map to store diagonals, where key is the difference of row and column index
        Map<Integer, List<Integer>> diagonalMap = new HashMap<>();
        int rows = matrix.length, cols = matrix[0].length;

        // Traverse the matrix and group elements by their diagonal (row - col)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int key = i - j;
                diagonalMap.putIfAbsent(key, new ArrayList<>());
                diagonalMap.get(key).add(matrix[i][j]);
            }
        }

        // Sort each diagonal: negative keys (upper diagonals) in ascending order,
        // positive keys (lower diagonals) in descending order
        for (Map.Entry<Integer, List<Integer>> entry : diagonalMap.entrySet()) {
            List<Integer> values = entry.getValue();
            if (entry.getKey() < 0) {
                Collections.sort(values);
            } else {
                values.sort(Collections.reverseOrder());
            }
        }

        // Populate the sorted values back into the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int key = i - j;
                matrix[i][j] = diagonalMap.get(key).remove(0);
            }
        }

        return matrix;
    }
}


// //Trying app-2 priority queue again
// import java.util.*;

// class Solution {
//     public int[][] sortMatrix(int[][] grid) {
//         int n = grid.length;
//         Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

//         // Step 1: Collect elements into diagonals using PriorityQueue
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 int key = i - j;
//                 // Use a max-heap for bottom-left diagonals (key <= 0)
//                 // Use a min-heap for top-right diagonals (key > 0)
//                 map.putIfAbsent(key, key > 0 ? new PriorityQueue<>() : new PriorityQueue<>(Collections.reverseOrder()));
//                 map.get(key).add(grid[i][j]);
//             }
//         }

//         // Step 2: Reinsert sorted elements back into the grid
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 int key = i - j;
//                 grid[i][j] = map.get(key).poll();
//             }
//         }

//         return grid;
//     }
// }

// // //Approach - 2 : Priority queue based approach
// // import java.util.*;

// // class Solution {
// //     public int[][] sortMatrix(int[][] grid) {
// //         int n = grid.length;
// //         Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

// //         for (int i = 0; i < n; i++) {
// //             for (int j = 0; j < n; j++) {
// //                 int key = i - j;
// //                 map.putIfAbsent(key, key > 0 ? new PriorityQueue<>() : new PriorityQueue<>(Collections.reverseOrder()));
// //                 map.get(key).add(grid[i][j]);
// //             }
// //         }

// //         for (int i = 0; i < n; i++) {
// //             for (int j = 0; j < n; j++) {
// //                 int key = i - j;
// //                 grid[i][j] = map.get(key).poll();
// //             }
// //         }

// //         return grid;
// //     }
// // }



// // //Fails
// // // //Approach - 1 : HashMap Based approach
// // // import java.util.*;

// // // class Solution {
// // //     public int[][] sortMatrix(int[][] grid) {
// // //         int n = grid.length;
// // //         Map<Integer, List<Integer>> map = new HashMap<>();

// // //         // Step 1: Collect elements into diagonals
// // //         for (int i = 0; i < n; i++) {
// // //             for (int j = 0; j < n; j++) {
// // //                 int key = i - j;
// // //                 map.putIfAbsent(key, new ArrayList<>());
// // //                 map.get(key).add(grid[i][j]);
// // //             }
// // //         }

// // //         // Step 2: Sort each diagonal
// // //         for (int key : map.keySet()) {
// // //             List<Integer> list = map.get(key);
// // //             if (key <= 0) {
// // //                 list.sort(Collections.reverseOrder()); // Descending for bottom-left
// // //             } else {
// // //                 Collections.sort(list); // Ascending for top-right
// // //             }
// // //         }

// // //         // Step 3: Reinsert sorted elements back into the grid
// // //         for (int i = 0; i < n; i++) {
// // //             for (int j = 0; j < n; j++) {
// // //                 int key = i - j;
// // //                 grid[i][j] = map.get(key).remove(0); // Remove first element
// // //             }
// // //         }

// // //         return grid;
// // //     }
// // // }



// // // // class Solution {
// // // //     public int[][] sortMatrix(int[][] grid) {
// // // //         int n = grid.length; //it is confirmed we have a n x n matrix
       
// // // //         //modification in approach
// // // //         //each coloumn can be identified by the fact that row-col is its identity
// // // //         Map<Integer, List<Integer>> map = new HashMap<>();

// // // //         //we are going to index each diag with (row-col) , and store it in list

// // // //         //Step - 1 : Traverse the array and do the indexing
// // // //         for(int i=0; i<n ; i++){
// // // //             for(int j=0; j<n; j++){
// // // //                 int key = i - j;
// // // //                 map.putIfAbsent(key, new ArrayList<>());
// // // //                 map.get(key).add(grid[i][j]);
// // // //                 //we are using add here since we are not 'put' in the map but we 'add' in the lisrt
// // // //             }
// // // //         }

// // // //         //Step 2 : Perform the sorting in the map
// // // //         //Logic : if key <= 0 then perform descending sorting algo
// // // //         //      : if key > 0  then perform ascending sorting algo
// // // //         for(int key : map.keySet()){
// // // //             List<Integer> list = map.get(key);
// // // //             if(key <= 0){
// // // //                 list.sort(Collections.reverseOrder());
// // // //                 // Collections.reverseOrder(list);
// // // //                 //interesting thing which i leant today is when the list varable is the real reference of the proper list contined for thee index of the key
// // // //             }
// // // //             else{
// // // //                 // list.sort(Collection.sort()); wront wrong wrong syntax
// // // //                 Collections.sort(list);
// // // //             }
// // // //         }

// // // //         //Step 3 : Now fill the new array with the new respectively sorted elements
// // // //         for(int i=0; i<n; i++){
// // // //             for(int j=0; j<n; j++){
// // // //                 int key = i - j;
// // // //                 List<Integer> list = map.get(i-j);
// // // //                 // grid[i][j] = map.get(key).get(0); //i have no idea why this doent work
// // // //                 // map.get(key).remove(0);
// // // //                 grid[i][j] = map.get(key).remove(0);
// // // //             }
// // // //         }

// // // //         return grid;
       
       
// // // //         // int m = grid[0].length;

// // // //         //there are n + 2 diagonals for a n x n matrix
        
// // // //         //we can create n+2 lists
// // // //         // ArrayList<Integer>[] list = new ArrayList[n+2];

// // // //         // int[][] arr = new int[n][n];

// // // //         // //arrays where we have to do decensing sort   
// // // //     }
// // // // }